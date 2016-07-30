package com.iancaffey.bytecode.io.direct;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * ConstantPoolVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ConstantPoolVisitor extends BytecodeVisitor {
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
