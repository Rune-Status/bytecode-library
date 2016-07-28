package com.iancaffey.bytecode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * AnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface AnnotationVisitor extends BytecodeVisitor {
    public static AnnotationVisitor of(AnnotationVisitor... visitors) {
        return AnnotationVisitor.of(Arrays.stream(visitors));
    }

    public static AnnotationVisitor of(Collection<AnnotationVisitor> visitors) {
        return AnnotationVisitor.of(visitors.stream());
    }

    public static AnnotationVisitor of(Stream<AnnotationVisitor> visitors) {
        return new AnnotationVisitor() {
            @Override
            public void begin() {
                visitors.forEach(AnnotationVisitor::begin);
            }

            @Override
            public void end() {
                visitors.forEach(AnnotationVisitor::end);
            }
        };
    }
}
