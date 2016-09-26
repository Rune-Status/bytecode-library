package com.iancaffey.bytecode.model;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * ConstantPoolWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ConstantPoolWriter extends BytecodeWriter implements ConstantPoolVisitor {
    public ConstantPoolWriter() {
    }

    public ConstantPoolWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visitClass(int nameIndex) throws IOException {
        writeByte(ConstantPoolHandler.CLASS);
        writeShort(nameIndex);
    }

    @Override
    public void visitDouble(double value) throws IOException {
        writeByte(ConstantPoolHandler.DOUBLE);
        writeDouble(value);
    }

    @Override
    public void visitFieldReference(int nameIndex, int descriptorIndex) throws IOException {
        writeByte(ConstantPoolHandler.FIELD_REFERENCE);
        writeShort(nameIndex);
        writeShort(descriptorIndex);
    }

    @Override
    public void visitFloat(float value) throws IOException {
        writeByte(ConstantPoolHandler.FLOAT);
        writeFloat(value);
    }

    @Override
    public void visitInteger(int value) throws IOException {
        writeByte(ConstantPoolHandler.INTEGER);
        writeInt(value);
    }

    @Override
    public void visitInterfaceMethodReference(int nameIndex, int descriptorIndex) throws IOException {
        writeByte(ConstantPoolHandler.INTERFACE_METHOD_REFERENCE);
        writeShort(nameIndex);
        writeShort(descriptorIndex);
    }

    @Override
    public void visitInvokeDynamic(int methodIndex, int descriptorIndex) throws IOException {
        writeByte(ConstantPoolHandler.INVOKE_DYNAMIC);
        writeShort(methodIndex);
        writeShort(descriptorIndex);
    }

    @Override
    public void visitLong(long value) throws IOException {
        writeByte(ConstantPoolHandler.LONG);
        writeLong(value);
    }

    @Override
    public void visitMethodHandle(int type, int referenceIndex) throws IOException {
        writeByte(ConstantPoolHandler.METHOD_HANDLE);
        writeByte(type);
        writeShort(referenceIndex);
    }

    @Override
    public void visitMethodReference(int nameIndex, int descriptorIndex) throws IOException {
        writeByte(ConstantPoolHandler.METHOD_REFERENCE);
        writeShort(nameIndex);
        writeShort(descriptorIndex);
    }

    @Override
    public void visitMethodType(int descriptorIndex) throws IOException {
        writeByte(ConstantPoolHandler.METHOD_TYPE);
        writeShort(descriptorIndex);
    }

    @Override
    public void visitNameType(int nameIndex, int descriptorIndex) throws IOException {
        writeByte(ConstantPoolHandler.NAME_TYPE);
        writeShort(nameIndex);
        writeShort(descriptorIndex);
    }

    @Override
    public void visitString(int valueIndex) throws IOException {
        writeByte(ConstantPoolHandler.STRING);
        writeShort(valueIndex);
    }

    @Override
    public void visitUTF8(String value) throws IOException {
        writeByte(ConstantPoolHandler.UTF8);
        writeUTF(value);
    }
}
