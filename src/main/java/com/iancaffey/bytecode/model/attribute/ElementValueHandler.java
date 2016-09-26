package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.model.ClassModelVisitor;

import java.io.IOException;

/**
 * ElementValueHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ElementValueHandler {
    public static final byte BYTE = 'B';
    public static final byte CHARACTER = 'C';
    public static final byte DOUBLE = 'D';
    public static final byte FLOAT = 'F';
    public static final byte INTEGER = 'I';
    public static final byte LONG = 'J';
    public static final byte SHORT = 'S';
    public static final byte BOOLEAN = 'Z';
    public static final byte STRING = 's';
    public static final byte ENUM = 'e';
    public static final byte CLASS = 'c';
    public static final byte ANNOTATION = '@';
    public static final byte ARRAY = '[';

    public static void accept(BytecodeReader<ClassModelVisitor> reader, ElementValueVisitor visitor) throws IOException {
        int tag = reader.readUnsignedByte();
        switch (tag) {
            case BYTE:
                visitor.visitByte(reader.readUnsignedShort());
                break;
            case CHARACTER:
                visitor.visitCharacter(reader.readUnsignedShort());
                break;
            case DOUBLE:
                visitor.visitDouble(reader.readUnsignedShort());
                break;
            case FLOAT:
                visitor.visitFloat(reader.readUnsignedShort());
                break;
            case INTEGER:
                visitor.visitInteger(reader.readUnsignedShort());
                break;
            case LONG:
                visitor.visitLong(reader.readUnsignedShort());
                break;
            case SHORT:
                visitor.visitShort(reader.readUnsignedShort());
                break;
            case BOOLEAN:
                visitor.visitBoolean(reader.readUnsignedShort());
                break;
            case STRING:
                visitor.visitString(reader.readUnsignedShort());
                break;
            case ENUM:
                visitor.visitEnum(reader.readUnsignedShort(), reader.readUnsignedShort());
                break;
            case CLASS:
                visitor.visitClass(reader.readUnsignedShort());
                break;
            case ANNOTATION:
                AnnotationVisitor annotationVisitor = visitor.visitAnnotation();
                AnnotationHandler.accept(reader, annotationVisitor);
                break;
            case ARRAY:
                int count = reader.readUnsignedShort();
                ElementValueVisitor elementValueVisitor = visitor.visitArray(count);
                ElementValueHandler.accept(reader, elementValueVisitor);
                break;
            default:
                throw new IllegalStateException("Unable to locate handler for element value: " + (char) tag);
        }
    }
}
