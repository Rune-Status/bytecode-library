package com.iancaffey.bytecode.io.attribute.element;

import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.io.attribute.AnnotationVisitor;
import com.iancaffey.bytecode.io.attribute.ElementValueVisitor;

import java.io.IOException;

/**
 * AnnotationValueHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AnnotationValueHandler implements BytecodeHandler<ClassReader, ElementValueVisitor> {
    private final BytecodeHandler<ClassReader, AnnotationVisitor> handler;

    public AnnotationValueHandler(BytecodeHandler<ClassReader, AnnotationVisitor> handler) {
        this.handler = handler;
    }

    @Override
    public void accept(ClassReader reader, ElementValueVisitor visitor) throws IOException {
        AnnotationVisitor annotationVisitor = visitor.visitAnnotation();
        annotationVisitor.begin();
        handler.accept(reader, annotationVisitor);
        annotationVisitor.end();
    }
}
