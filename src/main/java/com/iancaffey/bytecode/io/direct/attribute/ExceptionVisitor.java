package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * ExceptionVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ExceptionVisitor extends BytecodeVisitor {
    public void visit(int startIndex, int endIndex, int handlerIndex, int catchIndex);
}
