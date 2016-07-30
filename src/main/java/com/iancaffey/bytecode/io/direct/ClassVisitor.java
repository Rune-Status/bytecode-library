package com.iancaffey.bytecode.io.direct;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * ClassVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface ClassVisitor extends BytecodeVisitor {
    public ConstantPoolVisitor visitConstantPool(int count);

    public void visit(int major, int minor, int access, int nameIndex, int parentNameIndex, int[] interfaceIndexes);

    public FieldVisitor visitFields(int count);

    public MethodVisitor visitMethods(int count);

    public AttributeVisitor visitAttributes(int count);
}
