package com.iancaffey.bytecode.io.visitor;

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
    public void visitMagic(int magic) {
        one.visitMagic(magic);
        two.visitMagic(magic);
    }

    @Override
    public void visitVersion(int major, int minor) {
        one.visitVersion(major, minor);
        two.visitVersion(major, minor);
    }

    @Override
    public void visitAccess() {
        one.visitAccess();
        two.visitAccess();
    }

    @Override
    public void end() {
        one.begin();
        two.begin();
    }
}
