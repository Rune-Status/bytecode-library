package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.model.attribute.LineNumberInfoVisitor;

/**
 * DebugLineNumberInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugLineNumberInfoVisitor extends DebugVisitor implements LineNumberInfoVisitor {
    public DebugLineNumberInfoVisitor() {
    }

    public DebugLineNumberInfoVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visit(int startIndex, int number) {
        log(String.format("LineNumber [startIndex=%d, number=%d]", startIndex, number), 1);
    }
}
