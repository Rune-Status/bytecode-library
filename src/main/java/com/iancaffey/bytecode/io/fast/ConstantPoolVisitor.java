package com.iancaffey.bytecode.io.fast;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * ConstantPoolVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ConstantPoolVisitor extends BytecodeVisitor {
    public void visit(int index, int offset);
}
