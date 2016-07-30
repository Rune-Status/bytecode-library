package com.iancaffey.bytecode.io.direct.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeVisitor;
import com.iancaffey.bytecode.io.direct.attribute.LocalVariableTargetVisitor;

/**
 * TypeTargetVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface TypeTargetVisitor extends BytecodeVisitor {
    public void visitTypeParameter(int index);

    public void visitSuperType(int index);

    public void visitTypeParameterBound(int parameterIndex, int boundIndex);

    public void visitEmpty();

    public void visitFormalParameter(int index);

    public void visitThrows(int index);

    public LocalVariableTargetVisitor visitLocalVariable(int count);

    public void visitCatch(int index);

    public void visitOffset(int index);

    public void visitTypeArgument(int offset, int index);
}
