package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.IOException;

/**
 * MethodParameterWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodParameterWriter extends BytecodeWriter implements MethodParameterVisitor {
    @Override
    public void visit(int nameIndex, int access) throws IOException {

    }
}
