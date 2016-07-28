package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.BytecodeVisitor;

/**
 * DebugVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugVisitor implements BytecodeVisitor {
    private final String type;
    private final int indent;

    public DebugVisitor(String type) {
        this(type, 0);
    }

    public DebugVisitor(String type, int indent) {
        this.type = type;
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
        for (int i = 0; i < indent + padding; i++)
            builder.append('\t');
        builder.append(info);
        System.out.println(builder.toString());
    }

    @Override
    public void begin() {
        log("[BEGIN] " + type);
    }

    @Override
    public void end() {
        log("[END] " + type);
    }
}
