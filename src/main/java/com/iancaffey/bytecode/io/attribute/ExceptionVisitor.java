package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * ExceptionVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ExceptionVisitor extends BytecodeVisitor {
    public static ExceptionVisitor of(ExceptionVisitor... visitors) {
        return ExceptionVisitor.of(Arrays.stream(visitors));
    }

    public static ExceptionVisitor of(Collection<ExceptionVisitor> visitors) {
        return ExceptionVisitor.of(visitors.stream());
    }

    public static ExceptionVisitor of(Stream<ExceptionVisitor> visitors) {
        return new ExceptionVisitor() {
            @Override
            public void begin() {
                visitors.forEach(ExceptionVisitor::begin);
            }

            @Override
            public void visit(int startIndex, int endIndex, int handlerIndex, int catchIndex) {
                visitors.forEach(visitor -> visitor.visit(startIndex, endIndex, handlerIndex, catchIndex));
            }

            @Override
            public void end() {
                visitors.forEach(ExceptionVisitor::end);
            }
        };
    }

    public void visit(int startIndex, int endIndex, int handlerIndex, int catchIndex);
}