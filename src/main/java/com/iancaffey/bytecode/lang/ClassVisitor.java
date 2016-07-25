package com.iancaffey.bytecode.lang;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ClassVisitor extends BytecodeVisitor {
    public static ClassVisitor of(ClassVisitor... visitors) {
        return ClassVisitor.of(Arrays.asList(visitors));
    }

    public static ClassVisitor of(List<ClassVisitor> visitors) {
        return new ClassVisitor() {
            @Override
            public void begin() {
                visitors.forEach(ClassVisitor::begin);
            }

            @Override
            public void visit(int access, int major, int minor, String name, String superName, String[] interfaces) {
                visitors.forEach(visitor -> visit(access, major, minor, name, superName, interfaces));
            }

            @Override
            public FieldVisitor visitField(int access, String name, String description) {
                return FieldVisitor.of(visitors.stream().map(visitor -> visitor.visitField(access, name, description)).collect(Collectors.toList()));
            }

            @Override
            public MethodVisitor visitMethod(int access, String name, String description) {
                return MethodVisitor.of(visitors.stream().map(visitor -> visitor.visitMethod(access, name, description)).collect(Collectors.toList()));
            }

            @Override
            public void end() {
                visitors.forEach(ClassVisitor::begin);
            }
        };
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
