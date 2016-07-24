package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeInfo;
import com.iancaffey.bytecode.ConstantPoolInfo;
import com.iancaffey.bytecode.FieldInfo;
import com.iancaffey.bytecode.MethodInfo;
import com.iancaffey.bytecode.util.BytecodeAdapter;
import com.iancaffey.bytecode.util.ClassInfoStep;
import com.iancaffey.bytecode.util.ClassReaderModel;
import com.iancaffey.bytecode.util.Type;
import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public final class ClassReader extends SequentialBytecodeReader<ClassReader, ClassVisitor, ClassReaderModel, ClassInfoStep> {
    private static ClassReaderModel classReaderModel;
    int magic;
    int major;
    int minor;
    ConstantPoolInfo[] constantPool;
    int constantPoolIndex;
    int access;
    String name;
    String superName;
    String[] interfaces;
    FieldInfo[] fields;
    int fieldsIndex;
    AttributeInfo[][] fieldAttributes;
    int[] fieldAttributeIndexes;
    MethodInfo[] methods;
    int methodsIndex;
    AttributeInfo[][] methodAttributes;
    int[] methodAttributeIndexes;
    AttributeInfo[] attributes;
    int attributesIndex;

    public ClassReader(byte[] b) {
        super(b, ClassReader.model());
    }

    public ClassReader(byte[] b, int offset, int length) {
        super(b, offset, length, ClassReader.model());
    }

    public ClassReader(InputStream stream) {
        super(stream, ClassReader.model());
    }

    public ClassReader(DataInputStream stream) {
        super(stream, ClassReader.model());
    }

    public static ClassReader of(Class<?> c) {
        if (c == null)
            throw new IllegalArgumentException();
        return new ClassReader(ClassLoader.getSystemResourceAsStream(Type.getInternalForm(c) + ".class"));
    }

    public static synchronized ClassReaderModel model() {
        if (classReaderModel == null) {
            Map<ClassInfoStep, BytecodeAdapter<ClassReader, ClassVisitor>> adapters = new HashMap<>();
            adapters.put(ClassInfoStep.MAGIC, new MagicAdapter());
            adapters.put(ClassInfoStep.VERSION, new VersionAdapter());
            adapters.put(ClassInfoStep.CONSTANT_POOL, new ConstantPoolAdapter());
            adapters.put(ClassInfoStep.ACCESS, new AccessAdapter());
            adapters.put(ClassInfoStep.INFO, new InfoAdapter());
            adapters.put(ClassInfoStep.PARENT_INFO, new ParentInfoAdapter());
            adapters.put(ClassInfoStep.INTERFACES, new InterfacesAdapter());
            adapters.put(ClassInfoStep.FIELDS, new FieldsAdapter());
            adapters.put(ClassInfoStep.METHODS, new MethodsAdapter());
            adapters.put(ClassInfoStep.ATTRIBUTES, new AttributesAdapter());
            Map<Integer, BytecodeAdapter<ClassReader, ClassVisitor>> constantPoolAdapters = new HashMap<>();
            constantPoolAdapters.put(ConstantPoolInfo.UTF8, new UTF8InfoAdapter());
            constantPoolAdapters.put(ConstantPoolInfo.INTEGER, new IntegerInfoAdapter());
            constantPoolAdapters.put(ConstantPoolInfo.FLOAT, new FloatInfoAdapter());
            constantPoolAdapters.put(ConstantPoolInfo.LONG, new LongInfoAdapter());
            constantPoolAdapters.put(ConstantPoolInfo.DOUBLE, new DoubleInfoAdapter());
            constantPoolAdapters.put(ConstantPoolInfo.CLASS, new ClassInfoAdapter());
            constantPoolAdapters.put(ConstantPoolInfo.STRING, new StringInfoAdapter());
            constantPoolAdapters.put(ConstantPoolInfo.FIELD_REFERENCE, new FieldReferenceInfoAdapter());
            constantPoolAdapters.put(ConstantPoolInfo.METHOD_REFERENCE, new MethodReferenceInfoAdapter());
            constantPoolAdapters.put(ConstantPoolInfo.INTERFACE_METHOD_REFERENCE, new InterfaceMethodReferenceInfoAdapter());
            constantPoolAdapters.put(ConstantPoolInfo.NAME_TYPE, new NameTypeInfoAdapter());
            constantPoolAdapters.put(ConstantPoolInfo.METHOD_HANDLE, new MethodHandleInfoAdapter());
            constantPoolAdapters.put(ConstantPoolInfo.METHOD_TYPE, new MethodTypeInfoAdapter());
            constantPoolAdapters.put(ConstantPoolInfo.INVOKE_DYNAMIC, new InvokeDynamicInfoAdapter());
            BytecodeAdapter<ClassReader, ClassVisitor> fieldAdapter = new FieldInfoAdapter();
            BytecodeAdapter<ClassReader, ClassVisitor> methodAdapter = new MethodInfoAdapter();
            BytecodeAdapter<ClassReader, ClassVisitor> classAttributeAdapter = new AttributeInfoAdapter();
            BytecodeAdapter<ClassReader, ClassVisitor> fieldAttributeAdapter = new FieldAttributeInfoAdapter();
            BytecodeAdapter<ClassReader, ClassVisitor> methodAttributeAdapter = new MethodAttributeInfoAdapter();
            classReaderModel = new ClassReaderModel(ClassInfoStep.values(), adapters, constantPoolAdapters, fieldAdapter,
                    methodAdapter, classAttributeAdapter, fieldAttributeAdapter, methodAttributeAdapter);
        }
        return classReaderModel;
    }

    @Override
    protected ClassReader getThis() {
        return this;
    }
}
