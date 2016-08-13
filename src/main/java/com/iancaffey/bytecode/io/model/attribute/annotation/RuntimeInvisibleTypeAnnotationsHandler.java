package com.iancaffey.bytecode.io.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.model.AttributeModelVisitor;
import com.iancaffey.bytecode.io.model.ClassModelVisitor;

import java.io.IOException;

/**
 * RuntimeInvisibleTypeAnnotationsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RuntimeInvisibleTypeAnnotationsHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        TypeAnnotationVisitor typeAnnotationVisitor = visitor.visitRuntimeInvisibleTypeAnnotations(count);
        for (int i = 0; i < count; i++)
            TypeAnnotationHandler.accept(reader, typeAnnotationVisitor);
    }
}
