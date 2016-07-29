package com.iancaffey.bytecode;

import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * MethodVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface MethodVisitor extends BytecodeVisitor {
    public static MethodVisitor of(MethodVisitor... visitors) {
        return MethodVisitor.of(Arrays.stream(visitors));
    }

    public static MethodVisitor of(Collection<MethodVisitor> visitors) {
        return MethodVisitor.of(visitors.stream());
    }

    public static MethodVisitor of(Stream<MethodVisitor> visitors) {
        return new MethodVisitor() {
            @Override
            public void begin() {
                visitors.forEach(MethodVisitor::begin);
            }

            @Override
            public void visit(int access, int nameIndex, int descriptorIndex) {
                visitors.forEach(visitor -> visitor.visit(access, nameIndex, descriptorIndex));
            }

            @Override
            public AttributeVisitor visitAttributes(int count) {
                return AttributeVisitor.of(visitors.map(visitor -> visitAttributes(count)));
            }

            @Override
            public void end() {
                visitors.forEach(MethodVisitor::end);
            }
        };
    }

    public void visit(int access, int nameIndex, int descriptorIndex);

    public AttributeVisitor visitAttributes(int count);
}
