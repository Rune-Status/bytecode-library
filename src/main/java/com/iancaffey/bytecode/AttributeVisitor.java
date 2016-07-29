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
            public InnerClassVisitor visitInnerClasses(int count) {
                return InnerClassVisitor.of(visitors.map(visitor -> visitor.visitInnerClasses(count)));
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
            public LineNumberInfoVisitor visitLineNumberTable(int count) {
                return LineNumberInfoVisitor.of(visitors.map(visitor -> visitor.visitLineNumberTable(count)));
            }

            @Override
            public LocalVariableVisitor visitLocalVariableTable(int count) {
                return LocalVariableVisitor.of(visitors.map(visitor -> visitor.visitLocalVariableTable(count)));
            }

            @Override
            public LocalVariableTypeVisitor visitLocalVariableTypeTable(int count) {
                return LocalVariableTypeVisitor.of(visitors.map(visitor -> visitor.visitLocalVariableTypeTable(count)));
            }

            @Override
            public void visitDeprecated() {
                visitors.forEach(AttributeVisitor::visitDeprecated);
            }

            @Override
            public AnnotationVisitor visitRuntimeVisibleAnnotations(int count) {
                return AnnotationVisitor.of(visitors.map(visitor -> visitor.visitRuntimeVisibleAnnotations(count)));
            }

            @Override
            public AnnotationVisitor visitRuntimeInvisibleAnnotations(int count) {
                return AnnotationVisitor.of(visitors.map(visitor -> visitor.visitRuntimeInvisibleAnnotations(count)));
            }

            @Override
            public ParameterAnnotationVisitor visitRuntimeVisibleParameterAnnotations(int count) {
                return ParameterAnnotationVisitor.of(visitors.map(visitor -> visitor.visitRuntimeVisibleParameterAnnotations(count)));
            }

            @Override
            public ParameterAnnotationVisitor visitRuntimeInvisibleParameterAnnotations(int count) {
                return ParameterAnnotationVisitor.of(visitors.map(visitor -> visitor.visitRuntimeInvisibleParameterAnnotations(count)));
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

    public InnerClassVisitor visitInnerClasses(int count);

    public void visitEnclosingMethod(int classIndex, int methodIndex);

    public void visitSynthetic();

    public void visitSignature(int index);

    public void visitSourceFile(int index);

    public void visitSourceDebugExtension(byte[] data);

    public LineNumberInfoVisitor visitLineNumberTable(int count);

    public LocalVariableVisitor visitLocalVariableTable(int count);

    public LocalVariableTypeVisitor visitLocalVariableTypeTable(int count);

    public void visitDeprecated();

    public AnnotationVisitor visitRuntimeVisibleAnnotations(int count);

    public AnnotationVisitor visitRuntimeInvisibleAnnotations(int count);

    public ParameterAnnotationVisitor visitRuntimeVisibleParameterAnnotations(int count);

    public ParameterAnnotationVisitor visitRuntimeInvisibleParameterAnnotations(int count);

    public TypeAnnotationVisitor visitRuntimeVisibleTypeAnnotations(int count);

    public TypeAnnotationVisitor visitRuntimeInvisibleTypeAnnotations(int count);

    public ElementValueVisitor visitAnnotationDefault();

    public BootstrapMethodVisitor visitBootstrapMethods(int count);

    public MethodParameterVisitor visitMethodParameters(int count);
}
