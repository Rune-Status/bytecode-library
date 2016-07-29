package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.io.constant.*;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * ConstantPoolHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ConstantPoolHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    public static final int UTF8 = 1;
    public static final int INTEGER = 3;
    public static final int FLOAT = 4;
    public static final int LONG = 5;
    public static final int DOUBLE = 6;
    public static final int CLASS = 7;
    public static final int STRING = 8;
    public static final int FIELD_REFERENCE = 9;
    public static final int METHOD_REFERENCE = 10;
    public static final int INTERFACE_METHOD_REFERENCE = 11;
    public static final int NAME_TYPE = 12;
    public static final int METHOD_HANDLE = 15;
    public static final int METHOD_TYPE = 16;
    public static final int INVOKE_DYNAMIC = 18;
    private static final int INFO_HANDLER_SIZE = INVOKE_DYNAMIC + 1;
    private final BytecodeHandler<ClassReader, ConstantPoolVisitor>[] handlers;
    private final ConstantPoolCache cache;

    public ConstantPoolHandler(ConstantPoolCache cache) {
        this.cache = cache;
        this.handlers = new BytecodeHandler[INFO_HANDLER_SIZE];
        handlers[ConstantPoolHandler.UTF8] = new UTF8InfoHandler(cache);
        handlers[ConstantPoolHandler.INTEGER] = new IntegerInfoHandler();
        handlers[ConstantPoolHandler.FLOAT] = new FloatInfoHandler();
        handlers[ConstantPoolHandler.LONG] = new LongInfoHandler();
        handlers[ConstantPoolHandler.DOUBLE] = new DoubleInfoHandler();
        handlers[ConstantPoolHandler.CLASS] = new ClassInfoHandler();
        handlers[ConstantPoolHandler.STRING] = new StringInfoHandler();
        handlers[ConstantPoolHandler.FIELD_REFERENCE] = new FieldReferenceInfoHandler();
        handlers[ConstantPoolHandler.METHOD_REFERENCE] = new MethodReferenceInfoHandler();
        handlers[ConstantPoolHandler.INTERFACE_METHOD_REFERENCE] = new InterfaceMethodReferenceInfoHandler();
        handlers[ConstantPoolHandler.NAME_TYPE] = new NameTypeInfoHandler();
        handlers[ConstantPoolHandler.METHOD_HANDLE] = new MethodHandleInfoHandler();
        handlers[ConstantPoolHandler.METHOD_TYPE] = new MethodTypeInfoHandler();
        handlers[ConstantPoolHandler.INVOKE_DYNAMIC] = new InvokeDynamicInfoHandler();
    }

    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        ConstantPoolVisitor constantPoolVisitor = visitor.visitConstantPool(count);
        constantPoolVisitor.begin();
        cache.strings = new String[count];
        for (int i = 1; i < count; i++) {
            cache.index = i;
            int tag = reader.readUnsignedByte();
            if (tag >= handlers.length || handlers[tag] == null)
                throw new IllegalStateException("Unable to locate handler for constant pool info entry: " + tag);
            handlers[tag].accept(reader, constantPoolVisitor);
            if (tag == ConstantPoolHandler.LONG || tag == ConstantPoolHandler.DOUBLE)
                i++;
        }
        constantPoolVisitor.end();
    }
}