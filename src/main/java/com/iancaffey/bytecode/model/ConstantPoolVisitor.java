package com.iancaffey.bytecode.model;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * ConstantPoolVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ConstantPoolVisitor extends BytecodeVisitor {
    void visitClass(int nameIndex) throws IOException;

    void visitDouble(double value) throws IOException;

    void visitFieldReference(int nameIndex, int descriptorIndex) throws IOException;

    void visitFloat(float value) throws IOException;

    void visitInteger(int value) throws IOException;

    void visitInterfaceMethodReference(int nameIndex, int descriptorIndex) throws IOException;

    void visitInvokeDynamic(int methodIndex, int descriptorIndex) throws IOException;

    void visitLong(long value) throws IOException;

    void visitMethodHandle(int type, int referenceIndex) throws IOException;

    void visitMethodReference(int nameIndex, int descriptorIndex) throws IOException;

    void visitMethodType(int descriptorIndex) throws IOException;

    void visitNameType(int nameIndex, int descriptorIndex) throws IOException;

    void visitString(int valueIndex) throws IOException;

    void visitUTF8(String value) throws IOException;
}
