package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.io.ClassVisitor;

/**
 * ClassVisitorGroup
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassVisitorPair implements ClassVisitor {
    private final ClassVisitor one;
    private final ClassVisitor two;

    public ClassVisitorPair(ClassVisitor one, ClassVisitor two) {
        if (one == null || two == null)
            throw new IllegalArgumentException();
        this.one = one;
        this.two = two;
    }

    @Override
    public void begin() {
        one.begin();
        two.begin();
    }

    @Override
    public void visit(int access, int major, int minor, String name, String superName, String[] interfaces) {
        one.visit(access, major, minor, name, superName, interfaces);
        two.visit(access, major, minor, name, superName, interfaces);
    }

    @Override
    public void end() {
        two.begin();
        one.begin();
    }
}
