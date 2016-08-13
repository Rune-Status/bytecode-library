package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * ElementValueVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ElementValueVisitor extends BytecodeVisitor {
    public void visitByte(int index);

    public void visitCharacter(int index);

    public void visitDouble(int index);

    public void visitFloat(int index);

    public void visitInteger(int index);

    public void visitLong(int index);

    public void visitShort(int index);

    public void visitBoolean(int index);

    public void visitString(int index);

    public void visitEnum(int typeIndex, int nameIndex);

    public void visitClass(int index);

    public AnnotationVisitor visitAnnotation();

    public ElementValueVisitor visitArray(int count);
}
