package com.iancaffey.bytecode.lang;

/**
 * DebugConstantPoolInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugConstantPoolInfoVisitor implements ConstantPoolInfoVisitor {
    private int index;

    @Override
    public void begin() {
        System.out.println("ConstantPool [BEGIN]");
        index = 1;
    }

    @Override
    public void visitClass(int nameIndex) {
        System.out.printf("%-25s[index=%d, nameIndex=%d]\n", "ClassInfo", index++, nameIndex);
    }

    @Override
    public void visitDouble(double value) {
        System.out.printf("%-25s[index=%d, value=%f]\n", "DoubleInfo", index, value);
        index += 2;
    }

    @Override
    public void visitFieldReference(int nameIndex, int descriptorIndex) {
        System.out.printf("%-25s[index=%d, nameIndex=%d, descriptorIndex=%d]\n", "FieldReferenceInfo", index++, nameIndex, descriptorIndex);
    }

    @Override
    public void visitFloat(float value) {
        System.out.printf("%-25s[index=%d, value=%f]\n", "FloatInfo", index++, value);
    }

    @Override
    public void visitInteger(int value) {
        System.out.printf("%-25s[index=%d, value=%d]\n", "IntegerInfo", index++, value);
    }

    @Override
    public void visitInterfaceMethodReference(int nameIndex, int descriptorIndex) {
        System.out.printf("%-25s[index=%d, nameIndex=%d, descriptorIndex=%d]\n", "InterfaceMethodReferenceInfo", index++, nameIndex, descriptorIndex);
    }

    @Override
    public void visitInvokeDynamic(int methodIndex, int descriptorIndex) {
        System.out.printf("%-25s[index=%d, methodIndex=%d, descriptorIndex=%s]\n", "InvokeDynamicInfo", index++, methodIndex, descriptorIndex);
    }

    @Override
    public void visitLong(long value) {
        System.out.printf("%-25s[index=%d, value=%d]\n", "LongInfo", index, value);
        index += 2;
    }

    @Override
    public void visitMethodHandle(int type, int referenceIndex) {
        System.out.printf("%-25s[index=%d, type=%d, referenceIndex=%s]\n", "MethodHandleInfo", index++, type, referenceIndex);
    }

    @Override
    public void visitMethodReference(int nameIndex, int descriptorIndex) {
        System.out.printf("%-25s[index=%d, nameIndex=%s, descriptorIndex=%d]\n", "MethodReferenceInfo", index++, nameIndex, descriptorIndex);
    }

    @Override
    public void visitMethodType(int descriptorIndex) {
        System.out.printf("%-25s[index=%d, descriptorIndex=%s]\n", "MethodTypeInfo", index++, descriptorIndex);
    }

    @Override
    public void visitNameType(int nameIndex, int descriptorIndex) {
        System.out.printf("%-25s[index=%d, nameIndex=%d, descriptorIndex=%d]\n", "NameTypeInfo", index++, nameIndex, descriptorIndex);
    }

    @Override
    public void visitString(int valueIndex) {
        System.out.printf("%-25s[index=%d, valueIndex=%d]\n", "StringInfo", index++, valueIndex);
    }

    @Override
    public void visitUTF8(String value) {
        System.out.printf("%-25s[index=%d, value=%s]\n", "UTF8Info", index++, value);
    }

    @Override
    public void end() {
        System.out.println("ConstantPool [END]");
    }
}