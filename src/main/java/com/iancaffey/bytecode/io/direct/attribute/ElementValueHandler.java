package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.ClassVisitor;

import java.io.IOException;

/**
 * ElementValueHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ElementValueHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, ElementValueVisitor visitor) throws IOException {
        int tag = reader.readUnsignedByte();
        switch (tag) {
            case 'B':
                visitor.visitByte(reader.readUnsignedShort());
                break;
            case 'C':
                visitor.visitCharacter(reader.readUnsignedShort());
                break;
            case 'D':
                visitor.visitDouble(reader.readUnsignedShort());
                break;
            case 'F':
                visitor.visitFloat(reader.readUnsignedShort());
                break;
            case 'I':
                visitor.visitInteger(reader.readUnsignedShort());
                break;
            case 'J':
                visitor.visitLong(reader.readUnsignedShort());
                break;
            case 'S':
                visitor.visitShort(reader.readUnsignedShort());
                break;
            case 'Z':
                visitor.visitBoolean(reader.readUnsignedShort());
                break;
            case 's':
                visitor.visitString(reader.readUnsignedShort());
                break;
            case 'e':
                visitor.visitEnum(reader.readUnsignedShort(), reader.readUnsignedShort());
                break;
            case 'c':
                visitor.visitClass(reader.readUnsignedShort());
                break;
            case '@':
                AnnotationVisitor annotationVisitor = visitor.visitAnnotation();
                AnnotationHandler.accept(reader, annotationVisitor);
                break;
            case '[':
                int count = reader.readUnsignedShort();
                ElementValueVisitor elementValueVisitor = visitor.visitArray(count);
                ElementValueHandler.accept(reader, elementValueVisitor);
                break;
            default:
                throw new IllegalStateException("Unable to locate handler for element value: " + (char) tag);
        }
    }
}
