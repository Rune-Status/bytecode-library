package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.ClassVisitor;
import com.iancaffey.bytecode.ConstantPoolVisitor;
import com.iancaffey.bytecode.FieldVisitor;
import com.iancaffey.bytecode.MethodVisitor;
import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.util.Access;
import com.iancaffey.bytecode.util.DebugVisitor;

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
    public ConstantPoolVisitor visitConstantPool(int count) {
        log(String.format("ConstantPool [count=%d]", count), 1);
        return new DebugConstantPoolVisitor(indent() + 1);
    }

    @Override
    public FieldVisitor visitFields(int count) {
        log(String.format("Fields [count=%d]", count), 1);
        return new DebugFieldVisitor(indent() + 1);
    }

    @Override
    public MethodVisitor visitMethods(int count) {
        log(String.format("Methods [count=%d]", count), 1);
        return new DebugMethodVisitor(indent() + 1);
    }

    @Override
    public AttributeVisitor visitAttributes(int count) {
        log(String.format("Attributes [count=%d]", count), 1);
        return new DebugAttributeVisitor(indent() + 1);
    }
}