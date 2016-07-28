package com.iancaffey.bytecode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * ElementValueVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ElementValueVisitor extends BytecodeVisitor {
    public static ElementValueVisitor of(ElementValueVisitor... visitors) {
        return ElementValueVisitor.of(Arrays.stream(visitors));
    }

    public static ElementValueVisitor of(Collection<ElementValueVisitor> visitors) {
        return ElementValueVisitor.of(visitors.stream());
    }

    public static ElementValueVisitor of(Stream<ElementValueVisitor> visitors) {
        return new ElementValueVisitor() {
            @Override
            public void begin() {
                visitors.forEach(ElementValueVisitor::begin);
            }

            @Override
            public void end() {
                visitors.forEach(ElementValueVisitor::end);
            }
        };
    }
}
