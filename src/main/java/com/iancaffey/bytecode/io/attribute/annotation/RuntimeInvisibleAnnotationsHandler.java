package com.iancaffey.bytecode.io.attribute.annotation;

import com.iancaffey.bytecode.AnnotationVisitor;
import com.iancaffey.bytecode.AttributeVisitor;
import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * RuntimeInvisibleAnnotationsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RuntimeInvisibleAnnotationsHandler implements AttributeHandler {
    private final BytecodeHandler<ClassReader, AnnotationVisitor> handler;

    public RuntimeInvisibleAnnotationsHandler(BytecodeHandler<ClassReader, AnnotationVisitor> handler) {
        this.handler = handler;
    }

    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        int count = reader.readUnsignedShort();
        AnnotationVisitor annotationVisitor = visitor.visitRuntimeInvisibleAnnotations(count);
        annotationVisitor.begin();
        for (int i = 0; i < count; i++)
            handler.accept(reader, annotationVisitor);
        annotationVisitor.end();
    }
}
