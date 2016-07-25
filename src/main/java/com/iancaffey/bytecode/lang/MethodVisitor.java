package com.iancaffey.bytecode.lang;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * MethodVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface MethodVisitor extends BytecodeVisitor {
    public static MethodVisitor of(MethodVisitor... visitors) {
        return MethodVisitor.of(Arrays.asList(visitors));
    }

    public static MethodVisitor of(List<MethodVisitor> visitors) {
        return new MethodVisitor() {
            @Override
            public void begin() {
                visitors.forEach(MethodVisitor::begin);
            }

            @Override
            public void end() {
                Collections.reverse(visitors);
                visitors.forEach(MethodVisitor::end);
            }
        };
    }
}
