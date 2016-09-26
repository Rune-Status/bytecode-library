package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * ParameterAnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ParameterAnnotationVisitor extends BytecodeVisitor {
    public AnnotationVisitor visitAnnotations(int count) throws IOException;
}
