package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.IOException;

/**
 * LineNumberInfoWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LineNumberInfoWriter extends BytecodeWriter implements LineNumberInfoVisitor {
    @Override
    public void visit(int startIndex, int number) throws IOException {

    }
}
