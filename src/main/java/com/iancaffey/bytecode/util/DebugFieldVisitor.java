package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.AttributeVisitor;
import com.iancaffey.bytecode.FieldVisitor;

/**
 * DebugFieldVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugFieldVisitor extends DebugVisitor implements FieldVisitor {
    public DebugFieldVisitor() {
        super("Field");
    }

    public DebugFieldVisitor(int indent) {
        super("Field", indent);
    }

    @Override
    public void visit(int access, int nameIndex, int descriptorIndex) {
        log(String.format("%-25s[access=%s, nameIndex=%s, descriptorIndex=%s]", "Field", Access.of(access).toString().toLowerCase(), nameIndex, descriptorIndex), 1);
    }

    @Override
    public AttributeVisitor visitAttributes(int count) {
        log(String.format("Attributes [count=%d]", count), 2);
        return new DebugAttributeVisitor(indent() + 2);
    }
}
