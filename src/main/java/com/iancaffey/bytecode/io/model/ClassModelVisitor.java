package com.iancaffey.bytecode.io.model;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * ClassModelVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ClassModelVisitor extends BytecodeVisitor {
    public ConstantPoolVisitor visitConstantPool(int count) throws IOException;

    public void visitVersion(int major, int minor) throws IOException;

    public void visitDescription(int access, int nameIndex, int parentNameIndex, int[] interfaceIndexes) throws IOException;

    public FieldModelVisitor visitFields(int count) throws IOException;

    public MethodModelVisitor visitMethods(int count) throws IOException;

    public AttributeModelVisitor visitAttributes(int count) throws IOException;
}
