package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * VerificationTypeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface VerificationTypeVisitor extends BytecodeVisitor {
    public void visitTop();

    public void visitInteger();

    public void visitFloat();

    public void visitLong();

    public void visitDouble();

    public void visitNull();

    public void visitUninitializedThis();

    public void visitObject(int index);

    public void visitUninitialized(int offset);
}
