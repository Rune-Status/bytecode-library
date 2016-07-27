package com.iancaffey.bytecode.lang;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * ConstantPoolInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ConstantPoolInfoVisitor extends BytecodeVisitor {
    public static ConstantPoolInfoVisitor of(ConstantPoolInfoVisitor... visitors) {
        return ConstantPoolInfoVisitor.of(Arrays.stream(visitors));
    }

    public static ConstantPoolInfoVisitor of(Collection<ConstantPoolInfoVisitor> visitors) {
        return ConstantPoolInfoVisitor.of(visitors.stream());
    }

    public static ConstantPoolInfoVisitor of(Stream<ConstantPoolInfoVisitor> visitors) {
        return new ConstantPoolInfoVisitor() {
            @Override
            public void begin() {
                visitors.forEach(ConstantPoolInfoVisitor::begin);
            }

            @Override
            public void visitClass(int nameIndex) {
                visitors.forEach(visitor -> visitor.visitClass(nameIndex));
            }

            @Override
            public void visitDouble(double value) {
                visitors.forEach(visitor -> visitor.visitDouble(value));
            }

            @Override
            public void visitFieldReference(int nameIndex, int descriptorIndex) {
                visitors.forEach(visitor -> visitor.visitFieldReference(nameIndex, descriptorIndex));
            }

            @Override
            public void visitFloat(float value) {
                visitors.forEach(visitor -> visitor.visitFloat(value));
            }

            @Override
            public void visitInteger(int value) {
                visitors.forEach(visitor -> visitor.visitInteger(value));
            }

            @Override
            public void visitInterfaceMethodReference(int nameIndex, int descriptorIndex) {
                visitors.forEach(visitor -> visitor.visitInterfaceMethodReference(nameIndex, descriptorIndex));
            }

            @Override
            public void visitInvokeDynamic(int methodIndex, int descriptorIndex) {
                visitors.forEach(visitor -> visitor.visitInvokeDynamic(methodIndex, descriptorIndex));
            }

            @Override
            public void visitLong(long value) {
                visitors.forEach(visitor -> visitor.visitLong(value));
            }

            @Override
            public void visitMethodHandle(int type, int referenceIndex) {
                visitors.forEach(visitor -> visitor.visitMethodHandle(type, referenceIndex));
            }

            @Override
            public void visitMethodReference(int nameIndex, int descriptorIndex) {
                visitors.forEach(visitor -> visitor.visitMethodReference(nameIndex, descriptorIndex));
            }

            @Override
            public void visitMethodType(int descriptorIndex) {
                visitors.forEach(visitor -> visitor.visitMethodType(descriptorIndex));
            }

            @Override
            public void visitNameType(int nameIndex, int descriptorIndex) {
                visitors.forEach(visitor -> visitor.visitNameType(nameIndex, descriptorIndex));
            }

            @Override
            public void visitString(int valueIndex) {
                visitors.forEach(visitor -> visitor.visitString(valueIndex));
            }

            @Override
            public void visitUTF8(String value) {
                visitors.forEach(visitor -> visitor.visitUTF8(value));
            }

            @Override
            public void end() {
                visitors.forEach(ConstantPoolInfoVisitor::end);
            }
        };
    }

    public void visitClass(int nameIndex);

    public void visitDouble(double value);

    public void visitFieldReference(int nameIndex, int descriptorIndex);

    public void visitFloat(float value);

    public void visitInteger(int value);

    public void visitInterfaceMethodReference(int nameIndex, int descriptorIndex);

    public void visitInvokeDynamic(int methodIndex, int descriptorIndex);

    public void visitLong(long value);

    public void visitMethodHandle(int type, int referenceIndex);

    public void visitMethodReference(int nameIndex, int descriptorIndex);

    public void visitMethodType(int descriptorIndex);

    public void visitNameType(int nameIndex, int descriptorIndex);

    public void visitString(int valueIndex);

    public void visitUTF8(String value);
}
