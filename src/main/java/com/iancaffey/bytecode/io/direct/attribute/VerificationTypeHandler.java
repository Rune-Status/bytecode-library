package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.ClassModelVisitor;

import java.io.IOException;

/**
 * VerificationTypeHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class VerificationTypeHandler {
    public static final int TOP = 0;
    public static final int INTEGER = 1;
    public static final int FLOAT = 2;
    public static final int DOUBLE = 3;
    public static final int LONG = 4;
    public static final int NULL = 5;
    public static final int UNINITIALIZED_THIS = 6;
    public static final int OBJECT = 7;
    public static final int UNINITIALIZED = 8;

    public static void accept(BytecodeReader<ClassModelVisitor> reader, VerificationTypeVisitor visitor) throws IOException {
        int tag = reader.readUnsignedByte();
        switch (tag) {
            case TOP:
                visitor.visitTop();
                break;
            case INTEGER:
                visitor.visitInteger();
                break;
            case FLOAT:
                visitor.visitFloat();
                break;
            case DOUBLE:
                visitor.visitDouble();
                break;
            case LONG:
                visitor.visitLong();
                break;
            case NULL:
                visitor.visitNull();
                break;
            case UNINITIALIZED_THIS:
                visitor.visitUninitializedThis();
                break;
            case OBJECT:
                visitor.visitObject(reader.readUnsignedShort());
                break;
            case UNINITIALIZED:
                visitor.visitUninitialized(reader.readUnsignedShort());
                break;
            default:
                throw new IllegalStateException("Unable to locate handler for verification type info entry: " + tag);
        }
    }
}
