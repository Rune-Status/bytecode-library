package com.iancaffey.bytecode.lang;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * CodeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface CodeVisitor extends BytecodeVisitor {
    public static CodeVisitor of(CodeVisitor... visitors) {
        return CodeVisitor.of(Arrays.stream(visitors));
    }

    public static CodeVisitor of(Collection<CodeVisitor> visitors) {
        return CodeVisitor.of(visitors.stream());
    }

    public static CodeVisitor of(Stream<CodeVisitor> visitors) {
        return new CodeVisitor() {
            @Override
            public void begin() {
                visitors.forEach(CodeVisitor::begin);
            }

            @Override
            public void visitDepth(int maxStack, int maxLocals) {
                visitors.forEach(visitor -> visitor.visitDepth(maxStack, maxLocals));
            }

            @Override
            public void visitData(byte[] data) {
                visitors.forEach(visitor -> visitor.visitData(data));
            }

            @Override
            public ExceptionVisitor visitExceptionTable(int count) {
                return ExceptionVisitor.of(visitors.map(visitor -> visitor.visitExceptionTable(count)));
            }

            @Override
            public AttributeVisitor visitAttributes(int count) {
                return AttributeVisitor.of(visitors.map(visitor -> visitor.visitAttributes(count)));
            }

            @Override
            public void end() {
                visitors.forEach(CodeVisitor::end);
            }
        };
    }

    public void visitDepth(int maxStack, int maxLocals);

    public void visitData(byte[] data);

    public ExceptionVisitor visitExceptionTable(int count);

    public AttributeVisitor visitAttributes(int count);
}
