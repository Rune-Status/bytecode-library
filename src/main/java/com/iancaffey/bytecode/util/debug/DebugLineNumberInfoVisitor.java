package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.attribute.LineNumberInfoVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugLineNumberInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugLineNumberInfoVisitor extends DebugVisitor implements LineNumberInfoVisitor {
    public DebugLineNumberInfoVisitor() {
        super("LineNumber");
    }

    public DebugLineNumberInfoVisitor(int indent) {
        super("LineNumber", indent);
    }

    @Override
    public void visit(int startIndex, int number) {

    }
}
