package com.iancaffey.bytecode.attributes.frame;

import com.iancaffey.bytecode.attributes.StackFrame;
import com.iancaffey.bytecode.attributes.VerificationTypeInfo;

/**
 * AppendFrame
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AppendFrame extends StackFrame {
    private final VerificationTypeInfo[] local;

    public AppendFrame(int type, int offset, VerificationTypeInfo[] local) {
        super(type, offset);
        this.local = local;
    }

    public int localCount() {
        return local.length;
    }

    public VerificationTypeInfo localInfo(int index) {
        return local[index];
    }
}
