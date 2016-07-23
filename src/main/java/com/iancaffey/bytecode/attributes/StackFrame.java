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
    public static final int SINGLE_STACK_ITEM_FRAME_EXTENDED = 247;
    public static final int SAME_FRAME_EXTENDED = 251;
    public static final int FULL_FRAME = 255;

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
