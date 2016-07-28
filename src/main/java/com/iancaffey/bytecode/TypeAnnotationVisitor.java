package com.iancaffey.bytecode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * TypeAnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface TypeAnnotationVisitor extends BytecodeVisitor {
    public static TypeAnnotationVisitor of(TypeAnnotationVisitor... visitors) {
        return TypeAnnotationVisitor.of(Arrays.stream(visitors));
    }

    public static TypeAnnotationVisitor of(Collection<TypeAnnotationVisitor> visitors) {
        return TypeAnnotationVisitor.of(visitors.stream());
    }

    public static TypeAnnotationVisitor of(Stream<TypeAnnotationVisitor> visitors) {
        return new TypeAnnotationVisitor() {
            @Override
            public void begin() {
                visitors.forEach(TypeAnnotationVisitor::begin);
            }

            @Override
            public void end() {
                visitors.forEach(TypeAnnotationVisitor::end);
            }
        };
    }
}
