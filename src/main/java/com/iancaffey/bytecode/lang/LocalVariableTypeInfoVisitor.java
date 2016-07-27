package com.iancaffey.bytecode.lang;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * LocalVariableTypeInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface LocalVariableTypeInfoVisitor extends BytecodeVisitor {
    public static LocalVariableTypeInfoVisitor of(LocalVariableTypeInfoVisitor... visitors) {
        return LocalVariableTypeInfoVisitor.of(Arrays.stream(visitors));
    }

    public static LocalVariableTypeInfoVisitor of(Collection<LocalVariableTypeInfoVisitor> visitors) {
        return LocalVariableTypeInfoVisitor.of(visitors.stream());
    }

    public static LocalVariableTypeInfoVisitor of(Stream<LocalVariableTypeInfoVisitor> visitors) {
        return new LocalVariableTypeInfoVisitor() {
            @Override
            public void begin() {
                visitors.forEach(LocalVariableTypeInfoVisitor::begin);
            }

            @Override
            public void end() {
                visitors.forEach(LocalVariableTypeInfoVisitor::end);
            }
        };
    }
}
