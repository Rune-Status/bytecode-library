package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.direct.attribute.FullFrameVisitor;
import com.iancaffey.bytecode.io.direct.attribute.VerificationTypeVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugFullFrameVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugFullFrameVisitor extends DebugVisitor implements FullFrameVisitor {
    public DebugFullFrameVisitor() {
    }

    public DebugFullFrameVisitor(int indent) {
        super(indent);
    }

    @Override
    public VerificationTypeVisitor visitLocals(int count) {
        log(String.format("Locals [count=%d]", count), 1);
        return new DebugVerificationTypeVisitor(indent() + 1);
    }

    @Override
    public VerificationTypeVisitor visitStack(int count) {
        log(String.format("Stack [count=%d]", count), 1);
        return new DebugVerificationTypeVisitor(indent() + 1);
    }
}
