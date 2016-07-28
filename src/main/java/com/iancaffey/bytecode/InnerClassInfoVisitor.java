package com.iancaffey.bytecode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * InnerClassInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface InnerClassInfoVisitor extends BytecodeVisitor {
    public static InnerClassInfoVisitor of(InnerClassInfoVisitor... visitors) {
        return InnerClassInfoVisitor.of(Arrays.stream(visitors));
    }

    public static InnerClassInfoVisitor of(Collection<InnerClassInfoVisitor> visitors) {
        return InnerClassInfoVisitor.of(visitors.stream());
    }

    public static InnerClassInfoVisitor of(Stream<InnerClassInfoVisitor> visitors) {
        return new InnerClassInfoVisitor() {
            @Override
            public void begin() {
                visitors.forEach(InnerClassInfoVisitor::begin);
            }

            @Override
            public void visit(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex, int innerClassAccess) {
                visitors.forEach(visitor -> visitor.visit(innerClassInfoIndex, outerClassInfoIndex, innerNameIndex, innerClassAccess));
            }

            @Override
            public void end() {
                visitors.forEach(InnerClassInfoVisitor::end);
            }
        };
    }

    public void visit(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex, int innerClassAccess);
}
