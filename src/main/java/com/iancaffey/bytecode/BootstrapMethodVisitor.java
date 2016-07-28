package com.iancaffey.bytecode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * BootstrapMethodVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface BootstrapMethodVisitor extends BytecodeVisitor {
    public static BootstrapMethodVisitor of(BootstrapMethodVisitor... visitors) {
        return BootstrapMethodVisitor.of(Arrays.stream(visitors));
    }

    public static BootstrapMethodVisitor of(Collection<BootstrapMethodVisitor> visitors) {
        return BootstrapMethodVisitor.of(visitors.stream());
    }

    public static BootstrapMethodVisitor of(Stream<BootstrapMethodVisitor> visitors) {
        return new BootstrapMethodVisitor() {
            @Override
            public void begin() {
                visitors.forEach(BootstrapMethodVisitor::begin);
            }

            @Override
            public void end() {
                visitors.forEach(BootstrapMethodVisitor::end);
            }
        };
    }
}
