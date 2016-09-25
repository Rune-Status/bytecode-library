package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.model.*;
import com.iancaffey.bytecode.util.Access;

import java.util.Arrays;

/**
 * DebugClassModelVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugClassModelVisitor extends DebugVisitor implements ClassModelVisitor {
    public DebugClassModelVisitor() {
    }

    public DebugClassModelVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visitVersion(int major, int minor) {
        log(String.format("Class [version=%d.%d]", major, minor));
    }

    @Override
    public void visitDescription(int access, int nameIndex, int parentNameIndex, int[] interfaces) {
        log(String.format("Class [access=%s, nameIndex=%s, superNameIndex=%s, interfaces=%s]",
                Access.of(access).toString().toLowerCase(), nameIndex, parentNameIndex, Arrays.toString(interfaces)));
    }

    @Override
    public ConstantPoolVisitor visitConstantPool(int count) {
        log(String.format("ConstantPool [count=%d]", count));
        return new DebugConstantPoolVisitor(indent());
    }

    @Override
    public FieldModelVisitor visitFields(int count) {
        log(String.format("Fields [count=%d]", count));
        return new DebugFieldModelVisitor(indent());
    }

    @Override
    public MethodModelVisitor visitMethods(int count) {
        log(String.format("Methods [count=%d]", count));
        return new DebugMethodModelVisitor(indent());
    }

    @Override
    public AttributeModelVisitor visitAttributes(int count) {
        log(String.format("Attributes [count=%d]", count));
        return new DebugAttributeModelVisitor(indent());
    }
}
