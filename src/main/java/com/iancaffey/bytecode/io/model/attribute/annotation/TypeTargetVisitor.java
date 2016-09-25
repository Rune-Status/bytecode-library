package com.iancaffey.bytecode.io.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeVisitor;
import com.iancaffey.bytecode.io.model.attribute.LocalVariableTargetVisitor;

import java.io.IOException;

/**
 * TypeTargetVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface TypeTargetVisitor extends BytecodeVisitor {
    public void visitTypeParameter(int index) throws IOException;

    public void visitSuperType(int index) throws IOException;

    public void visitTypeParameterBound(int parameterIndex, int boundIndex) throws IOException;

    public void visitEmpty() throws IOException;

    public void visitFormalParameter(int index) throws IOException;

    public void visitThrows(int index) throws IOException;

    public LocalVariableTargetVisitor visitLocalVariable(int count) throws IOException;

    public void visitCatch(int index) throws IOException;

    public void visitOffset(int index) throws IOException;

    public void visitTypeArgument(int offset, int index) throws IOException;
}
