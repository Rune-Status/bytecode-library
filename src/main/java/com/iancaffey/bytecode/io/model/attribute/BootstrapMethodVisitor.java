package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * BootstrapMethodVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface BootstrapMethodVisitor extends BytecodeVisitor {
    public void visit(int index, int[] argumentIndexes) throws IOException;
}
