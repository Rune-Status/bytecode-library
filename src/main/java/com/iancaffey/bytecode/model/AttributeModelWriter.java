package com.iancaffey.bytecode.model;

import com.iancaffey.bytecode.io.BytecodeWriter;
import com.iancaffey.bytecode.model.attribute.*;
import com.iancaffey.bytecode.model.attribute.annotation.TypeAnnotationVisitor;
import com.iancaffey.bytecode.model.attribute.annotation.TypeAnnotationWriter;

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
        writeShort(exceptionIndexes.length);
        for (int index : exceptionIndexes)
            writeShort(index);
    }

    @Override
    public InnerClassVisitor visitInnerClasses(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeShort(count);
        return new InnerClassWriter((ByteArrayOutputStream) out);
    }

    @Override
    public void visitEnclosingMethod(int nameIndex, int length, int classIndex, int methodIndex) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeShort(classIndex);
        writeShort(methodIndex);
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
        writeShort(index);
    }

    @Override
    public void visitSourceFile(int nameIndex, int length, int index) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeShort(index);
    }

    @Override
    public void visitSourceDebugExtension(int nameIndex, int length, byte[] data) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        write(data);
    }

    @Override
    public LineNumberInfoVisitor visitLineNumberTable(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeShort(count);
        return new LineNumberInfoWriter((ByteArrayOutputStream) out);
    }

    @Override
    public LocalVariableVisitor visitLocalVariableTable(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeShort(count);
        return new LocalVariableWriter((ByteArrayOutputStream) out);
    }

    @Override
    public LocalVariableTypeVisitor visitLocalVariableTypeTable(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeShort(count);
        return new LocalVariableTypeWriter((ByteArrayOutputStream) out);
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
        writeShort(count);
        return new AnnotationWriter((ByteArrayOutputStream) out);
    }

    @Override
    public AnnotationVisitor visitRuntimeInvisibleAnnotations(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeShort(count);
        return new AnnotationWriter((ByteArrayOutputStream) out);
    }

    @Override
    public ParameterAnnotationVisitor visitRuntimeVisibleParameterAnnotations(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeByte(count);
        return new ParameterAnnotationWriter((ByteArrayOutputStream) out);
    }

    @Override
    public ParameterAnnotationVisitor visitRuntimeInvisibleParameterAnnotations(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeByte(count);
        return new ParameterAnnotationWriter((ByteArrayOutputStream) out);
    }

    @Override
    public TypeAnnotationVisitor visitRuntimeVisibleTypeAnnotations(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeShort(count);
        return new TypeAnnotationWriter((ByteArrayOutputStream) out);
    }

    @Override
    public TypeAnnotationVisitor visitRuntimeInvisibleTypeAnnotations(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeShort(count);
        return new TypeAnnotationWriter((ByteArrayOutputStream) out);
    }

    @Override
    public ElementValueVisitor visitAnnotationDefault(int nameIndex, int length) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        return new ElementValueWriter((ByteArrayOutputStream) out);
    }

    @Override
    public BootstrapMethodVisitor visitBootstrapMethods(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeShort(count);
        return new BootstrapMethodWriter((ByteArrayOutputStream) out);
    }

    @Override
    public MethodParameterVisitor visitMethodParameters(int nameIndex, int length, int count) throws IOException {
        writeShort(nameIndex);
        writeInt(length);
        writeByte(count);
        return new MethodParameterWriter((ByteArrayOutputStream) out);
    }
}
