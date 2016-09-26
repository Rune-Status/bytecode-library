package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * ElementValueWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ElementValueWriter extends BytecodeWriter implements ElementValueVisitor {
    public ElementValueWriter() {
    }

    public ElementValueWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visitByte(int index) throws IOException {
        writeByte(ElementValueHandler.BYTE);
        writeShort(index);
    }

    @Override
    public void visitCharacter(int index) throws IOException {
        writeByte(ElementValueHandler.CHARACTER);
        writeShort(index);
    }

    @Override
    public void visitDouble(int index) throws IOException {
        writeByte(ElementValueHandler.DOUBLE);
        writeShort(index);
    }

    @Override
    public void visitFloat(int index) throws IOException {
        writeByte(ElementValueHandler.FLOAT);
        writeShort(index);
    }

    @Override
    public void visitInteger(int index) throws IOException {
        writeByte(ElementValueHandler.INTEGER);
        writeShort(index);
    }

    @Override
    public void visitLong(int index) throws IOException {
        writeByte(ElementValueHandler.LONG);
        writeShort(index);
    }

    @Override
    public void visitShort(int index) throws IOException {
        writeByte(ElementValueHandler.SHORT);
        writeShort(index);
    }

    @Override
    public void visitBoolean(int index) throws IOException {
        writeByte(ElementValueHandler.BOOLEAN);
        writeShort(index);
    }

    @Override
    public void visitString(int index) throws IOException {
        writeByte(ElementValueHandler.STRING);
        writeShort(index);
    }

    @Override
    public void visitEnum(int typeIndex, int nameIndex) throws IOException {
        writeByte(ElementValueHandler.BYTE);
        writeShort(typeIndex);
        writeShort(nameIndex);
    }

    @Override
    public void visitClass(int index) throws IOException {
        writeByte(ElementValueHandler.CLASS);
        writeShort(index);
    }

    @Override
    public AnnotationVisitor visitAnnotation() throws IOException {
        writeByte(ElementValueHandler.ANNOTATION);
        return new AnnotationWriter((ByteArrayOutputStream) out);
    }

    @Override
    public ElementValueVisitor visitArray(int count) throws IOException {
        writeByte(ElementValueHandler.ARRAY);
        writeShort(count);
        return new ElementValueWriter((ByteArrayOutputStream) out);
    }
}
