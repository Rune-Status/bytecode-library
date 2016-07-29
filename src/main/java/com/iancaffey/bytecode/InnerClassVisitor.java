package com.iancaffey.bytecode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * InnerClassVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface InnerClassVisitor extends BytecodeVisitor {
    public static InnerClassVisitor of(InnerClassVisitor... visitors) {
        return InnerClassVisitor.of(Arrays.stream(visitors));
    }

    public static InnerClassVisitor of(Collection<InnerClassVisitor> visitors) {
        return InnerClassVisitor.of(visitors.stream());
    }

    public static InnerClassVisitor of(Stream<InnerClassVisitor> visitors) {
        return new InnerClassVisitor() {
            @Override
            public void begin() {
                visitors.forEach(InnerClassVisitor::begin);
            }

            @Override
            public void visit(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex, int innerClassAccess) {
                visitors.forEach(visitor -> visitor.visit(innerClassInfoIndex, outerClassInfoIndex, innerNameIndex, innerClassAccess));
            }

            @Override
            public void end() {
                visitors.forEach(InnerClassVisitor::end);
            }
        };
    }

    public void visit(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex, int innerClassAccess);
}
