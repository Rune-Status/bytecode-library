package com.iancaffey.bytecode.attributes.frame;

import com.iancaffey.bytecode.attributes.StackFrame;
import com.iancaffey.bytecode.attributes.VerificationTypeInfo;

/**
 * FullFrame
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FullFrame extends StackFrame {
    private final VerificationTypeInfo[] local;
    private final VerificationTypeInfo[] stack;

    public FullFrame(int offset, VerificationTypeInfo[] local, VerificationTypeInfo... stack) {
        super(StackFrame.FULL_FRAME, offset);
        this.local = local;
        this.stack = stack;
    }

    public int localCount() {
        return local.length;
    }

    public VerificationTypeInfo localInfo(int index) {
        return local[index];
    }

    public int stackCount() {
        return stack.length;
    }

    public VerificationTypeInfo stackInfo(int index) {
        return stack[index];
    }
}
