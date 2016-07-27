package com.iancaffey.bytecode.lang;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * ParameterVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ParameterVisitor extends BytecodeVisitor {
    public static ParameterVisitor of(ParameterVisitor... visitors) {
        return ParameterVisitor.of(Arrays.stream(visitors));
    }

    public static ParameterVisitor of(Collection<ParameterVisitor> visitors) {
        return ParameterVisitor.of(visitors.stream());
    }

    public static ParameterVisitor of(Stream<ParameterVisitor> visitors) {
        return new ParameterVisitor() {
            @Override
            public void begin() {
                visitors.forEach(ParameterVisitor::begin);
            }

            @Override
            public AnnotationVisitor visitAnnotations(int count) {
                return AnnotationVisitor.of(visitors.map(visitor -> visitor.visitAnnotations(count)));
            }

            @Override
            public void end() {
                visitors.forEach(ParameterVisitor::end);
            }
        };
    }

    public AnnotationVisitor visitAnnotations(int count);
}
