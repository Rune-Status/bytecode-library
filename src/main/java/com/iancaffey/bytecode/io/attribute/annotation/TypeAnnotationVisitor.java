package com.iancaffey.bytecode.io.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeVisitor;
import com.iancaffey.bytecode.io.attribute.AnnotationVisitor;

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
            public TypeTargetVisitor visitTarget() {
                return TypeTargetVisitor.of(visitors.map(TypeAnnotationVisitor::visitTarget));
            }

            @Override
            public TypePathVisitor visitPath(int count) {
                return TypePathVisitor.of(visitors.map(visitor -> visitor.visitPath(count)));
            }

            @Override
            public AnnotationVisitor visitAnnotation() {
                return AnnotationVisitor.of(visitors.map(TypeAnnotationVisitor::visitAnnotation));
            }

            @Override
            public void end() {
                visitors.forEach(TypeAnnotationVisitor::end);
            }
        };
    }

    public TypeTargetVisitor visitTarget();

    public TypePathVisitor visitPath(int count);

    public AnnotationVisitor visitAnnotation();
}
