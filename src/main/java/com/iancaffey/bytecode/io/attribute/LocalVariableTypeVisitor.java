package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * LocalVariableTypeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface LocalVariableTypeVisitor extends BytecodeVisitor {
    public static LocalVariableTypeVisitor of(LocalVariableTypeVisitor... visitors) {
        return LocalVariableTypeVisitor.of(Arrays.stream(visitors));
    }

    public static LocalVariableTypeVisitor of(Collection<LocalVariableTypeVisitor> visitors) {
        return LocalVariableTypeVisitor.of(visitors.stream());
    }

    public static LocalVariableTypeVisitor of(Stream<LocalVariableTypeVisitor> visitors) {
        return new LocalVariableTypeVisitor() {
            @Override
            public void begin() {
                visitors.forEach(LocalVariableTypeVisitor::begin);
            }

            @Override
            public void visit(int startIndex, int length, int nameIndex, int signatureIndex, int index) {
                visitors.forEach(visitor -> visitor.visit(startIndex, length, nameIndex, signatureIndex, index));
            }

            @Override
            public void end() {
                visitors.forEach(LocalVariableTypeVisitor::end);
            }
        };
    }

    public void visit(int startIndex, int length, int nameIndex, int signatureIndex, int index);
}
