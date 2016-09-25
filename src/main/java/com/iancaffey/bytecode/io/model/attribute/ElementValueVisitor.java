package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * ElementValueVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ElementValueVisitor extends BytecodeVisitor {
    public void visitByte(int index) throws IOException;

    public void visitCharacter(int index) throws IOException;

    public void visitDouble(int index) throws IOException;

    public void visitFloat(int index) throws IOException;

    public void visitInteger(int index) throws IOException;

    public void visitLong(int index) throws IOException;

    public void visitShort(int index) throws IOException;

    public void visitBoolean(int index) throws IOException;

    public void visitString(int index) throws IOException;

    public void visitEnum(int typeIndex, int nameIndex) throws IOException;

    public void visitClass(int index) throws IOException;

    public AnnotationVisitor visitAnnotation() throws IOException;

    public ElementValueVisitor visitArray(int count) throws IOException;
}
