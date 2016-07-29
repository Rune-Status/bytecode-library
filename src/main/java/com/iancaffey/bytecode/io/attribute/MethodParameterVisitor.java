package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * MethodParameterVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface MethodParameterVisitor extends BytecodeVisitor {
    public static MethodParameterVisitor of(MethodParameterVisitor... visitors) {
        return MethodParameterVisitor.of(Arrays.stream(visitors));
    }

    public static MethodParameterVisitor of(Collection<MethodParameterVisitor> visitors) {
        return MethodParameterVisitor.of(visitors.stream());
    }

    public static MethodParameterVisitor of(Stream<MethodParameterVisitor> visitors) {
        return new MethodParameterVisitor() {
            @Override
            public void begin() {
                visitors.forEach(MethodParameterVisitor::begin);
            }

            @Override
            public void visit(int nameIndex, int access) {
                visitors.forEach(visitor -> visitor.visit(nameIndex, access));
            }

            @Override
            public void end() {
                visitors.forEach(MethodParameterVisitor::end);
            }
        };
    }

    public void visit(int nameIndex, int access);
}
