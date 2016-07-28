package com.iancaffey.bytecode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * AttributeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface AttributeVisitor extends BytecodeVisitor {
    public static AttributeVisitor of(AttributeVisitor... visitors) {
        return AttributeVisitor.of(Arrays.stream(visitors));
    }

    public static AttributeVisitor of(Collection<AttributeVisitor> visitors) {
        return AttributeVisitor.of(visitors.stream());
    }

    public static AttributeVisitor of(Stream<AttributeVisitor> visitors) {
        return new AttributeVisitor() {
            @Override
            public void begin() {
                visitors.forEach(AttributeVisitor::begin);
            }

            @Override
            public void visitConstantValue(int index) {
                visitors.forEach(visitor -> visitor.visitConstantValue(index));
            }

            @Override
            public CodeVisitor visitCode() {
                return CodeVisitor.of(visitors.map(AttributeVisitor::visitCode));
            }

            @Override
            public StackMapTableVisitor visitStackMapTable(int count) {
                return StackMapTableVisitor.of(visitors.map(visitor -> visitor.visitStackMapTable(count)));
            }

            @Override
            public void visitExceptions(int[] exceptionIndexes) {
                visitors.forEach(visitor -> visitor.visitExceptions(exceptionIndexes));
            }

            @Override
            public InnerClassInfoVisitor visitInnerClasses(int count) {
                return InnerClassInfoVisitor.of(visitors.map(visitor -> visitor.visitInnerClasses(count)));
            }

            @Override
            public void visitEnclosingMethod(int classIndex, int methodIndex) {
                visitors.forEach(visitor -> visitor.visitEnclosingMethod(classIndex, methodIndex));
            }

            @Override
            public void visitSynthetic() {
                visitors.forEach(AttributeVisitor::visitSynthetic);
            }

            @Override
            public void visitSignature(int index) {
                visitors.forEach(visitor -> visitor.visitSignature(index));
            }

            @Override
            public void visitSourceFile(int index) {
                visitors.forEach(visitor -> visitor.visitSourceFile(index));
            }

            @Override
            public void visitSourceDebugExtension(byte[] data) {
                visitors.forEach(visitor -> visitor.visitSourceDebugExtension(data));
            }

            @Override
            public LineInfoVisitor visitLineNumberTable(int count) {
                return LineInfoVisitor.of(visitors.map(visitor -> visitor.visitLineNumberTable(count)));
            }

            @Override
            public LocalVariableInfoVisitor visitLocalVariableTable(int count) {
                return LocalVariableInfoVisitor.of(visitors.map(visitor -> visitor.visitLocalVariableTable(count)));
            }

            @Override
            public LocalVariableTypeInfoVisitor visitLocalVariableTypeTable(int count) {
                return LocalVariableTypeInfoVisitor.of(visitors.map(visitor -> visitor.visitLocalVariableTypeTable(count)));
            }

            @Override
            public void visitDeprecated() {
                visitors.forEach(AttributeVisitor::visitDeprecated);
            }

            @Override
            public AttributeVisitor visitRuntimeVisibleAnnotations(int count) {
                return AttributeVisitor.of(visitors.map(visitor -> visitor.visitRuntimeVisibleAnnotations(count)));
            }

            @Override
            public AttributeVisitor visitRuntimeInvisibleAnnotations(int count) {
                return AttributeVisitor.of(visitors.map(visitor -> visitor.visitRuntimeInvisibleAnnotations(count)));
            }

            @Override
            public ParameterVisitor visitRuntimeVisibleParameterAnnotations(int count) {
                return ParameterVisitor.of(visitors.map(visitor -> visitor.visitRuntimeVisibleParameterAnnotations(count)));
            }

            @Override
            public ParameterVisitor visitRuntimeInvisibleParameterAnnotations(int count) {
                return ParameterVisitor.of(visitors.map(visitor -> visitor.visitRuntimeInvisibleParameterAnnotations(count)));
            }

            @Override
            public TypeAnnotationVisitor visitRuntimeVisibleTypeAnnotations(int count) {
                return TypeAnnotationVisitor.of(visitors.map(visitor -> visitor.visitRuntimeVisibleTypeAnnotations(count)));
            }

            @Override
            public TypeAnnotationVisitor visitRuntimeInvisibleTypeAnnotations(int count) {
                return TypeAnnotationVisitor.of(visitors.map(visitor -> visitor.visitRuntimeInvisibleTypeAnnotations(count)));
            }

            @Override
            public ElementValueVisitor visitAnnotationDefault() {
                return ElementValueVisitor.of(visitors.map(AttributeVisitor::visitAnnotationDefault));
            }

            @Override
            public BootstrapMethodVisitor visitBootstrapMethods(int count) {
                return BootstrapMethodVisitor.of(visitors.map(visitor -> visitor.visitBootstrapMethods(count)));
            }

            @Override
            public MethodParameterVisitor visitMethodParameters(int count) {
                return MethodParameterVisitor.of(visitors.map(visitor -> visitor.visitMethodParameters(count)));
            }

            @Override
            public void end() {
                visitors.forEach(AttributeVisitor::end);
            }
        };
    }

    public void visitConstantValue(int index);

    public CodeVisitor visitCode();

    public StackMapTableVisitor visitStackMapTable(int count);

    public void visitExceptions(int[] exceptionIndexes);

    public InnerClassInfoVisitor visitInnerClasses(int count);

    public void visitEnclosingMethod(int classIndex, int methodIndex);

    public void visitSynthetic();

    public void visitSignature(int index);

    public void visitSourceFile(int index);

    public void visitSourceDebugExtension(byte[] data);

    public LineInfoVisitor visitLineNumberTable(int count);

    public LocalVariableInfoVisitor visitLocalVariableTable(int count);

    public LocalVariableTypeInfoVisitor visitLocalVariableTypeTable(int count);

    public void visitDeprecated();

    public AttributeVisitor visitRuntimeVisibleAnnotations(int count);

    public AttributeVisitor visitRuntimeInvisibleAnnotations(int count);

    public ParameterVisitor visitRuntimeVisibleParameterAnnotations(int count);

    public ParameterVisitor visitRuntimeInvisibleParameterAnnotations(int count);

    public TypeAnnotationVisitor visitRuntimeVisibleTypeAnnotations(int count);

    public TypeAnnotationVisitor visitRuntimeInvisibleTypeAnnotations(int count);

    public ElementValueVisitor visitAnnotationDefault();

    public BootstrapMethodVisitor visitBootstrapMethods(int count);

    public MethodParameterVisitor visitMethodParameters(int count);
}
