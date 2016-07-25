package com.iancaffey.bytecode.lang;

import com.iancaffey.bytecode.util.Access;

import java.util.Arrays;

/**
 * DebugClassVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugClassVisitor implements ClassVisitor {
    @Override
    public void begin() {
        System.out.println("Class [BEGIN]");
    }

    @Override
    public void visit(int major, int minor, int access, int nameIndex, int parentNameIndex, int[] interfaces) {
        System.out.printf("Class[access=%s, version=%d.%d, nameIndex=%s, superNameIndex=%s, interfaces=%s]\n",
                Access.of(access).toString().toLowerCase(), major, minor, nameIndex, parentNameIndex, Arrays.toString(interfaces));
    }

    @Override
    public ConstantPoolVisitor visitConstantPool(int count) {
        System.out.printf("ConstantPool [count=%d]\n", count);
        return new DebugConstantPoolVisitor();
    }

    @Override
    public FieldVisitor visitFields(int count) {
        System.out.printf("Fields [count=%d]\n", count);
        return new DebugFieldVisitor();
    }

    @Override
    public MethodVisitor visitMethods(int count) {
        System.out.printf("Methods [count=%d]\n", count);
        return new DebugMethodVisitor();
    }

    @Override
    public AttributeVisitor visitAttributes(int count) {
        System.out.printf("Attributes [count=%d]\n", count);
        return new DebugAttributeVisitor();
    }

    @Override
    public void end() {
        System.out.println("Class [END]");
    }
}
