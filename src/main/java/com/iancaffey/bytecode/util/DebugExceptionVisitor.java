package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.ExceptionVisitor;

/**
 * DebugExceptionVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugExceptionVisitor extends DebugVisitor implements ExceptionVisitor {
    public DebugExceptionVisitor() {
        super("Exception");
    }

    public DebugExceptionVisitor(int indent) {
        super("Exception", indent);
    }

    @Override
    public void visit(int startIndex, int endIndex, int handlerIndex, int catchIndex) {

    }
}
