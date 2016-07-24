package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * StackMapTable
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class StackMapTable extends AttributeInfo {
    private final StackFrame[] frames;

    public StackMapTable(String name, int infoLength, StackFrame... frames) {
        super(name, infoLength);
        this.frames = frames;
    }

    public int frameCount() {
        return frames.length;
    }

    public StackFrame frame(int index) {
        return frames[index];
    }
}
