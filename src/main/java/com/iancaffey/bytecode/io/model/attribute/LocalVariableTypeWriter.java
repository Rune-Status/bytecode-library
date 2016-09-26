package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * LocalVariableTypeWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableTypeWriter extends BytecodeWriter implements LocalVariableTypeVisitor {
    public LocalVariableTypeWriter() {
    }

    public LocalVariableTypeWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visit(int startIndex, int length, int nameIndex, int signatureIndex, int index) throws IOException {
        writeShort(startIndex);
        writeShort(length);
        writeShort(nameIndex);
        writeShort(signatureIndex);
        writeShort(index);
    }
}
