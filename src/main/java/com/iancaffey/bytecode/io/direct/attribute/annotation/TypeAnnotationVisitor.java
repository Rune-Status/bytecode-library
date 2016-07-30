package com.iancaffey.bytecode.io.direct.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeVisitor;
import com.iancaffey.bytecode.io.direct.attribute.AnnotationVisitor;

/**
 * TypeAnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface TypeAnnotationVisitor extends BytecodeVisitor {
    public TypeTargetVisitor visitTarget();

    public TypePathVisitor visitPath(int count);

    public AnnotationVisitor visitAnnotation();
}
