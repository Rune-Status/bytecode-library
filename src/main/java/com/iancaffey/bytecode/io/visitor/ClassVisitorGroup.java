package com.iancaffey.bytecode.io.visitor;

import com.iancaffey.bytecode.io.BytecodeVisitor;
import com.iancaffey.bytecode.io.ClassVisitor;

import java.util.Arrays;
import java.util.Collection;

/**
 * ClassVisitorGroup
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassVisitorGroup implements ClassVisitor {
    private final Collection<ClassVisitor> visitors;

    public ClassVisitorGroup(ClassVisitor... visitors) {
        this(Arrays.asList(visitors));
    }

    public ClassVisitorGroup(Collection<ClassVisitor> visitors) {
        if (visitors == null)
            throw new IllegalArgumentException();
        this.visitors = visitors;
    }

    @Override
    public void begin() {
        visitors.forEach(BytecodeVisitor::begin);
    }

    @Override
    public void visitMagic(int magic) {
        visitors.forEach(visitor -> visitor.visitMagic(magic));
    }

    @Override
    public void visitVersion(int major, int minor) {
        visitors.forEach(visitor -> visitor.visitVersion(major, minor));
    }

    @Override
    public void visitAccess() {
        visitors.forEach(visitor -> visitor.visitAccess());
    }

    @Override
    public void end() {
        visitors.forEach(BytecodeVisitor::end);
    }
}
