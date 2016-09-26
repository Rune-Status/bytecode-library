package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * ExceptionWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ExceptionWriter extends BytecodeWriter implements ExceptionVisitor {
    public ExceptionWriter() {
    }

    public ExceptionWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visit(int startIndex, int endIndex, int handlerIndex, int catchIndex) throws IOException {
        writeShort(startIndex);
        writeShort(endIndex);
        writeShort(handlerIndex);
        writeShort(catchIndex);
    }
}
