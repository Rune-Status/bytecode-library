package com.iancaffey.bytecode.lang;

import com.iancaffey.bytecode.ConstantPoolInfo;
import com.iancaffey.bytecode.io.*;
import com.iancaffey.bytecode.util.Type;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassReader extends BytecodeReader<ClassVisitor> {
    private static BytecodeHandler<ClassReader, ClassVisitor> controller;
    public final ClassModel model;

    public ClassReader(byte[] data) {
        super(data);
        this.model = new ClassModel();
    }

    public ClassReader(byte[] data, int offset, int length) {
        super(data, offset, length);
        this.model = new ClassModel();
    }

    public ClassReader(InputStream stream) {
        super(stream);
        this.model = new ClassModel();
    }

    public static ClassReader of(Class<?> c) {
        return new ClassReader(ClassLoader.getSystemResourceAsStream(Type.getInternalForm(c) + ".class"));
    }

    public static synchronized BytecodeHandler<ClassReader, ClassVisitor> handler() {
        if (controller == null) {
            Map<Integer, BytecodeHandler<ClassReader, ClassVisitor>> handlers = new HashMap<>();
            handlers.put(ConstantPoolInfo.UTF8, new UTF8InfoHandler());
            handlers.put(ConstantPoolInfo.INTEGER, new IntegerInfoHandler());
            handlers.put(ConstantPoolInfo.FLOAT, new FloatInfoHandler());
            handlers.put(ConstantPoolInfo.LONG, new LongInfoHandler());
            handlers.put(ConstantPoolInfo.DOUBLE, new DoubleInfoHandler());
            handlers.put(ConstantPoolInfo.CLASS, new ClassInfoHandler());
            handlers.put(ConstantPoolInfo.STRING, new StringInfoHandler());
            handlers.put(ConstantPoolInfo.FIELD_REFERENCE, new FieldReferenceInfoHandler());
            handlers.put(ConstantPoolInfo.METHOD_REFERENCE, new MethodReferenceInfoHandler());
            handlers.put(ConstantPoolInfo.INTERFACE_METHOD_REFERENCE, new InterfaceMethodReferenceInfoHandler());
            handlers.put(ConstantPoolInfo.NAME_TYPE, new NameTypeInfoHandler());
            handlers.put(ConstantPoolInfo.METHOD_HANDLE, new MethodHandleInfoHandler());
            handlers.put(ConstantPoolInfo.METHOD_TYPE, new MethodTypeInfoHandler());
            handlers.put(ConstantPoolInfo.INVOKE_DYNAMIC, new InvokeDynamicInfoHandler());
            controller = BytecodeHandler.of(new MagicHandler(),
                    new VersionHandler(),
                    new ConstantPoolHandler(handlers),
                    new AccessHandler(),
                    new InfoHandler(),
                    new ParentInfoHandler(),
                    new InterfacesHandler(),
                    new FieldsHandler(),
                    new MethodsHandler(),
                    new AttributesHandler());
        }
        return controller;
    }

    @Override
    public ClassReader accept(ClassVisitor visitor) throws IOException {
        ClassReader.handler().accept(this, visitor);
        return this;
    }
}
