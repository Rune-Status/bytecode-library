package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * MethodParameterVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface MethodParameterVisitor extends BytecodeVisitor {
    void visit(int nameIndex, int access) throws IOException;
}
