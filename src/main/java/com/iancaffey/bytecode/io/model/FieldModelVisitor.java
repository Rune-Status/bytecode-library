package com.iancaffey.bytecode.io.model;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * FieldModelVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface FieldModelVisitor extends BytecodeVisitor {
    public void visit(int access, int nameIndex, int descriptorIndex);

    public AttributeModelVisitor visitAttributes(int count);
}
