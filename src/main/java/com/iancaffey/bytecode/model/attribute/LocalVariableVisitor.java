package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * LocalVariableVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface LocalVariableVisitor extends BytecodeVisitor {
    void visit(int startIndex, int length, int nameIndex, int descriptorIndex, int index) throws IOException;
}
