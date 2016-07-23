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

    public SingleStackItemFrameExtended(int type, int offset, VerificationTypeInfo stack) {
        super(type, offset);
        this.stack = stack;
    }

    public VerificationTypeInfo stack() {
        return stack;
    }
}
