package com.iancaffey.bytecode.io.info;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * ClassInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ClassInfoVisitor extends BytecodeVisitor {
    public void visit(int major, int minor, int access, String name, String signature, String superName, String[] interfaces);

    public void visitField(int access, String name, String descriptor, String signature, Object initial);

    public void visitMethod(int access, String name, String descriptor, String signature, String[] exceptions);
}
