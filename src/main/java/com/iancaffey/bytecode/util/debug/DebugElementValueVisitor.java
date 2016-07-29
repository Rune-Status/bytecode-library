package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.attribute.AnnotationVisitor;
import com.iancaffey.bytecode.io.attribute.ElementValueVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugElementValueVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugElementValueVisitor extends DebugVisitor implements ElementValueVisitor {
    public DebugElementValueVisitor() {
        super("ElementValue");
    }

    public DebugElementValueVisitor(int indent) {
        super("ElementValue", indent);
    }

    @Override
    public void visitByte(int index) {

    }

    @Override
    public void visitCharacter(int index) {

    }

    @Override
    public void visitDouble(int index) {

    }

    @Override
    public void visitFloat(int index) {

    }

    @Override
    public void visitInteger(int index) {

    }

    @Override
    public void visitLong(int index) {

    }

    @Override
    public void visitShort(int index) {

    }

    @Override
    public void visitBoolean(int index) {

    }

    @Override
    public void visitString(int index) {

    }

    @Override
    public void visitEnum(int typeIndex, int nameIndex) {

    }

    @Override
    public void visitClass(int index) {

    }

    @Override
    public AnnotationVisitor visitAnnotation() {
        return new DebugAnnotationVisitor(indent() + 1);
    }

    @Override
    public ElementValueVisitor visitArray(int count) {
        return new DebugElementValueVisitor(indent() + 1);
    }
}
