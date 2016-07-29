package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.FullFrameVisitor;
import com.iancaffey.bytecode.io.attribute.VerificationTypeVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugFullFrameVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugFullFrameVisitor extends DebugVisitor implements FullFrameVisitor {
    public DebugFullFrameVisitor() {
        super("FullFrame");
    }

    public DebugFullFrameVisitor(int indent) {
        super("FullFrame", indent);
    }

    @Override
    public VerificationTypeVisitor visitLocals(int count) {
        return new DebugVerificationTypeVisitor(indent() + 1);
    }

    @Override
    public VerificationTypeVisitor visitStack(int count) {
        return new DebugVerificationTypeVisitor(indent() + 1);
    }
}
