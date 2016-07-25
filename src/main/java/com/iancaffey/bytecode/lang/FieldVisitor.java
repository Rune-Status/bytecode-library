package com.iancaffey.bytecode.lang;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * FieldVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface FieldVisitor extends BytecodeVisitor {
    public static FieldVisitor of(FieldVisitor... visitors) {
        return FieldVisitor.of(Arrays.stream(visitors));
    }

    public static FieldVisitor of(Collection<FieldVisitor> visitors) {
        return FieldVisitor.of(visitors.stream());
    }

    public static FieldVisitor of(Stream<FieldVisitor> visitors) {
        return new FieldVisitor() {
            @Override
            public void begin() {
                visitors.forEach(FieldVisitor::begin);
            }

            @Override
            public void visit(int access, int nameIndex, int descriptorIndex) {
                visitors.forEach(visitor -> visitor.visit(access, nameIndex, descriptorIndex));
            }

            @Override
            public AttributeVisitor visitAttributes(int count) {
                return AttributeVisitor.of(visitors.map(visitor -> visitAttributes(count)));
            }

            @Override
            public void end() {
                visitors.forEach(FieldVisitor::end);
            }
        };
    }

    public void visit(int access, int nameIndex, int descriptorIndex);

    public AttributeVisitor visitAttributes(int count);
}
