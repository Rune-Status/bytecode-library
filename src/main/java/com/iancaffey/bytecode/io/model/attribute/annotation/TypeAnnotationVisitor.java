package com.iancaffey.bytecode.io.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeVisitor;
import com.iancaffey.bytecode.io.model.attribute.AnnotationVisitor;

import java.io.IOException;

/**
 * TypeAnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface TypeAnnotationVisitor extends BytecodeVisitor {
    public TypeTargetVisitor visitTarget() throws IOException;

    public TypePathVisitor visitPath(int count) throws IOException;

    public AnnotationVisitor visitAnnotation() throws IOException;
}
