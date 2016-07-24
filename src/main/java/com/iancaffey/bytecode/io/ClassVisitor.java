package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.util.ClassVisitorGroup;
import com.iancaffey.bytecode.util.ClassVisitorPair;

import java.util.List;

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

    public static ClassVisitor group(List<ClassVisitor> visitors) {
        return new ClassVisitorGroup(visitors);
    }

    public default void visit(int access, int major, int minor, String name, String superName, String[] interfaces) {

    }

    public default FieldVisitor visitField(int access, String name, String description) {
        return null;
    }

    public default MethodVisitor visitMethod(int access, String name, String description) {
        return null;
    }
}
