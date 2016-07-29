package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * VerificationTypeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface VerificationTypeVisitor extends BytecodeVisitor {
    public static VerificationTypeVisitor of(VerificationTypeVisitor... visitors) {
        return VerificationTypeVisitor.of(Arrays.stream(visitors));
    }

    public static VerificationTypeVisitor of(Collection<VerificationTypeVisitor> visitors) {
        return VerificationTypeVisitor.of(visitors.stream());
    }

    public static VerificationTypeVisitor of(Stream<VerificationTypeVisitor> visitors) {
        return new VerificationTypeVisitor() {
            @Override
            public void begin() {
                visitors.forEach(VerificationTypeVisitor::begin);
            }

            @Override
            public void visitTop() {
                visitors.forEach(VerificationTypeVisitor::visitTop);
            }

            @Override
            public void visitInteger() {
                visitors.forEach(VerificationTypeVisitor::visitInteger);
            }

            @Override
            public void visitFloat() {
                visitors.forEach(VerificationTypeVisitor::visitFloat);
            }

            @Override
            public void visitLong() {
                visitors.forEach(VerificationTypeVisitor::visitLong);
            }

            @Override
            public void visitDouble() {
                visitors.forEach(VerificationTypeVisitor::visitDouble);
            }

            @Override
            public void visitNull() {
                visitors.forEach(VerificationTypeVisitor::visitNull);
            }

            @Override
            public void visitUninitializedThis() {
                visitors.forEach(VerificationTypeVisitor::visitUninitializedThis);
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
                visitors.forEach(VerificationTypeVisitor::end);
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
