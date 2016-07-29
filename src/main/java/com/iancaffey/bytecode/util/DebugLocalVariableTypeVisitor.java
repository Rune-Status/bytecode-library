package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.LocalVariableTypeVisitor;

/**
 * DebugLocalVariableTypeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugLocalVariableTypeVisitor extends DebugVisitor implements LocalVariableTypeVisitor {
    public DebugLocalVariableTypeVisitor() {
        super("LocalVariableType");
    }

    public DebugLocalVariableTypeVisitor(int indent) {
        super("LocalVariableType", indent);
    }

    @Override
    public void visit(int startIndex, int length, int nameIndex, int signatureIndex, int index) {

    }
}
