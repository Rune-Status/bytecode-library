package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * InnerClassVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface InnerClassVisitor extends BytecodeVisitor {
    public void visit(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex, int innerClassAccess);
}
