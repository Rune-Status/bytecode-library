package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.LocalVariableTargetVisitor;

/**
 * DebugLocalVariableTargetVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugLocalVariableTargetVisitor extends DebugVisitor implements LocalVariableTargetVisitor {
    public DebugLocalVariableTargetVisitor() {
        super("LocalVariableTarget");
    }

    public DebugLocalVariableTargetVisitor(int indent) {
        super("LocalVariableTarget", indent);
    }

    @Override
    public void visit(int startIndex, int length, int index) {

    }
}
