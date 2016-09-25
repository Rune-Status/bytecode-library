package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * StackMapTableVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface StackMapTableVisitor extends BytecodeVisitor {
    public void visitSameFrame(int type) throws IOException;

    public VerificationTypeVisitor visitSingleStackItemFrame(int type) throws IOException;

    public VerificationTypeVisitor visitSingleStackItemFrameExtended(int offset) throws IOException;

    public void visitChopFrame(int type, int offset) throws IOException;

    public void visitSameFrameExtended(int offset) throws IOException;

    public VerificationTypeVisitor visitAppendFrame(int type, int offset, int count) throws IOException;

    public FullFrameVisitor visitFullFrame(int offset) throws IOException;
}
