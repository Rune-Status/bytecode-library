package com.iancaffey.bytecode.io.model;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * ConstantPoolVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ConstantPoolVisitor extends BytecodeVisitor {
    public void visitClass(int nameIndex) throws IOException;

    public void visitDouble(double value) throws IOException;

    public void visitFieldReference(int nameIndex, int descriptorIndex) throws IOException;

    public void visitFloat(float value) throws IOException;

    public void visitInteger(int value) throws IOException;

    public void visitInterfaceMethodReference(int nameIndex, int descriptorIndex) throws IOException;

    public void visitInvokeDynamic(int methodIndex, int descriptorIndex) throws IOException;

    public void visitLong(long value) throws IOException;

    public void visitMethodHandle(int type, int referenceIndex) throws IOException;

    public void visitMethodReference(int nameIndex, int descriptorIndex) throws IOException;

    public void visitMethodType(int descriptorIndex) throws IOException;

    public void visitNameType(int nameIndex, int descriptorIndex) throws IOException;

    public void visitString(int valueIndex) throws IOException;

    public void visitUTF8(String value) throws IOException;
}
