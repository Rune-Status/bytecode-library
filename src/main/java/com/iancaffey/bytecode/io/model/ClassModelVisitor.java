package com.iancaffey.bytecode.io.model;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * ClassModelVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ClassModelVisitor extends BytecodeVisitor {
    public ConstantPoolVisitor visitConstantPool(int count);

    public void visit(int major, int minor, int access, int nameIndex, int parentNameIndex, int[] interfaceIndexes);

    public FieldModelVisitor visitFields(int count);

    public MethodModelVisitor visitMethods(int count);

    public AttributeModelVisitor visitAttributes(int count);
}
