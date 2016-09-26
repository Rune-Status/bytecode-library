package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * VerificationTypeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface VerificationTypeVisitor extends BytecodeVisitor {
    public void visitTop() throws IOException;

    public void visitInteger() throws IOException;

    public void visitFloat() throws IOException;

    public void visitLong() throws IOException;

    public void visitDouble() throws IOException;

    public void visitNull() throws IOException;

    public void visitUninitializedThis() throws IOException;

    public void visitObject(int index) throws IOException;

    public void visitUninitialized(int offset) throws IOException;
}
