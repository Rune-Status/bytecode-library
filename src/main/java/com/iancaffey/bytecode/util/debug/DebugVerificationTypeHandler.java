package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.VerificationTypeHandler;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugVerificationTypeHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugVerificationTypeHandler extends DebugVisitor implements VerificationTypeHandler {
    public DebugVerificationTypeHandler() {
        super("VerificationType");
    }

    public DebugVerificationTypeHandler(int indent) {
        super("VerificationType", indent);
    }

    @Override
    public void visitTop() {

    }

    @Override
    public void visitInteger() {

    }

    @Override
    public void visitFloat() {

    }

    @Override
    public void visitLong() {

    }

    @Override
    public void visitDouble() {

    }

    @Override
    public void visitNull() {

    }

    @Override
    public void visitUninitializedThis() {

    }

    @Override
    public void visitObject(int index) {

    }

    @Override
    public void visitUninitialized(int offset) {

    }
}
