package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.IOException;

/**
 * LocalVariableWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableWriter extends BytecodeWriter implements LocalVariableVisitor {
    @Override
    public void visit(int startIndex, int length, int nameIndex, int descriptorIndex, int index) throws IOException {

    }
}
