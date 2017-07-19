package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;
import com.iancaffey.bytecode.model.AttributeModelVisitor;

import java.io.IOException;

/**
 * CodeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface CodeVisitor extends BytecodeVisitor {
    void visitDepth(int maxStack, int maxLocals) throws IOException;

    void visitData(byte[] data) throws IOException;

    ExceptionVisitor visitExceptionTable(int count) throws IOException;

    AttributeModelVisitor visitAttributes(int count) throws IOException;
}
