package com.iancaffey.bytecode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * ElementValuePairVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ElementValuePairVisitor extends BytecodeVisitor {
    public static ElementValuePairVisitor of(ElementValuePairVisitor... visitors) {
        return ElementValuePairVisitor.of(Arrays.stream(visitors));
    }

    public static ElementValuePairVisitor of(Collection<ElementValuePairVisitor> visitors) {
        return ElementValuePairVisitor.of(visitors.stream());
    }

    public static ElementValuePairVisitor of(Stream<ElementValuePairVisitor> visitors) {
        return new ElementValuePairVisitor() {
            @Override
            public void begin() {
                visitors.forEach(ElementValuePairVisitor::begin);
            }

            @Override
            public ElementValueVisitor visit(int index) {
                return ElementValueVisitor.of(visitors.map(visitor -> visitor.visit(index)));
            }

            @Override
            public void end() {
                visitors.forEach(ElementValuePairVisitor::end);
            }
        };
    }

    public ElementValueVisitor visit(int index);
}
