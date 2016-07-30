package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;
import com.iancaffey.bytecode.io.direct.AttributeModelVisitor;

/**
 * CodeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface CodeVisitor extends BytecodeVisitor {
    public void visitDepth(int maxStack, int maxLocals);

    public void visitData(byte[] data);

    public ExceptionVisitor visitExceptionTable(int count);

    public AttributeModelVisitor visitAttributes(int count);
}