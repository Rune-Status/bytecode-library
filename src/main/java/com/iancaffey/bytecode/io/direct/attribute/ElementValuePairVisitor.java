package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * ElementValuePairVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ElementValuePairVisitor extends BytecodeVisitor {
    public ElementValueVisitor visit(int index);
}
