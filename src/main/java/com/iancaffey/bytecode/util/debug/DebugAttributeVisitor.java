package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.attribute.*;
import com.iancaffey.bytecode.io.attribute.annotation.TypeAnnotationVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugAttributeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugAttributeVisitor extends DebugVisitor implements AttributeVisitor {
    private int index;

    public DebugAttributeVisitor(int indent) {
        super("Attributes", indent);
    }

    public DebugAttributeVisitor() {
        super("Attributes");
    }

    @Override
    public void begin() {
        super.begin();
        index = 0;
    }

    @Override
    public void visitConstantValue(int valueIndex) {
        log(String.format("ConstantValue [index=%d, valueIndex=%d]", index++, valueIndex), 1);
    }

    @Override
    public CodeVisitor visitCode() {
        log(String.format("Code [index=%d]", index++), 1);
        return new DebugCodeVisitor(indent() + 1);
    }

    @Override
    public StackMapTableVisitor visitStackMapTable(int count) {
        return new DebugStackMapTableVisitor(indent() + 1);
    }

    @Override
    public void visitExceptions(int[] exceptionIndexes) {

    }

    @Override
    public InnerClassVisitor visitInnerClasses(int count) {
        return new DebugInnerClassVisitor(indent() + 1);
    }

    @Override
    public void visitEnclosingMethod(int classIndex, int methodIndex) {

    }

    @Override
    public void visitSynthetic() {

    }

    @Override
    public void visitSignature(int index) {

    }

    @Override
    public void visitSourceFile(int index) {

    }

    @Override
    public void visitSourceDebugExtension(byte[] data) {

    }

    @Override
    public LineNumberInfoVisitor visitLineNumberTable(int count) {
        return new DebugLineNumberInfoVisitor(indent() + 1);
    }

    @Override
    public LocalVariableVisitor visitLocalVariableTable(int count) {
        return new DebugLocalVariableVisitor(indent() + 1);
    }

    @Override
    public LocalVariableTypeVisitor visitLocalVariableTypeTable(int count) {
        return new DebugLocalVariableTypeVisitor(indent() + 1);
    }

    @Override
    public void visitDeprecated() {

    }

    @Override
    public AnnotationVisitor visitRuntimeVisibleAnnotations(int count) {
        return new DebugAnnotationVisitor(indent() + 1);
    }

    @Override
    public AnnotationVisitor visitRuntimeInvisibleAnnotations(int count) {
        return new DebugAnnotationVisitor(indent() + 1);
    }

    @Override
    public ParameterAnnotationVisitor visitRuntimeVisibleParameterAnnotations(int count) {
        return new DebugParameterAnnotationVisitor(indent() + 1);
    }

    @Override
    public ParameterAnnotationVisitor visitRuntimeInvisibleParameterAnnotations(int count) {
        return new DebugParameterAnnotationVisitor(indent() + 1);
    }

    @Override
    public TypeAnnotationVisitor visitRuntimeVisibleTypeAnnotations(int count) {
        return new DebugTypeAnnotationVisitor(indent() + 1);
    }

    @Override
    public TypeAnnotationVisitor visitRuntimeInvisibleTypeAnnotations(int count) {
        return new DebugTypeAnnotationVisitor(indent() + 1);
    }

    @Override
    public ElementValueVisitor visitAnnotationDefault() {
        return new DebugElementValueVisitor(indent() + 1);
    }

    @Override
    public BootstrapMethodVisitor visitBootstrapMethods(int count) {
        return new DebugBootstrapMethodVisitor(indent() + 1);
    }

    @Override
    public MethodParameterVisitor visitMethodParameters(int count) {
        return new DebugMethodParameterVisitor(indent() + 1);
    }
}
