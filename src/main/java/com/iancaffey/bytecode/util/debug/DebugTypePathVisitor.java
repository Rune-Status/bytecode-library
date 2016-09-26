package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.model.attribute.annotation.TypePathVisitor;

/**
 * DebugTypePathVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugTypePathVisitor extends DebugVisitor implements TypePathVisitor {
    public DebugTypePathVisitor() {
    }

    public DebugTypePathVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visit(int type, int index) {
        log(String.format("TypePath [type=%d, index=%d]", type, index), 1);
    }
}
