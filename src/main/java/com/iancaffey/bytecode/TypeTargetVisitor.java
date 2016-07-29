package com.iancaffey.bytecode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * TypeTargetVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface TypeTargetVisitor extends BytecodeVisitor {
    public static TypeTargetVisitor of(TypeTargetVisitor... visitors) {
        return TypeTargetVisitor.of(Arrays.stream(visitors));
    }

    public static TypeTargetVisitor of(Collection<TypeTargetVisitor> visitors) {
        return TypeTargetVisitor.of(visitors.stream());
    }

    public static TypeTargetVisitor of(Stream<TypeTargetVisitor> visitors) {
        return new TypeTargetVisitor() {
            @Override
            public void begin() {
                visitors.forEach(TypeTargetVisitor::begin);
            }

            @Override
            public void visitTypeParameter(int index) {
                visitors.forEach(visitor -> visitor.visitTypeParameter(index));
            }

            @Override
            public void visitSuperType(int index) {
                visitors.forEach(visitor -> visitor.visitSuperType(index));
            }

            @Override
            public void visitTypeParameterBound(int parameterIndex, int boundIndex) {
                visitors.forEach(visitor -> visitor.visitTypeParameterBound(parameterIndex, boundIndex));
            }

            @Override
            public void visitEmpty() {
                visitors.forEach(TypeTargetVisitor::visitEmpty);
            }

            @Override
            public void visitFormalParameter(int index) {
                visitors.forEach(visitor -> visitor.visitFormalParameter(index));
            }

            @Override
            public void visitThrows(int index) {
                visitors.forEach(visitor -> visitor.visitThrows(index));
            }

            @Override
            public LocalVariableTargetVisitor visitLocalVariable(int count) {
                return LocalVariableTargetVisitor.of(visitors.map(visitor -> visitor.visitLocalVariable(count)));
            }

            @Override
            public void visitCatch(int index) {
                visitors.forEach(visitor -> visitor.visitCatch(index));
            }

            @Override
            public void visitOffset(int index) {
                visitors.forEach(visitor -> visitor.visitOffset(index));
            }

            @Override
            public void visitTypeArgument(int offset, int index) {
                visitors.forEach(visitor -> visitor.visitTypeArgument(offset, index));
            }

            @Override
            public void end() {
                visitors.forEach(TypeTargetVisitor::end);
            }
        };
    }

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
