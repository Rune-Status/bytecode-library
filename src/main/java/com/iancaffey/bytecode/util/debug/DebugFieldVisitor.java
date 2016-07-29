package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.AttributeVisitor;
import com.iancaffey.bytecode.FieldVisitor;
import com.iancaffey.bytecode.util.Access;
import com.iancaffey.bytecode.util.DebugVisitor;

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
        log(String.format("Field [access=%s, nameIndex=%s, descriptorIndex=%s]", Access.of(access).toString().toLowerCase(), nameIndex, descriptorIndex), 1);
    }

    @Override
    public AttributeVisitor visitAttributes(int count) {
        log(String.format("Attributes [count=%d]", count), 2);
        return new DebugAttributeVisitor(indent() + 2);
    }
}
