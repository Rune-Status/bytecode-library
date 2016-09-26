package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * FullFrameWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FullFrameWriter extends BytecodeWriter implements FullFrameVisitor {
    public FullFrameWriter() {
    }

    public FullFrameWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public VerificationTypeVisitor visitLocals(int count) throws IOException {
        writeShort(count);
        return new VerificationTypeWriter((ByteArrayOutputStream) out);
    }

    @Override
    public VerificationTypeVisitor visitStack(int count) throws IOException {
        writeShort(count);
        return new VerificationTypeWriter((ByteArrayOutputStream) out);
    }
}
