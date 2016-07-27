package com.iancaffey.bytecode.lang;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * VerificationTypeInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface VerificationTypeInfoVisitor extends BytecodeVisitor {
    public static VerificationTypeInfoVisitor of(VerificationTypeInfoVisitor... visitors) {
        return VerificationTypeInfoVisitor.of(Arrays.stream(visitors));
    }

    public static VerificationTypeInfoVisitor of(Collection<VerificationTypeInfoVisitor> visitors) {
        return VerificationTypeInfoVisitor.of(visitors.stream());
    }

    public static VerificationTypeInfoVisitor of(Stream<VerificationTypeInfoVisitor> visitors) {
        return new VerificationTypeInfoVisitor() {
            @Override
            public void begin() {
                visitors.forEach(VerificationTypeInfoVisitor::begin);
            }

            @Override
            public void visitTop() {
                visitors.forEach(VerificationTypeInfoVisitor::visitTop);
            }

            @Override
            public void visitInteger() {
                visitors.forEach(VerificationTypeInfoVisitor::visitInteger);
            }

            @Override
            public void visitFloat() {
                visitors.forEach(VerificationTypeInfoVisitor::visitFloat);
            }

            @Override
            public void visitLong() {
                visitors.forEach(VerificationTypeInfoVisitor::visitLong);
            }

            @Override
            public void visitDouble() {
                visitors.forEach(VerificationTypeInfoVisitor::visitDouble);
            }

            @Override
            public void visitNull() {
                visitors.forEach(VerificationTypeInfoVisitor::visitNull);
            }

            @Override
            public void visitUninitializedThis() {
                visitors.forEach(VerificationTypeInfoVisitor::visitUninitializedThis);
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
                visitors.forEach(VerificationTypeInfoVisitor::end);
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
