package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * LocalVariableVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface LocalVariableVisitor extends BytecodeVisitor {
    public static LocalVariableVisitor of(LocalVariableVisitor... visitors) {
        return LocalVariableVisitor.of(Arrays.stream(visitors));
    }

    public static LocalVariableVisitor of(Collection<LocalVariableVisitor> visitors) {
        return LocalVariableVisitor.of(visitors.stream());
    }

    public static LocalVariableVisitor of(Stream<LocalVariableVisitor> visitors) {
        return new LocalVariableVisitor() {
            @Override
            public void begin() {
                visitors.forEach(LocalVariableVisitor::begin);
            }

            @Override
            public void visit(int startIndex, int length, int nameIndex, int descriptorIndex, int index) {
                visitors.forEach(visitor -> visitor.visit(startIndex, length, nameIndex, descriptorIndex, index));
            }

            @Override
            public void end() {
                visitors.forEach(LocalVariableVisitor::end);
            }
        };
    }

    public void visit(int startIndex, int length, int nameIndex, int descriptorIndex, int index);
}
