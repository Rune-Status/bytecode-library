package com.iancaffey.bytecode.attributes;

/**
 * StackFrame
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class StackFrame {
    private final int type;
    private final int offset;

    public StackFrame(int type, int offset) {
        this.type = type;
        this.offset = offset;
    }

    public int type() {
        return type;
    }

    public int offset() {
        return offset;
    }
}
