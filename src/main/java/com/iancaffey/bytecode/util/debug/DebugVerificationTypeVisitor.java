package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.model.attribute.VerificationTypeVisitor;

/**
 * DebugVerificationTypeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugVerificationTypeVisitor extends DebugVisitor implements VerificationTypeVisitor {
    public DebugVerificationTypeVisitor() {
    }

    public DebugVerificationTypeVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visitTop() {
        log("Top", 1);
    }

    @Override
    public void visitInteger() {
        log("Integer", 1);
    }

    @Override
    public void visitFloat() {
        log("Float", 1);
    }

    @Override
    public void visitLong() {
        log("Long", 1);
    }

    @Override
    public void visitDouble() {
        log("Double", 1);
    }

    @Override
    public void visitNull() {
        log("Null", 1);
    }

    @Override
    public void visitUninitializedThis() {
        log("UninitializedThis", 1);
    }

    @Override
    public void visitObject(int index) {
        log(String.format("Object [index=%d]", index), 1);
    }

    @Override
    public void visitUninitialized(int offset) {
        log(String.format("Uninitialized [offset=%d]", offset), 1);
    }
}
