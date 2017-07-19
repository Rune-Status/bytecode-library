package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * ExceptionVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ExceptionVisitor extends BytecodeVisitor {
    void visit(int startIndex, int endIndex, int handlerIndex, int catchIndex) throws IOException;
}
