package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * StackMapTableVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface StackMapTableVisitor extends BytecodeVisitor {
    void visitSameFrame(int type) throws IOException;

    VerificationTypeVisitor visitSingleStackItemFrame(int type) throws IOException;

    VerificationTypeVisitor visitSingleStackItemFrameExtended(int offset) throws IOException;

    void visitChopFrame(int type, int offset) throws IOException;

    void visitSameFrameExtended(int offset) throws IOException;

    VerificationTypeVisitor visitAppendFrame(int type, int offset, int count) throws IOException;

    FullFrameVisitor visitFullFrame(int offset) throws IOException;
}
