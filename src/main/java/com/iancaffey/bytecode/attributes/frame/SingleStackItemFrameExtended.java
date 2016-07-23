package com.iancaffey.bytecode.attributes.frame;

import com.iancaffey.bytecode.attributes.StackFrame;
import com.iancaffey.bytecode.attributes.VerificationTypeInfo;

/**
 * SingleStackItemFrameExtended
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SingleStackItemFrameExtended extends StackFrame {
    private final VerificationTypeInfo stack;

    public SingleStackItemFrameExtended(int offset, VerificationTypeInfo stack) {
        super(StackFrame.SINGLE_STACK_ITEM_FRAME_EXTENDED, offset);
        this.stack = stack;
    }

    public VerificationTypeInfo stack() {
        return stack;
    }
}
