package com.iancaffey.bytecode.model;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * ClassModelVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ClassModelVisitor extends BytecodeVisitor {
    ConstantPoolVisitor visitConstantPool(int count) throws IOException;

    void visitVersion(int major, int minor) throws IOException;

    void visitDescription(int access, int nameIndex, int parentNameIndex, int[] interfaceIndexes) throws IOException;

    FieldModelVisitor visitFields(int count) throws IOException;

    MethodModelVisitor visitMethods(int count) throws IOException;

    AttributeModelVisitor visitAttributes(int count) throws IOException;
}
