package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * ParameterAnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ParameterAnnotationVisitor extends BytecodeVisitor {
    public AnnotationVisitor visitAnnotations(int count);
}
