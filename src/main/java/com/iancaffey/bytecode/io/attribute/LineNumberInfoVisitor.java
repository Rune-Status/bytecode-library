package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * LineNumberInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface LineNumberInfoVisitor extends BytecodeVisitor {
    public static LineNumberInfoVisitor of(LineNumberInfoVisitor... visitors) {
        return LineNumberInfoVisitor.of(Arrays.stream(visitors));
    }

    public static LineNumberInfoVisitor of(Collection<LineNumberInfoVisitor> visitors) {
        return LineNumberInfoVisitor.of(visitors.stream());
    }

    public static LineNumberInfoVisitor of(Stream<LineNumberInfoVisitor> visitors) {
        return new LineNumberInfoVisitor() {
            @Override
            public void begin() {
                visitors.forEach(LineNumberInfoVisitor::begin);
            }

            @Override
            public void visit(int startIndex, int number) {
                visitors.forEach(visitor -> visitor.visit(startIndex, number));
            }

            @Override
            public void end() {
                visitors.forEach(LineNumberInfoVisitor::end);
            }
        };
    }

    public void visit(int startIndex, int number);
}
