package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.model.attribute.LocalVariableTargetVisitor;
import com.iancaffey.bytecode.model.attribute.annotation.TypeTargetVisitor;

/**
 * DebugTypeTargetVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugTypeTargetVisitor extends DebugVisitor implements TypeTargetVisitor {
    public DebugTypeTargetVisitor() {
    }

    public DebugTypeTargetVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visitTypeParameter(int index) {
        log(String.format("TypeParameter [index=%d]", index), 1);
    }

    @Override
    public void visitSuperType(int index) {
        log(String.format("SuperType [index=%d]", index), 1);
    }

    @Override
    public void visitTypeParameterBound(int parameterIndex, int boundIndex) {
        log(String.format("TypeParameterBound [parameterIndex=%d, boundIndex=%d]", parameterIndex, boundIndex), 1);
    }

    @Override
    public void visitEmpty() {
        log("Empty", 1);
    }

    @Override
    public void visitFormalParameter(int index) {
        log(String.format("FormalParameter [index=%d]", index), 1);
    }

    @Override
    public void visitThrows(int index) {
        log(String.format("Throws [index=%d]", index), 1);
    }

    @Override
    public LocalVariableTargetVisitor visitLocalVariable(int count) {
        log(String.format("LocalVariable [count=%d]", count), 1);
        return new DebugLocalVariableTargetVisitor(indent() + 1);
    }

    @Override
    public void visitCatch(int index) {
        log(String.format("Catch [index=%d]", index), 1);
    }

    @Override
    public void visitOffset(int index) {
        log(String.format("Offset [index=%d]", index), 1);
    }

    @Override
    public void visitTypeArgument(int offset, int index) {
        log(String.format("TypeArgument [offset=%d, index=%d]", offset, index), 1);
    }
}
