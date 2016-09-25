package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.model.AttributeModelVisitor;
import com.iancaffey.bytecode.io.model.attribute.*;
import com.iancaffey.bytecode.io.model.attribute.annotation.TypeAnnotationVisitor;

import java.util.Arrays;

/**
 * DebugAttributeModelVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugAttributeModelVisitor extends DebugVisitor implements AttributeModelVisitor {
    private int index;

    public DebugAttributeModelVisitor() {
    }

    public DebugAttributeModelVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visitConstantValue(int nameIndex, int length, int valueIndex) {
        log(String.format("ConstantValue [index=%d, valueIndex=%d]", index++, valueIndex), 1);
    }

    @Override
    public CodeVisitor visitCode(int nameIndex, int length) {
        log(String.format("Code [index=%d]", index++), 1);
        return new DebugCodeVisitor(indent() + 1);
    }

    @Override
    public StackMapTableVisitor visitStackMapTable(int nameIndex, int length, int count) {
        log(String.format("StackMapTable [index=%d, count=%d]", index++, count), 1);
        return new DebugStackMapTableVisitor(indent() + 1);
    }

    @Override
    public void visitExceptions(int nameIndex, int length, int[] exceptionIndexes) {
        log(String.format("Exceptions [index=%d, indexes=%s]", index++, Arrays.toString(exceptionIndexes)), 1);
    }

    @Override
    public InnerClassVisitor visitInnerClasses(int nameIndex, int length, int count) {
        log(String.format("InnerClasses [index=%d, count=%d]", index++, count), 1);
        return new DebugInnerClassVisitor(indent() + 1);
    }

    @Override
    public void visitEnclosingMethod(int nameIndex, int length, int classIndex, int methodIndex) {
        log(String.format("EnclosingMethod [index=%d, classIndex=%d, methodIndex=%s]", index++, classIndex, methodIndex), 1);
    }

    @Override
    public void visitSynthetic(int nameIndex, int length) {
        log(String.format("Synthetic [index=%d]", index++), 1);
    }

    @Override
    public void visitSignature(int nameIndex, int length, int index) {
        log(String.format("Signature [index=%d, index=%d]", this.index++, index), 1);
    }

    @Override
    public void visitSourceFile(int nameIndex, int length, int index) {
        log(String.format("SourceFile [index=%d, index=%d]", this.index++, index), 1);
    }

    @Override
    public void visitSourceDebugExtension(int nameIndex, int length, byte[] data) {
        log(String.format("SourceDebugExtension [index=%d, data=%d]", index++, data.length), 1);
    }

    @Override
    public LineNumberInfoVisitor visitLineNumberTable(int nameIndex, int length, int count) {
        log(String.format("LineNumberTable [index=%d, count=%d]", index++, count), 1);
        return new DebugLineNumberInfoVisitor(indent() + 1);
    }

    @Override
    public LocalVariableVisitor visitLocalVariableTable(int nameIndex, int length, int count) {
        log(String.format("LocalVariableTabke [index=%d, count=%d]", index++, count), 1);
        return new DebugLocalVariableVisitor(indent() + 1);
    }

    @Override
    public LocalVariableTypeVisitor visitLocalVariableTypeTable(int nameIndex, int length, int count) {
        log(String.format("LocalVariableTypeTable [index=%d, count=%d]", index++, count), 1);
        return new DebugLocalVariableTypeVisitor(indent() + 1);
    }

    @Override
    public void visitDeprecated(int nameIndex, int length) {
        log(String.format("Deprecated [index=%d]", index++), 1);
    }

    @Override
    public AnnotationVisitor visitRuntimeVisibleAnnotations(int nameIndex, int length, int count) {
        log(String.format("RuntimeVisibleAnnotations [index=%d, count=%d]", index++, count), 1);
        return new DebugAnnotationVisitor(indent() + 1);
    }

    @Override
    public AnnotationVisitor visitRuntimeInvisibleAnnotations(int nameIndex, int length, int count) {
        log(String.format("RuntimeInvisibleAnnotations [index=%d, count=%d]", index++, count), 1);
        return new DebugAnnotationVisitor(indent() + 1);
    }

    @Override
    public ParameterAnnotationVisitor visitRuntimeVisibleParameterAnnotations(int nameIndex, int length, int count) {
        log(String.format("RuntimeVisibleParameterAnnotations [index=%d, count=%d]", index++, count), 1);
        return new DebugParameterAnnotationVisitor(indent() + 1);
    }

    @Override
    public ParameterAnnotationVisitor visitRuntimeInvisibleParameterAnnotations(int nameIndex, int length, int count) {
        log(String.format("RuntimeInvisibleParameterAnnotations [index=%d, count=%d]", index++, count), 1);
        return new DebugParameterAnnotationVisitor(indent() + 1);
    }

    @Override
    public TypeAnnotationVisitor visitRuntimeVisibleTypeAnnotations(int nameIndex, int length, int count) {
        log(String.format("RuntimeVisibleTypeAnnotations [index=%d, count=%d]", index++, count), 1);
        return new DebugTypeAnnotationVisitor(indent() + 1);
    }

    @Override
    public TypeAnnotationVisitor visitRuntimeInvisibleTypeAnnotations(int nameIndex, int length, int count) {
        log(String.format("RuntimeInvisibleTypeAnnotations [index=%d, count=%d]", index++, count), 1);
        return new DebugTypeAnnotationVisitor(indent() + 1);
    }

    @Override
    public ElementValueVisitor visitAnnotationDefault(int nameIndex, int length) {
        log(String.format("AnnotationDefault [index=%d]", index++), 1);
        return new DebugElementValueVisitor(indent() + 1);
    }

    @Override
    public BootstrapMethodVisitor visitBootstrapMethods(int nameIndex, int length, int count) {
        log(String.format("BootstrapMethods [index=%d, count=%d]", index++, count), 1);
        return new DebugBootstrapMethodVisitor(indent() + 1);
    }

    @Override
    public MethodParameterVisitor visitMethodParameters(int nameIndex, int length, int count) {
        log(String.format("MethodParameters [index=%d, count=%d]", index++, count), 1);
        return new DebugMethodParameterVisitor(indent() + 1);
    }
}
