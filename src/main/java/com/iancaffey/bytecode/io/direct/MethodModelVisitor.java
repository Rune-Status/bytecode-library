package com.iancaffey.bytecode.io.direct;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * MethodModelVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface MethodModelVisitor extends BytecodeVisitor {
    public void visit(int access, int nameIndex, int descriptorIndex);

    public AttributeModelVisitor visitAttributes(int count);
}
