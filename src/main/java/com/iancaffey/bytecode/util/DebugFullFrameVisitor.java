package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.FullFrameVisitor;
import com.iancaffey.bytecode.VerificationTypeHandler;

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
    public VerificationTypeHandler visitLocals(int count) {
        return new DebugVerificationTypeHandler(indent() + 1);
    }

    @Override
    public VerificationTypeHandler visitStack(int count) {
        return new DebugVerificationTypeHandler(indent() + 1);
    }
}
