package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.TypePathVisitor;

/**
 * DebugTypePathVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugTypePathVisitor extends DebugVisitor implements TypePathVisitor {
    public DebugTypePathVisitor() {
        super("TypePath");
    }

    public DebugTypePathVisitor(int indent) {
        super("TypePath", indent);
    }

    @Override
    public void visit(int type, int index) {

    }
}
