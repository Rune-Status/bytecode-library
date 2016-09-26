package com.iancaffey.bytecode.model;

import com.iancaffey.bytecode.io.BytecodeVisitor;
import com.iancaffey.bytecode.model.attribute.*;
import com.iancaffey.bytecode.model.attribute.annotation.TypeAnnotationVisitor;

import java.io.IOException;

/**
 * AttributeModelVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface AttributeModelVisitor extends BytecodeVisitor {
    public void visitConstantValue(int nameIndex, int length, int index) throws IOException;

    public CodeVisitor visitCode(int nameIndex, int length) throws IOException;

    public StackMapTableVisitor visitStackMapTable(int nameIndex, int length, int count) throws IOException;

    public void visitExceptions(int nameIndex, int length, int[] exceptionIndexes) throws IOException;

    public InnerClassVisitor visitInnerClasses(int nameIndex, int length, int count) throws IOException;

    public void visitEnclosingMethod(int nameIndex, int length, int classIndex, int methodIndex) throws IOException;

    public void visitSynthetic(int nameIndex, int length) throws IOException;

    public void visitSignature(int nameIndex, int length, int index) throws IOException;

    public void visitSourceFile(int nameIndex, int length, int index) throws IOException;

    public void visitSourceDebugExtension(int nameIndex, int length, byte[] data) throws IOException;

    public LineNumberInfoVisitor visitLineNumberTable(int nameIndex, int length, int count) throws IOException;

    public LocalVariableVisitor visitLocalVariableTable(int nameIndex, int length, int count) throws IOException;

    public LocalVariableTypeVisitor visitLocalVariableTypeTable(int nameIndex, int length, int count) throws IOException;

    public void visitDeprecated(int nameIndex, int length) throws IOException;

    public AnnotationVisitor visitRuntimeVisibleAnnotations(int nameIndex, int length, int count) throws IOException;

    public AnnotationVisitor visitRuntimeInvisibleAnnotations(int nameIndex, int length, int count) throws IOException;

    public ParameterAnnotationVisitor visitRuntimeVisibleParameterAnnotations(int nameIndex, int length, int count) throws IOException;

    public ParameterAnnotationVisitor visitRuntimeInvisibleParameterAnnotations(int nameIndex, int length, int count) throws IOException;

    public TypeAnnotationVisitor visitRuntimeVisibleTypeAnnotations(int nameIndex, int length, int count) throws IOException;

    public TypeAnnotationVisitor visitRuntimeInvisibleTypeAnnotations(int nameIndex, int length, int count) throws IOException;

    public ElementValueVisitor visitAnnotationDefault(int nameIndex, int length) throws IOException;

    public BootstrapMethodVisitor visitBootstrapMethods(int nameIndex, int length, int count) throws IOException;

    public MethodParameterVisitor visitMethodParameters(int nameIndex, int length, int count) throws IOException;
}
