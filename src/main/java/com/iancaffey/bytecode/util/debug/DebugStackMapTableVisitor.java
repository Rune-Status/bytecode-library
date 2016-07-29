package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.FullFrameVisitor;
import com.iancaffey.bytecode.io.attribute.StackMapTableVisitor;
import com.iancaffey.bytecode.io.attribute.VerificationTypeVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugStackMapTableVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugStackMapTableVisitor extends DebugVisitor implements StackMapTableVisitor {
    public DebugStackMapTableVisitor() {
        super("StackMapTable");
    }

    public DebugStackMapTableVisitor(int indent) {
        super("StackMapTable", indent);
    }

    @Override
    public void visitSameFrame(int type) {
        log(String.format("%-25s[type=%d]", "SameFrame", type), 1);
    }

    @Override
    public VerificationTypeVisitor visitSingleStackItemFrame(int type) {
        return new DebugVerificationTypeVisitor(indent() + 1);
    }

    @Override
    public VerificationTypeVisitor visitSingleStackItemFrameExtended(int offset) {
        return new DebugVerificationTypeVisitor(indent() + 1);
    }

    @Override
    public void visitChopFrame(int type, int offset) {
        log(String.format("%-25s[type=%d, offset=%d]", "ChopFrame", type, offset), 1);
    }

    @Override
    public void visitSameFrameExtended(int offset) {
        log(String.format("%-25s[offset=%d]", "SameFrameExtended", offset), 1);
    }

    @Override
    public VerificationTypeVisitor visitAppendFrame(int type, int offset, int count) {
        return new DebugVerificationTypeVisitor(indent() + 1);
    }

    @Override
    public FullFrameVisitor visitFullFrame(int offset) {
        return new DebugFullFrameVisitor(indent() + 1);
    }
}
