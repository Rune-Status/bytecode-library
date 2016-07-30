package com.iancaffey.bytecode.io.direct;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * ConstantPoolHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ConstantPoolHandler {
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

    public static void accept(BytecodeReader<ClassVisitor> reader, ClassVisitor visitor, ConstantPoolCache cache) throws IOException {
        int count = reader.readUnsignedShort();
        ConstantPoolVisitor constantPoolVisitor = visitor.visitConstantPool(count);
        cache.strings = new String[count];
        for (int i = 1; i < count; i++) {
            cache.index = i;
            int tag = reader.readUnsignedByte();
            switch (tag) {
                case UTF8:
                    String value = reader.readUTF();
                    cache.strings[cache.index] = value;
                    constantPoolVisitor.visitUTF8(value);
                    break;
                case INTEGER:
                    constantPoolVisitor.visitInteger(reader.readInt());
                    break;
                case FLOAT:
                    constantPoolVisitor.visitFloat(reader.readFloat());
                    break;
                case LONG:
                    constantPoolVisitor.visitLong(reader.readLong());
                    i++;
                    break;
                case DOUBLE:
                    constantPoolVisitor.visitDouble(reader.readDouble());
                    i++;
                    break;
                case CLASS:
                    constantPoolVisitor.visitClass(reader.readUnsignedShort());
                    break;
                case STRING:
                    constantPoolVisitor.visitString(reader.readUnsignedShort());
                    break;
                case FIELD_REFERENCE:
                    constantPoolVisitor.visitFieldReference(reader.readUnsignedShort(), reader.readUnsignedShort());
                    break;
                case METHOD_REFERENCE:
                    constantPoolVisitor.visitMethodReference(reader.readUnsignedShort(), reader.readUnsignedShort());
                    break;
                case INTERFACE_METHOD_REFERENCE:
                    constantPoolVisitor.visitInterfaceMethodReference(reader.readUnsignedShort(), reader.readUnsignedShort());
                    break;
                case NAME_TYPE:
                    constantPoolVisitor.visitNameType(reader.readUnsignedShort(), reader.readUnsignedShort());
                    break;
                case METHOD_HANDLE:
                    constantPoolVisitor.visitMethodHandle(reader.readUnsignedByte(), reader.readUnsignedShort());
                    break;
                case METHOD_TYPE:
                    constantPoolVisitor.visitMethodType(reader.readUnsignedShort());
                    break;
                case INVOKE_DYNAMIC:
                    constantPoolVisitor.visitInvokeDynamic(reader.readUnsignedShort(), reader.readUnsignedShort());
                    break;
                default:
                    throw new IllegalStateException("Unable to locate handler for constant pool info entry: " + tag);
            }
        }
    }
}