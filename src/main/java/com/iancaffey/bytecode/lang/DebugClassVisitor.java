package com.iancaffey.bytecode.lang;

import com.iancaffey.bytecode.util.Access;

import java.util.Arrays;

/**
 * DebugClassVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugClassVisitor implements ClassVisitor {
    @Override
    public void begin() {
        System.out.println("Visited begin");
    }

    @Override
    public void visit(int access, int major, int minor, String name, String superName, String[] interfaces) {
        System.out.printf("Class[access=%s, version=%d.%d, name=%s, superName=%s, interfaces=%s]\n",
                Access.of(access).toString().toLowerCase(), major, minor, name, superName, Arrays.toString(interfaces));
    }

    @Override
    public FieldVisitor visitField(int access, String name, String description) {
        System.out.printf("Field[access=%s, name=%s, description=%s]\n", Access.of(access).toString().toLowerCase(), name, description);
        return new DebugFieldVisitor();
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String description) {
        System.out.printf("Field[access=%s, name=%s, description=%s]\n", Access.of(access).toString().toLowerCase(), name, description);
        return new DebugMethodVisitor();
    }

    @Override
    public void end() {
        System.out.println("Visited end");
    }
}
