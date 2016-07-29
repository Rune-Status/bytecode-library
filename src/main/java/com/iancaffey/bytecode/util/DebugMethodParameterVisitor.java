package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.MethodParameterVisitor;

/**
 * DebugMethodParameterVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugMethodParameterVisitor extends DebugVisitor implements MethodParameterVisitor {
    public DebugMethodParameterVisitor() {
        super("MethodParameter");
    }

    public DebugMethodParameterVisitor(int indent) {
        super("MethodParameter", indent);
    }

    @Override
    public void visit(int nameIndex, int access) {

    }
}
