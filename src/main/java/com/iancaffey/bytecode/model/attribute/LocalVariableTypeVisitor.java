package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * LocalVariableTypeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface LocalVariableTypeVisitor extends BytecodeVisitor {
    public void visit(int startIndex, int length, int nameIndex, int signatureIndex, int index) throws IOException;
}
