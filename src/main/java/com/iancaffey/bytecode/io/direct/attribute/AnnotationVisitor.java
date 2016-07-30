package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * AnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface AnnotationVisitor extends BytecodeVisitor {
    public ElementValuePairVisitor visit(int typeIndex, int count);
}
