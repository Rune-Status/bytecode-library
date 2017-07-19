package com.iancaffey.bytecode.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.model.AttributeModelVisitor;
import com.iancaffey.bytecode.model.ClassModelVisitor;
import com.iancaffey.bytecode.model.attribute.AnnotationHandler;
import com.iancaffey.bytecode.model.attribute.AnnotationVisitor;

import java.io.IOException;

/**
 * RuntimeInvisibleAnnotationsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RuntimeInvisibleAnnotationsHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor, int nameIndex, int length) throws IOException {
        int count = reader.readUnsignedShort();
        AnnotationVisitor annotationVisitor = visitor.visitRuntimeInvisibleAnnotations(nameIndex, length, count);
        for (int i = 0; i < count; i++) {
            AnnotationHandler.accept(reader, annotationVisitor);
        }
    }
}
