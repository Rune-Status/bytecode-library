package com.iancaffey.bytecode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * VerificationTypeHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface VerificationTypeHandler extends BytecodeVisitor {
    public static VerificationTypeHandler of(VerificationTypeHandler... visitors) {
        return VerificationTypeHandler.of(Arrays.stream(visitors));
    }

    public static VerificationTypeHandler of(Collection<VerificationTypeHandler> visitors) {
        return VerificationTypeHandler.of(visitors.stream());
    }

    public static VerificationTypeHandler of(Stream<VerificationTypeHandler> visitors) {
        return new VerificationTypeHandler() {
            @Override
            public void begin() {
                visitors.forEach(VerificationTypeHandler::begin);
            }

            @Override
            public void visitTop() {
                visitors.forEach(VerificationTypeHandler::visitTop);
            }

            @Override
            public void visitInteger() {
                visitors.forEach(VerificationTypeHandler::visitInteger);
            }

            @Override
            public void visitFloat() {
                visitors.forEach(VerificationTypeHandler::visitFloat);
            }

            @Override
            public void visitLong() {
                visitors.forEach(VerificationTypeHandler::visitLong);
            }

            @Override
            public void visitDouble() {
                visitors.forEach(VerificationTypeHandler::visitDouble);
            }

            @Override
            public void visitNull() {
                visitors.forEach(VerificationTypeHandler::visitNull);
            }

            @Override
            public void visitUninitializedThis() {
                visitors.forEach(VerificationTypeHandler::visitUninitializedThis);
            }

            @Override
            public void visitObject(int index) {
                visitors.forEach(visitor -> visitor.visitObject(index));
            }

            @Override
            public void visitUninitialized(int offset) {
                visitors.forEach(visitor -> visitor.visitUninitialized(offset));
            }

            @Override
            public void end() {
                visitors.forEach(VerificationTypeHandler::end);
            }
        };
    }

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
