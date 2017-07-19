package com.iancaffey.bytecode.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeVisitor;
import com.iancaffey.bytecode.model.attribute.LocalVariableTargetVisitor;

import java.io.IOException;

/**
 * TypeTargetVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface TypeTargetVisitor extends BytecodeVisitor {
    void visitTypeParameter(int index) throws IOException;

    void visitSuperType(int index) throws IOException;

    void visitTypeParameterBound(int parameterIndex, int boundIndex) throws IOException;

    void visitEmpty() throws IOException;

    void visitFormalParameter(int index) throws IOException;

    void visitThrows(int index) throws IOException;

    LocalVariableTargetVisitor visitLocalVariable(int count) throws IOException;

    void visitCatch(int index) throws IOException;

    void visitOffset(int index) throws IOException;

    void visitTypeArgument(int offset, int index) throws IOException;
}
