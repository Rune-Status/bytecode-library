package com.iancaffey.bytecode.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeWriter;
import com.iancaffey.bytecode.model.attribute.LocalVariableTargetVisitor;
import com.iancaffey.bytecode.model.attribute.LocalVariableTargetWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * TypeTargetWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class TypeTargetWriter extends BytecodeWriter implements TypeTargetVisitor {
    public TypeTargetWriter() {
    }

    public TypeTargetWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visitTypeParameter(int index) throws IOException {
        writeByte(index);
    }

    @Override
    public void visitSuperType(int index) throws IOException {
        writeShort(index);
    }

    @Override
    public void visitTypeParameterBound(int parameterIndex, int boundIndex) throws IOException {
        writeByte(parameterIndex);
        writeByte(boundIndex);
    }

    @Override
    public void visitEmpty() throws IOException {

    }

    @Override
    public void visitFormalParameter(int index) throws IOException {
        writeByte(index);
    }

    @Override
    public void visitThrows(int index) throws IOException {
        writeShort(index);
    }

    @Override
    public LocalVariableTargetVisitor visitLocalVariable(int count) throws IOException {
        writeShort(count);
        return new LocalVariableTargetWriter((ByteArrayOutputStream) out);
    }

    @Override
    public void visitCatch(int index) throws IOException {
        writeShort(index);
    }

    @Override
    public void visitOffset(int index) throws IOException {
        writeShort(index);
    }

    @Override
    public void visitTypeArgument(int offset, int index) throws IOException {
        writeShort(offset);
        writeByte(index);
    }
}
