package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.IOException;

/**
 * LocalVariableTargetWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableTargetWriter extends BytecodeWriter implements LocalVariableTargetVisitor {
    @Override
    public void visit(int startIndex, int length, int index) throws IOException {

    }
}
