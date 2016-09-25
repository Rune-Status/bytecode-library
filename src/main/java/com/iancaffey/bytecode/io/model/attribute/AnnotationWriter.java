package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.IOException;

/**
 * AnnotationWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AnnotationWriter extends BytecodeWriter implements AnnotationVisitor {
    @Override
    public ElementValuePairVisitor visit(int typeIndex, int count) throws IOException {
        return null;
    }
}
