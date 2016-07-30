package com.iancaffey.bytecode.io.direct.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * TypePathVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface TypePathVisitor extends BytecodeVisitor {
    public void visit(int type, int index);
}
