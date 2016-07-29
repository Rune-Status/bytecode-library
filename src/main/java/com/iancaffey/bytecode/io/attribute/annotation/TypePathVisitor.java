package com.iancaffey.bytecode.io.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * TypePathVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface TypePathVisitor extends BytecodeVisitor {
    public static TypePathVisitor of(TypePathVisitor... visitors) {
        return TypePathVisitor.of(Arrays.stream(visitors));
    }

    public static TypePathVisitor of(Collection<TypePathVisitor> visitors) {
        return TypePathVisitor.of(visitors.stream());
    }

    public static TypePathVisitor of(Stream<TypePathVisitor> visitors) {
        return new TypePathVisitor() {
            @Override
            public void begin() {
                visitors.forEach(TypePathVisitor::begin);
            }

            @Override
            public void visit(int type, int index) {
                visitors.forEach(visitor -> visitor.visit(type, index));
            }

            @Override
            public void end() {
                visitors.forEach(TypePathVisitor::end);
            }
        };
    }

    public void visit(int type, int index);
}
