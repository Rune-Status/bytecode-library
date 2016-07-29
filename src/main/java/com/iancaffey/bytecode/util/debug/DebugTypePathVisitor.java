package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.attribute.annotation.TypePathVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

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
