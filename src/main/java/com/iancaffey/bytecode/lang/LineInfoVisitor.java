package com.iancaffey.bytecode.lang;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * LineInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface LineInfoVisitor extends BytecodeVisitor {
    public static LineInfoVisitor of(LineInfoVisitor... visitors) {
        return LineInfoVisitor.of(Arrays.stream(visitors));
    }

    public static LineInfoVisitor of(Collection<LineInfoVisitor> visitors) {
        return LineInfoVisitor.of(visitors.stream());
    }

    public static LineInfoVisitor of(Stream<LineInfoVisitor> visitors) {
        return new LineInfoVisitor() {
            @Override
            public void begin() {
                visitors.forEach(LineInfoVisitor::begin);
            }

            @Override
            public void end() {
                visitors.forEach(LineInfoVisitor::end);
            }
        };
    }
}
