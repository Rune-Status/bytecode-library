package com.iancaffey.bytecode.lang;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * FieldVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface FieldVisitor extends BytecodeVisitor {
    public static FieldVisitor of(FieldVisitor... visitors) {
        return FieldVisitor.of(Arrays.asList(visitors));
    }

    public static FieldVisitor of(List<FieldVisitor> visitors) {
        return new FieldVisitor() {
            @Override
            public void begin() {
                visitors.forEach(FieldVisitor::begin);
            }

            @Override
            public void end() {
                Collections.reverse(visitors);
                visitors.forEach(FieldVisitor::end);
            }
        };
    }
}
