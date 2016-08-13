package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * LocalVariableVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface LocalVariableVisitor extends BytecodeVisitor {
    public void visit(int startIndex, int length, int nameIndex, int descriptorIndex, int index);
}
