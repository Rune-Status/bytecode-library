package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * ParameterAnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ParameterAnnotationVisitor extends BytecodeVisitor {
    public static ParameterAnnotationVisitor of(ParameterAnnotationVisitor... visitors) {
        return ParameterAnnotationVisitor.of(Arrays.stream(visitors));
    }

    public static ParameterAnnotationVisitor of(Collection<ParameterAnnotationVisitor> visitors) {
        return ParameterAnnotationVisitor.of(visitors.stream());
    }

    public static ParameterAnnotationVisitor of(Stream<ParameterAnnotationVisitor> visitors) {
        return new ParameterAnnotationVisitor() {
            @Override
            public void begin() {
                visitors.forEach(ParameterAnnotationVisitor::begin);
            }

            @Override
            public AnnotationVisitor visitAnnotations(int count) {
                return AnnotationVisitor.of(visitors.map(visitor -> visitor.visitAnnotations(count)));
            }

            @Override
            public void end() {
                visitors.forEach(ParameterAnnotationVisitor::end);
            }
        };
    }

    public AnnotationVisitor visitAnnotations(int count);
}
