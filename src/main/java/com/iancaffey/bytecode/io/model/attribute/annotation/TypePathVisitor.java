package com.iancaffey.bytecode.io.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * TypePathVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface TypePathVisitor extends BytecodeVisitor {
    public void visit(int type, int index) throws IOException;
}
