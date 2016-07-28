package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.*;

import java.util.Arrays;

/**
 * DebugClassVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugClassVisitor extends DebugVisitor implements ClassVisitor {
    public DebugClassVisitor() {
        super("Class");
    }

    public DebugClassVisitor(int indent) {
        super("Class", indent);
    }

    @Override
    public void visit(int major, int minor, int access, int nameIndex, int parentNameIndex, int[] interfaces) {
        log(String.format("Class [access=%s, version=%d.%d, nameIndex=%s, superNameIndex=%s, interfaces=%s]",
                Access.of(access).toString().toLowerCase(), major, minor, nameIndex, parentNameIndex, Arrays.toString(interfaces)), 1);
    }

    @Override
    public ConstantPoolInfoVisitor visitConstantPool(int count) {
        log(String.format("ConstantPool [count=%d]", count), 2);
        return new DebugConstantPoolInfoVisitor(indent() + 2);
    }

    @Override
    public FieldVisitor visitFields(int count) {
        log(String.format("Fields [count=%d]", count), 2);
        return new DebugFieldVisitor(indent() + 2);
    }

    @Override
    public MethodVisitor visitMethods(int count) {
        log(String.format("Methods [count=%d]", count), 2);
        return new DebugMethodVisitor(indent() + 2);
    }

    @Override
    public AttributeVisitor visitAttributes(int count) {
        log(String.format("Attributes [count=%d]", count), 2);
        return new DebugAttributeVisitor(indent() + 2);
    }
}
