package com.iancaffey.bytecode.model;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * FieldModelWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldModelWriter extends BytecodeWriter implements FieldModelVisitor {
    public FieldModelWriter() {
    }

    public FieldModelWriter(ByteArrayOutputStream out) {
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
