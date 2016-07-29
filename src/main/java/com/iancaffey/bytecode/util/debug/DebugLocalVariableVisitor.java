package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.attribute.LocalVariableVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugLocalVariableVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugLocalVariableVisitor extends DebugVisitor implements LocalVariableVisitor {
    public DebugLocalVariableVisitor() {
        super("LocalVariable");
    }

    public DebugLocalVariableVisitor(int indent) {
        super("LocalVariable", indent);
    }

    @Override
    public void visit(int startIndex, int length, int nameIndex, int descriptorIndex, int index) {

    }
}
