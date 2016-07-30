package com.iancaffey.bytecode.io.direct;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * FieldVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface FieldVisitor extends BytecodeVisitor {
    public void visit(int access, int nameIndex, int descriptorIndex);

    public AttributeVisitor visitAttributes(int count);
}
