package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;
import com.iancaffey.bytecode.io.model.AttributeModelVisitor;

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

    }

    @Override
    public void visitData(byte[] data) throws IOException {

    }

    @Override
    public ExceptionVisitor visitExceptionTable(int count) throws IOException {
        return null;
    }

    @Override
    public AttributeModelVisitor visitAttributes(int count) throws IOException {
        return null;
    }
}
