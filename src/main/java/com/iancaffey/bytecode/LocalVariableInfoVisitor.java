package com.iancaffey.bytecode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * LocalVariableInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface LocalVariableInfoVisitor extends BytecodeVisitor {
    public static LocalVariableInfoVisitor of(LocalVariableInfoVisitor... visitors) {
        return LocalVariableInfoVisitor.of(Arrays.stream(visitors));
    }

    public static LocalVariableInfoVisitor of(Collection<LocalVariableInfoVisitor> visitors) {
        return LocalVariableInfoVisitor.of(visitors.stream());
    }

    public static LocalVariableInfoVisitor of(Stream<LocalVariableInfoVisitor> visitors) {
        return new LocalVariableInfoVisitor() {
            @Override
            public void begin() {
                visitors.forEach(LocalVariableInfoVisitor::begin);
            }

            @Override
            public void visit(int startIndex, int length, int nameIndex, int descriptorIndex, int index) {
                visitors.forEach(visitor -> visitor.visit(startIndex, length, nameIndex, descriptorIndex, index));
            }

            @Override
            public void end() {
                visitors.forEach(LocalVariableInfoVisitor::end);
            }
        };
    }

    public void visit(int startIndex, int length, int nameIndex, int descriptorIndex, int index);
}
