package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.model.attribute.FullFrameVisitor;
import com.iancaffey.bytecode.io.model.attribute.StackMapTableVisitor;
import com.iancaffey.bytecode.io.model.attribute.VerificationTypeVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugStackMapTableVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugStackMapTableVisitor extends DebugVisitor implements StackMapTableVisitor {
    public DebugStackMapTableVisitor() {
    }

    public DebugStackMapTableVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visitSameFrame(int type) {
        log(String.format("SameFrame [type=%d]", type), 1);
    }

    @Override
    public VerificationTypeVisitor visitSingleStackItemFrame(int type) {
        log(String.format("SingleStackItemFrame [type=%d]", type), 1);
        return new DebugVerificationTypeVisitor(indent() + 1);
    }

    @Override
    public VerificationTypeVisitor visitSingleStackItemFrameExtended(int offset) {
        log(String.format("SingleStackItemFrameExtended [offset=%d]", offset), 1);
        return new DebugVerificationTypeVisitor(indent() + 1);
    }

    @Override
    public void visitChopFrame(int type, int offset) {
        log(String.format("ChopFrame [type=%d, offset=%d]", type, offset), 1);
    }

    @Override
    public void visitSameFrameExtended(int offset) {
        log(String.format("SameFrameExtended [offset=%d]", offset), 1);
    }

    @Override
    public VerificationTypeVisitor visitAppendFrame(int type, int offset, int count) {
        log(String.format("AppendFrame [type=%d, offset=%d, count=%d]", type, offset, count), 1);
        return new DebugVerificationTypeVisitor(indent() + 1);
    }

    @Override
    public FullFrameVisitor visitFullFrame(int offset) {
        log(String.format("FullFrame [offset=%d]", offset), 1);
        return new DebugFullFrameVisitor(indent() + 1);
    }
}
