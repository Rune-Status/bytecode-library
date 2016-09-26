package com.iancaffey.bytecode.model;

import com.iancaffey.bytecode.ClassInfo;
import com.iancaffey.bytecode.io.BytecodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * ClassModelWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassModelWriter extends BytecodeWriter implements ClassModelVisitor {
    public ClassModelWriter() {
    }

    public ClassModelWriter(ByteArrayOutputStream out) {
        super(out);
    }

    @Override
    public ConstantPoolVisitor visitConstantPool(int count) throws IOException {
        writeShort(count);
        return new ConstantPoolWriter((ByteArrayOutputStream) out);
    }

    @Override
    public void visitVersion(int major, int minor) throws IOException {
        writeInt(ClassInfo.MAGIC);
        writeShort(minor);
        writeShort(major);
    }

    @Override
    public void visitDescription(int access, int nameIndex, int parentNameIndex, int[] interfaceIndexes) throws IOException {
        writeShort(access);
        writeShort(nameIndex);
        writeShort(parentNameIndex);
        writeShort(interfaceIndexes.length);
        for (int index : interfaceIndexes)
            writeShort(index);
    }

    @Override
    public FieldModelVisitor visitFields(int count) throws IOException {
        writeShort(count);
        return new FieldModelWriter((ByteArrayOutputStream) out);
    }

    @Override
    public MethodModelVisitor visitMethods(int count) throws IOException {
        writeShort(count);
        return new MethodModelWriter((ByteArrayOutputStream) out);
    }

    @Override
    public AttributeModelVisitor visitAttributes(int count) throws IOException {
        writeShort(count);
        return new AttributeModelWriter((ByteArrayOutputStream) out);
    }
}
