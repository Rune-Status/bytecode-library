package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * LocalVariableTargetVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface LocalVariableTargetVisitor extends BytecodeVisitor {
    public static LocalVariableTargetVisitor of(LocalVariableTargetVisitor... visitors) {
        return LocalVariableTargetVisitor.of(Arrays.stream(visitors));
    }

    public static LocalVariableTargetVisitor of(Collection<LocalVariableTargetVisitor> visitors) {
        return LocalVariableTargetVisitor.of(visitors.stream());
    }

    public static LocalVariableTargetVisitor of(Stream<LocalVariableTargetVisitor> visitors) {
        return new LocalVariableTargetVisitor() {
            @Override
            public void begin() {
                visitors.forEach(LocalVariableTargetVisitor::begin);
            }

            @Override
            public void visit(int startIndex, int length, int index) {
                visitors.forEach(visitor -> visitor.visit(startIndex, length, index));
            }

            @Override
            public void end() {
                visitors.forEach(LocalVariableTargetVisitor::end);
            }
        };
    }

    public void visit(int startIndex, int length, int index);
}
