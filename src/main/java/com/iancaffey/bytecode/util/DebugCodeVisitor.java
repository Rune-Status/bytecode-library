package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.AttributeVisitor;
import com.iancaffey.bytecode.CodeVisitor;
import com.iancaffey.bytecode.ExceptionVisitor;

/**
 * DebugCodeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugCodeVisitor extends DebugVisitor implements CodeVisitor {
    public DebugCodeVisitor() {
        super("Code");
    }

    public DebugCodeVisitor(int indent) {
        super("Code", indent);
    }

    @Override
    public void visitDepth(int maxStack, int maxLocals) {

    }

    @Override
    public void visitData(byte[] data) {

    }

    @Override
    public ExceptionVisitor visitExceptionTable(int count) {
        return null;
    }

    @Override
    public AttributeVisitor visitAttributes(int count) {
        return null;
    }
}
