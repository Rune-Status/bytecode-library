package com.iancaffey.bytecode.model;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * MethodModelWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodModelWriter extends BytecodeWriter implements MethodModelVisitor {
    public MethodModelWriter() {
    }

    public MethodModelWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visit(int access, int nameIndex, int descriptorIndex) throws IOException {
        writeShort(access);
        writeShort(nameIndex);
        writeShort(descriptorIndex);
    }

    @Override
    public AttributeModelVisitor visitAttributes(int count) throws IOException {
        writeShort(count);
        return new AttributeModelWriter((ByteArrayOutputStream) out);
    }
}
