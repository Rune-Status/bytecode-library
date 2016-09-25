package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.IOException;

/**
 * ElementValueWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ElementValueWriter extends BytecodeWriter implements ElementValueVisitor {
    @Override
    public void visitByte(int index) throws IOException {

    }

    @Override
    public void visitCharacter(int index) throws IOException {

    }

    @Override
    public void visitDouble(int index) throws IOException {

    }

    @Override
    public void visitFloat(int index) throws IOException {

    }

    @Override
    public void visitInteger(int index) throws IOException {

    }

    @Override
    public void visitLong(int index) throws IOException {

    }

    @Override
    public void visitShort(int index) throws IOException {

    }

    @Override
    public void visitBoolean(int index) throws IOException {

    }

    @Override
    public void visitString(int index) throws IOException {

    }

    @Override
    public void visitEnum(int typeIndex, int nameIndex) throws IOException {

    }

    @Override
    public void visitClass(int index) throws IOException {

    }

    @Override
    public AnnotationVisitor visitAnnotation() throws IOException {
        return null;
    }

    @Override
    public ElementValueVisitor visitArray(int count) throws IOException {
        return null;
    }
}
