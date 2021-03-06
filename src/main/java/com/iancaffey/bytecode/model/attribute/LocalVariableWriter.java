package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * LocalVariableWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableWriter extends BytecodeWriter implements LocalVariableVisitor {
    public LocalVariableWriter() {
    }

    public LocalVariableWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visit(int startIndex, int length, int nameIndex, int descriptorIndex, int index) throws IOException {
        writeShort(startIndex);
        writeShort(length);
        writeShort(nameIndex);
        writeShort(descriptorIndex);
        writeShort(index);
    }
}
