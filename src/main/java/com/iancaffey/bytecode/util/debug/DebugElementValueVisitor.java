package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.direct.attribute.AnnotationVisitor;
import com.iancaffey.bytecode.io.direct.attribute.ElementValueVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugElementValueVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugElementValueVisitor extends DebugVisitor implements ElementValueVisitor {
    public DebugElementValueVisitor() {
    }

    public DebugElementValueVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visitByte(int index) {
        log(String.format("Byte [index=%d]", index), 1);
    }

    @Override
    public void visitCharacter(int index) {
        log(String.format("Character [index=%d]", index), 1);
    }

    @Override
    public void visitDouble(int index) {
        log(String.format("Double [index=%d]", index), 1);
    }

    @Override
    public void visitFloat(int index) {
        log(String.format("Float [index=%d]", index), 1);
    }

    @Override
    public void visitInteger(int index) {
        log(String.format("Integer [index=%d]", index), 1);
    }

    @Override
    public void visitLong(int index) {
        log(String.format("Long [index=%d]", index), 1);
    }

    @Override
    public void visitShort(int index) {
        log(String.format("Short [index=%d]", index), 1);
    }

    @Override
    public void visitBoolean(int index) {
        log(String.format("Boolean [index=%d]", index), 1);
    }

    @Override
    public void visitString(int index) {
        log(String.format("String [index=%d]", index), 1);
    }

    @Override
    public void visitEnum(int typeIndex, int nameIndex) {
        log(String.format("Enum [typeIndex=%d, nameIndex=%d]", typeIndex, nameIndex), 1);
    }

    @Override
    public void visitClass(int index) {
        log(String.format("Class [index=%d]", index), 1);
    }

    @Override
    public AnnotationVisitor visitAnnotation() {
        log("Annotation", 1);
        return new DebugAnnotationVisitor(indent() + 1);
    }

    @Override
    public ElementValueVisitor visitArray(int count) {
        log(String.format("Array [count=%d]", count), 1);
        return new DebugElementValueVisitor(indent() + 1);
    }
}
