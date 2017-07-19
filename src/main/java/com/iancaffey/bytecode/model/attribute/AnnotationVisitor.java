package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * AnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface AnnotationVisitor extends BytecodeVisitor {
    ElementValuePairVisitor visit(int typeIndex, int count) throws IOException;
}
