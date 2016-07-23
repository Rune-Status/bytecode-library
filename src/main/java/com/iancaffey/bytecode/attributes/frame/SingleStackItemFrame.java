package com.iancaffey.bytecode.attributes.frame;

import com.iancaffey.bytecode.attributes.StackFrame;
import com.iancaffey.bytecode.attributes.VerificationTypeInfo;

/**
 * SingleStackItemFrame
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SingleStackItemFrame extends StackFrame {
    public static final int IMPLICIT_OFFSET = 64;
    private final VerificationTypeInfo stack;

    public SingleStackItemFrame(int type, VerificationTypeInfo stack) {
        super(type, type - IMPLICIT_OFFSET);
        this.stack = stack;
    }

    public VerificationTypeInfo stack() {
        return stack;
    }
}
