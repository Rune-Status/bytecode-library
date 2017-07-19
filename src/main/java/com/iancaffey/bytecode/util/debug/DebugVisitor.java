package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * DebugVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugVisitor implements BytecodeVisitor {
    private final int indent;

    public DebugVisitor() {
        this(0);
    }

    public DebugVisitor(int indent) {
        this.indent = indent;
    }

    protected int indent() {
        return indent;
    }

    protected void log(String info) {
        log(info, 0);
    }

    protected void log(String info, int padding) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < indent + padding; i++) {
            builder.append('\t');
        }
        builder.append(info);
        System.out.println(builder.toString());
    }
}
