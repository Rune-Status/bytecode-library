package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.*;

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
        return null;
    }

    @Override
    public void visitExceptions(int[] exceptionIndexes) {

    }

    @Override
    public InnerClassInfoVisitor visitInnerClasses(int count) {
        return null;
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
        return null;
    }

    @Override
    public LocalVariableInfoVisitor visitLocalVariableTable(int count) {
        return null;
    }

    @Override
    public LocalVariableTypeInfoVisitor visitLocalVariableTypeTable(int count) {
        return null;
    }

    @Override
    public void visitDeprecated() {

    }

    @Override
    public AttributeVisitor visitRuntimeVisibleAnnotations(int count) {
        return null;
    }

    @Override
    public AttributeVisitor visitRuntimeInvisibleAnnotations(int count) {
        return null;
    }

    @Override
    public ParameterAnnotationVisitor visitRuntimeVisibleParameterAnnotations(int count) {
        return null;
    }

    @Override
    public ParameterAnnotationVisitor visitRuntimeInvisibleParameterAnnotations(int count) {
        return null;
    }

    @Override
    public TypeAnnotationVisitor visitRuntimeVisibleTypeAnnotations(int count) {
        return null;
    }

    @Override
    public TypeAnnotationVisitor visitRuntimeInvisibleTypeAnnotations(int count) {
        return null;
    }

    @Override
    public ElementValueVisitor visitAnnotationDefault() {
        return null;
    }

    @Override
    public BootstrapMethodVisitor visitBootstrapMethods(int count) {
        return null;
    }

    @Override
    public MethodParameterVisitor visitMethodParameters(int count) {
        return null;
    }
}
