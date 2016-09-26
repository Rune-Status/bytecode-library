package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * ElementValuePairVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ElementValuePairVisitor extends BytecodeVisitor {
    public ElementValueVisitor visit(int index) throws IOException;
}
