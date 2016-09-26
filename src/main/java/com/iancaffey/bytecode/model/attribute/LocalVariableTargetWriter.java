package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * LocalVariableTargetWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableTargetWriter extends BytecodeWriter implements LocalVariableTargetVisitor {
    public LocalVariableTargetWriter() {
    }

    public LocalVariableTargetWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visit(int startIndex, int length, int index) throws IOException {
        writeShort(startIndex);
        writeShort(length);
        writeShort(index);
    }
}
