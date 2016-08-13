package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * StackMapTableVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface StackMapTableVisitor extends BytecodeVisitor {
    public void visitSameFrame(int type);

    public VerificationTypeVisitor visitSingleStackItemFrame(int type);

    public VerificationTypeVisitor visitSingleStackItemFrameExtended(int offset);

    public void visitChopFrame(int type, int offset);

    public void visitSameFrameExtended(int offset);

    public VerificationTypeVisitor visitAppendFrame(int type, int offset, int count);

    public FullFrameVisitor visitFullFrame(int offset);
}
