package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * LineNumberInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface LineNumberInfoVisitor extends BytecodeVisitor {
    public void visit(int startIndex, int number);
}
