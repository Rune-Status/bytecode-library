package com.iancaffey.bytecode.lang;

import com.iancaffey.bytecode.ConstantPoolInfo;
import com.iancaffey.bytecode.io.*;
import com.iancaffey.bytecode.util.ClassInterval;
import com.iancaffey.bytecode.util.Interval;
import com.sun.org.apache.bcel.internal.util.ClassLoader;
import jdk.nashorn.internal.codegen.types.Type;

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
public class ClassReader extends BytecodeReader<ClassModel, ClassVisitor> {
    private static BytecodeController<BytecodeReader<ClassModel, ClassVisitor>, ClassVisitor> controller;

    public ClassReader(byte[] data) {
        super(data, ClassReader.controller(), new ClassModel());
    }

    public ClassReader(byte[] data, int offset, int length) {
        super(data, offset, length, ClassReader.controller(), new ClassModel());
    }

    public ClassReader(InputStream stream) {
        super(stream, ClassReader.controller(), new ClassModel());
    }

    public ClassReader(DataInputStream stream) {
        super(stream, ClassReader.controller(), new ClassModel());
    }

    public static ClassReader of(Class<?> c) {
        return new ClassReader(ClassLoader.getSystemResourceAsStream(Type.getInternalName(c) + ".class"));
    }

    public static synchronized BytecodeController<BytecodeReader<ClassModel, ClassVisitor>, ClassVisitor> controller() {
        if (controller == null) {
            Map<Integer, BytecodeHandler<BytecodeReader<ClassModel, ClassVisitor>, ClassVisitor>> constantPoolAdapters = new HashMap<>();
            constantPoolAdapters.put(ConstantPoolInfo.UTF8, new UTF8InfoHandler());
            constantPoolAdapters.put(ConstantPoolInfo.INTEGER, new IntegerInfoHandler());
            constantPoolAdapters.put(ConstantPoolInfo.FLOAT, new FloatInfoHandler());
            constantPoolAdapters.put(ConstantPoolInfo.LONG, new LongInfoHandler());
            constantPoolAdapters.put(ConstantPoolInfo.DOUBLE, new DoubleInfoHandler());
            constantPoolAdapters.put(ConstantPoolInfo.CLASS, new ClassInfoHandler());
            constantPoolAdapters.put(ConstantPoolInfo.STRING, new StringInfoHandler());
            constantPoolAdapters.put(ConstantPoolInfo.FIELD_REFERENCE, new FieldReferenceInfoHandler());
            constantPoolAdapters.put(ConstantPoolInfo.METHOD_REFERENCE, new MethodReferenceInfoHandler());
            constantPoolAdapters.put(ConstantPoolInfo.INTERFACE_METHOD_REFERENCE, new InterfaceMethodReferenceInfoHandler());
            constantPoolAdapters.put(ConstantPoolInfo.NAME_TYPE, new NameTypeInfoHandler());
            constantPoolAdapters.put(ConstantPoolInfo.METHOD_HANDLE, new MethodHandleInfoHandler());
            constantPoolAdapters.put(ConstantPoolInfo.METHOD_TYPE, new MethodTypeInfoHandler());
            constantPoolAdapters.put(ConstantPoolInfo.INVOKE_DYNAMIC, new InvokeDynamicInfoHandler());
            Map<Interval, BytecodeHandler<BytecodeReader<ClassModel, ClassVisitor>, ClassVisitor>> adapters = new HashMap<>();
            adapters.put(ClassInterval.MAGIC, new MagicHandler());
            adapters.put(ClassInterval.VERSION, new VersionHandler());
            adapters.put(ClassInterval.CONSTANT_POOL, new ConstantPoolHandler(constantPoolAdapters));
            adapters.put(ClassInterval.ACCESS, new AccessHandler());
            adapters.put(ClassInterval.INFO, new InfoHandler());
            adapters.put(ClassInterval.PARENT_INFO, new ParentInfoHandler());
            adapters.put(ClassInterval.INTERFACES, new InterfacesHandler());
            adapters.put(ClassInterval.FIELDS, new FieldsHandler(new FieldInfoHandler()));
            adapters.put(ClassInterval.METHODS, new MethodsHandler(new MethodInfoHandler()));
            adapters.put(ClassInterval.ATTRIBUTES, new AttributesHandler(new AttributeInfoHandler()));
            controller = new BytecodeController<>(ClassInterval.values(), adapters);
        }
        return controller;
    }

}
