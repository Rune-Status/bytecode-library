package com.iancaffey.bytecode.io.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeWriter;
import com.iancaffey.bytecode.io.model.attribute.LocalVariableTargetVisitor;

import java.io.IOException;

/**
 * TypeTargetWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class TypeTargetWriter extends BytecodeWriter implements TypeTargetVisitor {
    @Override
    public void visitTypeParameter(int index) throws IOException {

    }

    @Override
    public void visitSuperType(int index) throws IOException {

    }

    @Override
    public void visitTypeParameterBound(int parameterIndex, int boundIndex) throws IOException {

    }

    @Override
    public void visitEmpty() throws IOException {

    }

    @Override
    public void visitFormalParameter(int index) throws IOException {

    }

    @Override
    public void visitThrows(int index) throws IOException {

    }

    @Override
    public LocalVariableTargetVisitor visitLocalVariable(int count) throws IOException {
        return null;
    }

    @Override
    public void visitCatch(int index) throws IOException {

    }

    @Override
    public void visitOffset(int index) throws IOException {

    }

    @Override
    public void visitTypeArgument(int offset, int index) throws IOException {

    }
}
