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
    void visitConstantValue(int nameIndex, int length, int index) throws IOException;

    CodeVisitor visitCode(int nameIndex, int length) throws IOException;

    StackMapTableVisitor visitStackMapTable(int nameIndex, int length, int count) throws IOException;

    void visitExceptions(int nameIndex, int length, int[] exceptionIndexes) throws IOException;

    InnerClassVisitor visitInnerClasses(int nameIndex, int length, int count) throws IOException;

    void visitEnclosingMethod(int nameIndex, int length, int classIndex, int methodIndex) throws IOException;

    void visitSynthetic(int nameIndex, int length) throws IOException;

    void visitSignature(int nameIndex, int length, int index) throws IOException;

    void visitSourceFile(int nameIndex, int length, int index) throws IOException;

    void visitSourceDebugExtension(int nameIndex, int length, byte[] data) throws IOException;

    LineNumberInfoVisitor visitLineNumberTable(int nameIndex, int length, int count) throws IOException;

    LocalVariableVisitor visitLocalVariableTable(int nameIndex, int length, int count) throws IOException;

    LocalVariableTypeVisitor visitLocalVariableTypeTable(int nameIndex, int length, int count) throws IOException;

    void visitDeprecated(int nameIndex, int length) throws IOException;

    AnnotationVisitor visitRuntimeVisibleAnnotations(int nameIndex, int length, int count) throws IOException;

    AnnotationVisitor visitRuntimeInvisibleAnnotations(int nameIndex, int length, int count) throws IOException;

    ParameterAnnotationVisitor visitRuntimeVisibleParameterAnnotations(int nameIndex, int length, int count) throws IOException;

    ParameterAnnotationVisitor visitRuntimeInvisibleParameterAnnotations(int nameIndex, int length, int count) throws IOException;

    TypeAnnotationVisitor visitRuntimeVisibleTypeAnnotations(int nameIndex, int length, int count) throws IOException;

    TypeAnnotationVisitor visitRuntimeInvisibleTypeAnnotations(int nameIndex, int length, int count) throws IOException;

    ElementValueVisitor visitAnnotationDefault(int nameIndex, int length) throws IOException;

    BootstrapMethodVisitor visitBootstrapMethods(int nameIndex, int length, int count) throws IOException;

    MethodParameterVisitor visitMethodParameters(int nameIndex, int length, int count) throws IOException;
}
