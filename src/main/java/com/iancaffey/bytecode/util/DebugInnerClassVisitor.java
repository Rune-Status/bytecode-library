package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.InnerClassVisitor;

/**
 * DebugInnerClassVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugInnerClassVisitor extends DebugVisitor implements InnerClassVisitor {
    public DebugInnerClassVisitor() {
        super("InnerClass");
    }

    public DebugInnerClassVisitor(int indent) {
        super("InnerClass", indent);
    }

    @Override
    public void visit(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex, int innerClassAccess) {

    }
}
