package com.iancaffey.bytecode.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.model.AttributeModelVisitor;
import com.iancaffey.bytecode.model.ClassModelVisitor;
import com.iancaffey.bytecode.model.attribute.AnnotationHandler;
import com.iancaffey.bytecode.model.attribute.ParameterAnnotationVisitor;

import java.io.IOException;

/**
 * RuntimeVisibleParameterAnnotationsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RuntimeVisibleParameterAnnotationsHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor, int nameIndex, int length) throws IOException {
        int count = reader.readUnsignedByte();
        ParameterAnnotationVisitor parameterAnnotationVisitor = visitor.visitRuntimeVisibleParameterAnnotations(nameIndex, length, count);
        for (int i = 0; i < count; i++)
            AnnotationHandler.accept(reader, parameterAnnotationVisitor.visitAnnotations(reader.readUnsignedShort()));
    }
}
