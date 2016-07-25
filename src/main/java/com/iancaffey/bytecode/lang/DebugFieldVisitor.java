package com.iancaffey.bytecode.lang;

import com.iancaffey.bytecode.util.Access;

/**
 * DebugFieldVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugFieldVisitor implements FieldVisitor {
    @Override
    public void begin() {
        System.out.println("Field [BEGIN]");
    }

    @Override
    public void visit(int access, int nameIndex, int descriptorIndex) {
        System.out.printf("Field[access=%s, nameIndex=%s, descriptorIndex=%s]\n", Access.of(access).toString().toLowerCase(), nameIndex, descriptorIndex);
    }

    @Override
    public AttributeVisitor visitAttributes(int count) {
        System.out.printf("Attributes [count=%d]\n", count);
        return new DebugAttributeVisitor();
    }

    @Override
    public void end() {
        System.out.println("Field [END]");
    }
}
