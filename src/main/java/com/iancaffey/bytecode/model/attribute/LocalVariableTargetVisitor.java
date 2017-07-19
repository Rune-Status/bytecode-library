package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * LocalVariableTargetVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface LocalVariableTargetVisitor extends BytecodeVisitor {
    void visit(int startIndex, int length, int index) throws IOException;
}
