package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.io.visitor.ClassVisitorGroup;
import com.iancaffey.bytecode.io.visitor.ClassVisitorPair;

import java.util.Collection;

/**
 * ClassVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ClassVisitor extends BytecodeVisitor {
    public static ClassVisitor group(ClassVisitor one, ClassVisitor two) {
        return new ClassVisitorPair(one, two);
    }

    public static ClassVisitor group(ClassVisitor... visitors) {
        return new ClassVisitorGroup(visitors);
    }

    public static ClassVisitor group(Collection<ClassVisitor> visitors) {
        return new ClassVisitorGroup(visitors);
    }

    public default void visitMagic(int magic) {
    }

    public default void visitVersion(int major, int minor) {
    }

    public default void visitAccess() {
    }
}
