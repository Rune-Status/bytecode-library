package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.model.attribute.LocalVariableVisitor;

/**
 * DebugLocalVariableVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugLocalVariableVisitor extends DebugVisitor implements LocalVariableVisitor {
    public DebugLocalVariableVisitor() {
    }

    public DebugLocalVariableVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visit(int startIndex, int length, int nameIndex, int descriptorIndex, int index) {
        log(String.format("LocalVariable [startIndex=%d, length=%d, nameIndex=%d, descriptorIndex=%d, index=%d]",
                startIndex, length, nameIndex, descriptorIndex, index), 1);
    }
}
