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
    void visitTop() throws IOException;

    void visitInteger() throws IOException;

    void visitFloat() throws IOException;

    void visitLong() throws IOException;

    void visitDouble() throws IOException;

    void visitNull() throws IOException;

    void visitUninitializedThis() throws IOException;

    void visitObject(int index) throws IOException;

    void visitUninitialized(int offset) throws IOException;
}
