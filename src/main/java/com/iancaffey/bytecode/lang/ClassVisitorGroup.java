package com.iancaffey.bytecode.lang;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ClassVisitorGroup
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassVisitorGroup implements ClassVisitor {
    private final List<ClassVisitor> visitors;

    public ClassVisitorGroup(ClassVisitor... visitors) {
        this(Arrays.asList(visitors));
    }

    public ClassVisitorGroup(List<ClassVisitor> visitors) {
        if (visitors == null)
            throw new IllegalArgumentException();
        this.visitors = visitors;
    }

    @Override
    public void begin() {
        visitors.forEach(BytecodeVisitor::begin);
    }

    @Override
    public void visit(int access, int major, int minor, String name, String superName, String[] interfaces) {
        visitors.forEach(visitor -> visitor.visit(access, major, minor, name, superName, interfaces));
    }

    @Override
    public void end() {
        Collections.reverse(visitors);
        visitors.forEach(BytecodeVisitor::end);
    }
}
