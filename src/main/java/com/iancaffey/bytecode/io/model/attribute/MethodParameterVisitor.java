package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * MethodParameterVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface MethodParameterVisitor extends BytecodeVisitor {
    public void visit(int nameIndex, int access);
}
