package com.iancaffey.bytecode.model.attribute;

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
        writeByte(VerificationTypeHandler.TOP);
    }

    @Override
    public void visitInteger() throws IOException {
        writeByte(VerificationTypeHandler.INTEGER);
    }

    @Override
    public void visitFloat() throws IOException {
        writeByte(VerificationTypeHandler.FLOAT);
    }

    @Override
    public void visitLong() throws IOException {
        writeByte(VerificationTypeHandler.LONG);
    }

    @Override
    public void visitDouble() throws IOException {
        writeByte(VerificationTypeHandler.DOUBLE);
    }

    @Override
    public void visitNull() throws IOException {
        writeByte(VerificationTypeHandler.NULL);
    }

    @Override
    public void visitUninitializedThis() throws IOException {
        writeByte(VerificationTypeHandler.UNINITIALIZED_THIS);
    }

    @Override
    public void visitObject(int index) throws IOException {
        writeByte(VerificationTypeHandler.OBJECT);
        writeShort(index);
    }

    @Override
    public void visitUninitialized(int offset) throws IOException {
        writeByte(VerificationTypeHandler.UNINITIALIZED);
        writeShort(offset);
    }
}
