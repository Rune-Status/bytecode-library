package com.iancaffey.bytecode.lang;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * MethodVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface MethodVisitor extends BytecodeVisitor {
    public static MethodVisitor of(MethodVisitor... visitors) {
        return MethodVisitor.of(Arrays.stream(visitors));
    }

    public static MethodVisitor of(Collection<MethodVisitor> visitors) {
        return MethodVisitor.of(visitors.stream());
    }

    public static MethodVisitor of(Stream<MethodVisitor> visitors) {
        return new MethodVisitor() {
            @Override
            public void begin() {
                visitors.forEach(MethodVisitor::begin);
            }

            @Override
            public void end() {
                visitors.forEach(MethodVisitor::end);
            }
        };
    }
}
