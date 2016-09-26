package com.iancaffey.bytecode.io.model;

import com.iancaffey.bytecode.io.BytecodeWriter;
import com.iancaffey.bytecode.io.model.attribute.*;
import com.iancaffey.bytecode.io.model.attribute.annotation.TypeAnnotationVisitor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * AttributeModelWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AttributeModelWriter extends BytecodeWriter implements AttributeModelVisitor {
    public AttributeModelWriter() {
    }

    public AttributeModelWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public void visitConstantValue(int nameIndex, int length, int index) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeShort(index);
    }

    @Override
    public CodeVisitor visitCode(int nameIndex, int length) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return new CodeWriter((ByteArrayOutputStream) out);
    }

    @Override
    public StackMapTableVisitor visitStackMapTable(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeShort(count);
        return new StackMapTableWriter((ByteArrayOutputStream) out);
    }

    @Override
    public void visitExceptions(int nameIndex, int length, int[] exceptionIndexes) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
    }

    @Override
    public InnerClassVisitor visitInnerClasses(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return null;
    }

    @Override
    public void visitEnclosingMethod(int nameIndex, int length, int classIndex, int methodIndex) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
    }

    @Override
    public void visitSynthetic(int nameIndex, int length) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
    }

    @Override
    public void visitSignature(int nameIndex, int length, int index) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
    }

    @Override
    public void visitSourceFile(int nameIndex, int length, int index) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
    }

    @Override
    public void visitSourceDebugExtension(int nameIndex, int length, byte[] data) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
    }

    @Override
    public LineNumberInfoVisitor visitLineNumberTable(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return null;
    }

    @Override
    public LocalVariableVisitor visitLocalVariableTable(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return null;
    }

    @Override
    public LocalVariableTypeVisitor visitLocalVariableTypeTable(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return null;
    }

    @Override
    public void visitDeprecated(int nameIndex, int length) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
    }

    @Override
    public AnnotationVisitor visitRuntimeVisibleAnnotations(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return null;
    }

    @Override
    public AnnotationVisitor visitRuntimeInvisibleAnnotations(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return null;
    }

    @Override
    public ParameterAnnotationVisitor visitRuntimeVisibleParameterAnnotations(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return null;
    }

    @Override
    public ParameterAnnotationVisitor visitRuntimeInvisibleParameterAnnotations(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return null;
    }

    @Override
    public TypeAnnotationVisitor visitRuntimeVisibleTypeAnnotations(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return null;
    }

    @Override
    public TypeAnnotationVisitor visitRuntimeInvisibleTypeAnnotations(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return null;
    }

    @Override
    public ElementValueVisitor visitAnnotationDefault(int nameIndex, int length) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return null;
    }

    @Override
    public BootstrapMethodVisitor visitBootstrapMethods(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return null;
    }

    @Override
    public MethodParameterVisitor visitMethodParameters(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return null;
    }
}
