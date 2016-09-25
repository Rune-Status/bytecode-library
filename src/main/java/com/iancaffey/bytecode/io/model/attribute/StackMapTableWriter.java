package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * StackMapTableWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class StackMapTableWriter extends BytecodeWriter implements StackMapTableVisitor {
    public StackMapTableWriter() {
    }

    public StackMapTableWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visitSameFrame(int type) throws IOException {

    }

    @Override
    public VerificationTypeVisitor visitSingleStackItemFrame(int type) throws IOException {
        return null;
    }

    @Override
    public VerificationTypeVisitor visitSingleStackItemFrameExtended(int offset) throws IOException {
        return null;
    }

    @Override
    public void visitChopFrame(int type, int offset) throws IOException {

    }

    @Override
    public void visitSameFrameExtended(int offset) throws IOException {

    }

    @Override
    public VerificationTypeVisitor visitAppendFrame(int type, int offset, int count) throws IOException {
        return null;
    }

    @Override
    public FullFrameVisitor visitFullFrame(int offset) throws IOException {
        return null;
    }
}
