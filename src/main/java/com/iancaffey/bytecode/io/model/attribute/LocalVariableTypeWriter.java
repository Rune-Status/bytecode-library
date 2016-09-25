package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.IOException;

/**
 * LocalVariableTypeWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableTypeWriter extends BytecodeWriter implements LocalVariableTypeVisitor {
    @Override
    public void visit(int startIndex, int length, int nameIndex, int signatureIndex, int index) throws IOException {

    }
}
