package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.model.attribute.LocalVariableTargetVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugLocalVariableTargetVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugLocalVariableTargetVisitor extends DebugVisitor implements LocalVariableTargetVisitor {
    public DebugLocalVariableTargetVisitor() {
    }

    public DebugLocalVariableTargetVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visit(int startIndex, int length, int index) {
        log(String.format("LocalVariableTarget [startIndex=%d, length=%d, index=%d]", startIndex, length, index), 1);
    }
}
