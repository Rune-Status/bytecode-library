package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * LineNumberInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface LineNumberInfoVisitor extends BytecodeVisitor {
    public void visit(int startIndex, int number) throws IOException;
}
