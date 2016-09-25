package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * VerificationTypeWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class VerificationTypeWriter extends BytecodeWriter implements VerificationTypeVisitor {
    public VerificationTypeWriter() {
    }

    public VerificationTypeWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visitTop() throws IOException {

    }

    @Override
    public void visitInteger() throws IOException {

    }

    @Override
    public void visitFloat() throws IOException {

    }

    @Override
    public void visitLong() throws IOException {

    }

    @Override
    public void visitDouble() throws IOException {

    }

    @Override
    public void visitNull() throws IOException {

    }

    @Override
    public void visitUninitializedThis() throws IOException {

    }

    @Override
    public void visitObject(int index) throws IOException {

    }

    @Override
    public void visitUninitialized(int offset) throws IOException {

    }
}
