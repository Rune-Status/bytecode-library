package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * ElementValueVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ElementValueVisitor extends BytecodeVisitor {
    public static ElementValueVisitor of(ElementValueVisitor... visitors) {
        return ElementValueVisitor.of(Arrays.stream(visitors));
    }

    public static ElementValueVisitor of(Collection<ElementValueVisitor> visitors) {
        return ElementValueVisitor.of(visitors.stream());
    }

    public static ElementValueVisitor of(Stream<ElementValueVisitor> visitors) {
        return new ElementValueVisitor() {
            @Override
            public void begin() {
                visitors.forEach(ElementValueVisitor::begin);
            }

            @Override
            public void visitByte(int index) {
                visitors.forEach(visitor -> visitor.visitByte(index));
            }

            @Override
            public void visitCharacter(int index) {
                visitors.forEach(visitor -> visitor.visitCharacter(index));
            }

            @Override
            public void visitDouble(int index) {
                visitors.forEach(visitor -> visitor.visitDouble(index));
            }

            @Override
            public void visitFloat(int index) {
                visitors.forEach(visitor -> visitor.visitFloat(index));
            }

            @Override
            public void visitInteger(int index) {
                visitors.forEach(visitor -> visitor.visitInteger(index));
            }

            @Override
            public void visitLong(int index) {
                visitors.forEach(visitor -> visitor.visitLong(index));
            }

            @Override
            public void visitShort(int index) {
                visitors.forEach(visitor -> visitor.visitShort(index));
            }

            @Override
            public void visitBoolean(int index) {
                visitors.forEach(visitor -> visitor.visitBoolean(index));
            }

            @Override
            public void visitString(int index) {
                visitors.forEach(visitor -> visitor.visitString(index));
            }

            @Override
            public void visitEnum(int typeIndex, int nameIndex) {
                visitors.forEach(visitor -> visitor.visitEnum(typeIndex, nameIndex));
            }

            @Override
            public void visitClass(int index) {
                visitors.forEach(visitor -> visitor.visitClass(index));
            }

            @Override
            public AnnotationVisitor visitAnnotation() {
                return AnnotationVisitor.of(visitors.map(ElementValueVisitor::visitAnnotation));
            }

            @Override
            public ElementValueVisitor visitArray(int count) {
                return ElementValueVisitor.of(visitors.map(visitor -> visitor.visitArray(count)));
            }

            @Override
            public void end() {
                visitors.forEach(ElementValueVisitor::end);
            }
        };
    }

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
