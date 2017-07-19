package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * ElementValueVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ElementValueVisitor extends BytecodeVisitor {
    void visitByte(int index) throws IOException;

    void visitCharacter(int index) throws IOException;

    void visitDouble(int index) throws IOException;

    void visitFloat(int index) throws IOException;

    void visitInteger(int index) throws IOException;

    void visitLong(int index) throws IOException;

    void visitShort(int index) throws IOException;

    void visitBoolean(int index) throws IOException;

    void visitString(int index) throws IOException;

    void visitEnum(int typeIndex, int nameIndex) throws IOException;

    void visitClass(int index) throws IOException;

    AnnotationVisitor visitAnnotation() throws IOException;

    ElementValueVisitor visitArray(int count) throws IOException;
}
