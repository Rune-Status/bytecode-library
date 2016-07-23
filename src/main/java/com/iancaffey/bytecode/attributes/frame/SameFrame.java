package com.iancaffey.bytecode.attributes.frame;

import com.iancaffey.bytecode.attributes.StackFrame;

/**
 * SameFrame
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SameFrame extends StackFrame {
    public SameFrame(int type) {
        super(type, type);
    }
}
