package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.IOException;

/**
 * ParameterAnnotationWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ParameterAnnotationWriter extends BytecodeWriter implements ParameterAnnotationVisitor {
    @Override
    public AnnotationVisitor visitAnnotations(int count) throws IOException {
        return null;
    }
}
