package com.iancaffey.bytecode.io.direct.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.AttributeVisitor;
import com.iancaffey.bytecode.io.direct.ClassVisitor;
import com.iancaffey.bytecode.io.direct.attribute.AnnotationHandler;
import com.iancaffey.bytecode.io.direct.attribute.ParameterAnnotationVisitor;

import java.io.IOException;

/**
 * RuntimeInvisibleParameterAnnotationsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RuntimeInvisibleParameterAnnotationsHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, AttributeVisitor visitor) throws IOException {
        int count = reader.readUnsignedByte();
        ParameterAnnotationVisitor parameterAnnotationVisitor = visitor.visitRuntimeInvisibleParameterAnnotations(count);
        for (int i = 0; i < count; i++)
            AnnotationHandler.accept(reader, parameterAnnotationVisitor.visitAnnotations(reader.readUnsignedShort()));
    }
}
