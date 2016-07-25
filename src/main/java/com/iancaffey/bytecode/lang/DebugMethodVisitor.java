package com.iancaffey.bytecode.lang;

import com.iancaffey.bytecode.util.Access;

/**
 * DebugMethodVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugMethodVisitor implements MethodVisitor {
    @Override
    public void begin() {
        System.out.println("Method [BEGIN]");
    }

    @Override
    public void visit(int access, int nameIndex, int descriptorIndex) {
        System.out.printf("Method[access=%s, nameIndex=%s, descriptorIndex=%s]\n", Access.of(access).toString().toLowerCase(), nameIndex, descriptorIndex);
    }

    @Override
    public AttributeVisitor visitAttributes(int count) {
        System.out.printf("Attributes [count=%d]\n", count);
        return new DebugAttributeVisitor();
    }

    @Override
    public void end() {
        System.out.println("Method [END]");
    }
}
