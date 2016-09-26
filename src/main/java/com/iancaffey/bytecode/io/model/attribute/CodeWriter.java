package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;
import com.iancaffey.bytecode.io.model.AttributeModelVisitor;
import com.iancaffey.bytecode.io.model.AttributeModelWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * CodeWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class CodeWriter extends BytecodeWriter implements CodeVisitor {
    public CodeWriter() {
    }

    public CodeWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visitDepth(int maxStack, int maxLocals) throws IOException {
        writeShort(maxStack);
        writeShort(maxLocals);
    }

    @Override
    public void visitData(byte[] data) throws IOException {
        writeInt(data.length);
        write(data);
    }

    @Override
    public ExceptionVisitor visitExceptionTable(int count) throws IOException {
        writeShort(count);
        return new ExceptionWriter((ByteArrayOutputStream) out);
    }

    @Override
    public AttributeModelVisitor visitAttributes(int count) throws IOException {
        writeShort(count);
        return new AttributeModelWriter((ByteArrayOutputStream) out);
    }
}
