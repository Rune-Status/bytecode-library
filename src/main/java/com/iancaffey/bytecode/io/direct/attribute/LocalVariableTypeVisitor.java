package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * LocalVariableTypeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface LocalVariableTypeVisitor extends BytecodeVisitor {
    public void visit(int startIndex, int length, int nameIndex, int signatureIndex, int index);
}
