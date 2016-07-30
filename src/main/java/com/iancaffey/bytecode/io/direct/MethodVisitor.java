package com.iancaffey.bytecode.io.direct;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * MethodVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface MethodVisitor extends BytecodeVisitor {
    public void visit(int access, int nameIndex, int descriptorIndex);

    public AttributeVisitor visitAttributes(int count);
}
