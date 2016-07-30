package com.iancaffey.bytecode.io.direct;

import com.iancaffey.bytecode.io.BytecodeVisitor;
import com.iancaffey.bytecode.io.direct.attribute.*;
import com.iancaffey.bytecode.io.direct.attribute.annotation.TypeAnnotationVisitor;

/**
 * AttributeModelVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface AttributeModelVisitor extends BytecodeVisitor {
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
