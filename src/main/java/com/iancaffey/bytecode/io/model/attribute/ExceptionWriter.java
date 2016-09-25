package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.IOException;

/**
 * ExceptionWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ExceptionWriter extends BytecodeWriter implements ExceptionVisitor {
    @Override
    public void visit(int startIndex, int endIndex, int handlerIndex, int catchIndex) throws IOException {

    }
}
