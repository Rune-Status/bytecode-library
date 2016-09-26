package com.iancaffey.bytecode.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.model.ClassModelVisitor;
import com.iancaffey.bytecode.model.attribute.AnnotationVisitor;
import com.iancaffey.bytecode.model.attribute.ElementValueHandler;
import com.iancaffey.bytecode.model.attribute.ElementValuePairVisitor;
import com.iancaffey.bytecode.model.attribute.target.*;

import java.io.IOException;

/**
 * TypeAnnotationHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class TypeAnnotationHandler {
    public static final int GENERIC_CLASS_TYPE_PARAMETER = 0x00;
    public static final int GENERIC_METHOD_TYPE_PARAMETER = 0x01;
    public static final int EXTENDS_TYPE_PARAMETER = 0x10;
    public static final int GENERIC_CLASS_TYPE_PARAMETER_BOUND = 0x11;
    public static final int GENERIC_METHOD_TYPE_PARAMETER_BOUND = 0x12;
    public static final int FIELD_TYPE = 0x13;
    public static final int RETURN_TYPE = 0x14;
    public static final int CONSTRUCTOR_RECEIVER_TYPE = 0x15;
    public static final int FORMAL_PARAMETER_TYPE = 0x16;
    public static final int THROWS_TYPE = 0x17;
    public static final int LOCAL_VARAIBLE_TYPE = 0x40;
    public static final int RESOURCE_VARIABLE_TYPE = 0x41;
    public static final int EXCEPTION_PARAMETER_TYPE = 0x42;
    public static final int INSTANCEOF_TYPE = 0x43;
    public static final int NEW_TYPE = 0x44;
    public static final int NEW_METHOD_REFERENCE_TYPE = 0x45;
    public static final int IDENTIFIER_METHOD_REFERENCE_TYPE = 0x46;
    public static final int CAST_TYPE = 0x47;
    public static final int CONSTRUCTOR_PARAMETER_TYPE = 0x48;
    public static final int METHOD_PARAMETER_TYPE = 0x49;
    public static final int NEW_METHOD_REFERENCE_CONSTRUCTOR_PARAMETER_TYPE = 0x4A;
    public static final int IDENTIFIER_METHOD_REFERENCE_METHOD_PARAMETER_TYPE = 0x4B;

    public static void accept(BytecodeReader<ClassModelVisitor> reader, TypeAnnotationVisitor visitor) throws IOException {
        int tag = reader.readUnsignedByte();
        switch (tag) {
            case GENERIC_CLASS_TYPE_PARAMETER:
            case GENERIC_METHOD_TYPE_PARAMETER:
                TypeParameterHandler.accept(reader, visitor.visitTarget());
                break;
            case EXTENDS_TYPE_PARAMETER:
                SuperTypeHandler.accept(reader, visitor.visitTarget());
                break;
            case GENERIC_CLASS_TYPE_PARAMETER_BOUND:
            case GENERIC_METHOD_TYPE_PARAMETER_BOUND:
                TypeParameterBoundHandler.accept(reader, visitor.visitTarget());
                break;
            case FIELD_TYPE:
            case RETURN_TYPE:
            case CONSTRUCTOR_RECEIVER_TYPE:
                EmptyHandler.accept(visitor.visitTarget());
                break;
            case FORMAL_PARAMETER_TYPE:
                FormalParameterHandler.accept(reader, visitor.visitTarget());
                break;
            case THROWS_TYPE:
                ThrowsHandler.accept(reader, visitor.visitTarget());
                break;
            case LOCAL_VARAIBLE_TYPE:
            case RESOURCE_VARIABLE_TYPE:
                LocalVariableHandler.accept(reader, visitor.visitTarget());
                break;
            case EXCEPTION_PARAMETER_TYPE:
                CatchHandler.accept(reader, visitor.visitTarget());
                break;
            case INSTANCEOF_TYPE:
            case NEW_TYPE:
            case NEW_METHOD_REFERENCE_TYPE:
            case IDENTIFIER_METHOD_REFERENCE_TYPE:
                OffsetHandler.accept(reader, visitor.visitTarget());
                break;
            case CAST_TYPE:
            case CONSTRUCTOR_PARAMETER_TYPE:
            case METHOD_PARAMETER_TYPE:
            case NEW_METHOD_REFERENCE_CONSTRUCTOR_PARAMETER_TYPE:
            case IDENTIFIER_METHOD_REFERENCE_METHOD_PARAMETER_TYPE:
                TypeArgumentHandler.accept(reader, visitor.visitTarget());
                break;
            default:
                throw new IllegalStateException("Unable to locate handler for type annotation: " + tag);
        }
        int length = reader.readUnsignedByte();
        TypePathVisitor typePathVisitor = visitor.visitPath(length);
        for (int i = 0; i < length; i++)
            typePathVisitor.visit(reader.readUnsignedByte(), reader.readUnsignedByte());
        AnnotationVisitor annotationVisitor = visitor.visitAnnotation();
        int typeIndex = reader.readUnsignedShort();
        int valueCount = reader.readUnsignedShort();
        ElementValuePairVisitor elementValuePairVisitor = annotationVisitor.visit(typeIndex, valueCount);
        for (int i = 0; i < valueCount; i++)
            ElementValueHandler.accept(reader, elementValuePairVisitor.visit(reader.readUnsignedShort()));
    }
}
