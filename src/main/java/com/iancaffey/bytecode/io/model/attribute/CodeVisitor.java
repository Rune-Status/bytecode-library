package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;
import com.iancaffey.bytecode.io.model.AttributeModelVisitor;

import java.io.IOException;

/**
 * CodeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface CodeVisitor extends BytecodeVisitor {
    public void visitDepth(int maxStack, int maxLocals) throws IOException;

    public void visitData(byte[] data) throws IOException;

    public ExceptionVisitor visitExceptionTable(int count) throws IOException;

    public AttributeModelVisitor visitAttributes(int count) throws IOException;
}
