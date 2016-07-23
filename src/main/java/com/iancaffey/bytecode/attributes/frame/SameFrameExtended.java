package com.iancaffey.bytecode.attributes.frame;

import com.iancaffey.bytecode.attributes.StackFrame;

/**
 * SameFrameExtended
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SameFrameExtended extends StackFrame {
    public SameFrameExtended(int offset) {
        super(StackFrame.SAME_FRAME_EXTENDED, offset);
    }
}
