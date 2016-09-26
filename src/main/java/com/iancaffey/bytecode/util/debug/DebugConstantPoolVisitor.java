package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.model.ConstantPoolVisitor;

/**
 * DebugConstantPoolVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugConstantPoolVisitor extends DebugVisitor implements ConstantPoolVisitor {
    private int index = 1;

    public DebugConstantPoolVisitor() {
    }

    public DebugConstantPoolVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visitClass(int nameIndex) {
        log(String.format("%-25s[index=%d, nameIndex=%d]", "ClassInfo", index++, nameIndex), 1);
    }

    @Override
    public void visitDouble(double value) {
        log(String.format("%-25s[index=%d, value=%f]", "DoubleInfo", index, value), 1);
        index += 2;
    }

    @Override
    public void visitFieldReference(int nameIndex, int descriptorIndex) {
        log(String.format("%-25s[index=%d, nameIndex=%d, descriptorIndex=%d]", "FieldReferenceInfo", index++, nameIndex, descriptorIndex), 1);
    }

    @Override
    public void visitFloat(float value) {
        log(String.format("%-25s[index=%d, value=%f]", "FloatInfo", index++, value), 1);
    }

    @Override
    public void visitInteger(int value) {
        log(String.format("%-25s[index=%d, value=%d]", "IntegerInfo", index++, value), 1);
    }

    @Override
    public void visitInterfaceMethodReference(int nameIndex, int descriptorIndex) {
        log(String.format("%-25s[index=%d, nameIndex=%d, descriptorIndex=%d]", "InterfaceMethodReferenceInfo", index++, nameIndex, descriptorIndex), 1);
    }

    @Override
    public void visitInvokeDynamic(int methodIndex, int descriptorIndex) {
        log(String.format("%-25s[index=%d, methodIndex=%d, descriptorIndex=%s]", "InvokeDynamicInfo", index++, methodIndex, descriptorIndex), 1);
    }

    @Override
    public void visitLong(long value) {
        log(String.format("%-25s[index=%d, value=%d]", "LongInfo", index, value), 1);
        index += 2;
    }

    @Override
    public void visitMethodHandle(int type, int referenceIndex) {
        log(String.format("%-25s[index=%d, type=%d, referenceIndex=%s]", "MethodHandleInfo", index++, type, referenceIndex), 1);
    }

    @Override
    public void visitMethodReference(int nameIndex, int descriptorIndex) {
        log(String.format("%-25s[index=%d, nameIndex=%s, descriptorIndex=%d]", "MethodReferenceInfo", index++, nameIndex, descriptorIndex), 1);
    }

    @Override
    public void visitMethodType(int descriptorIndex) {
        log(String.format("%-25s[index=%d, descriptorIndex=%s]", "MethodTypeInfo", index++, descriptorIndex), 1);
    }

    @Override
    public void visitNameType(int nameIndex, int descriptorIndex) {
        log(String.format("%-25s[index=%d, nameIndex=%d, descriptorIndex=%d]", "NameTypeInfo", index++, nameIndex, descriptorIndex), 1);
    }

    @Override
    public void visitString(int valueIndex) {
        log(String.format("%-25s[index=%d, valueIndex=%d]", "StringInfo", index++, valueIndex), 1);
    }

    @Override
    public void visitUTF8(String value) {
        log(String.format("%-25s[index=%d, value=%s]", "UTF8Info", index++, value), 1);
    }
}