package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.direct.*;
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
    }

    public DebugClassVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visit(int major, int minor, int access, int nameIndex, int parentNameIndex, int[] interfaces) {
        log(String.format("Class [access=%s, version=%d.%d, nameIndex=%s, superNameIndex=%s, interfaces=%s]",
                Access.of(access).toString().toLowerCase(), major, minor, nameIndex, parentNameIndex, Arrays.toString(interfaces)));
    }

    @Override
    public ConstantPoolVisitor visitConstantPool(int count) {
        log(String.format("ConstantPool [count=%d]", count));
        return new DebugConstantPoolVisitor(indent());
    }

    @Override
    public FieldVisitor visitFields(int count) {
        log(String.format("Fields [count=%d]", count));
        return new DebugFieldVisitor(indent());
    }

    @Override
    public MethodVisitor visitMethods(int count) {
        log(String.format("Methods [count=%d]", count));
        return new DebugMethodVisitor(indent());
    }

    @Override
    public AttributeVisitor visitAttributes(int count) {
        log(String.format("Attributes [count=%d]", count));
        return new DebugAttributeVisitor(indent());
    }
}
