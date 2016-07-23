package com.iancaffey.bytecode;

import com.iancaffey.bytecode.util.Accessible;

/**
 * MethodTypeInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodInfo implements Accessible {
    private final int access;
    private final int nameIndex;
    private final int descriptorIndex;
    private final AttributeInfo[] attributes;

    public MethodInfo(int access, int nameIndex, int descriptorIndex, AttributeInfo[] attributes) {
        this.access = access;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributes = attributes;
    }

    @Override
    public int access() {
        return access;
    }

    public int nameIndex() {
        return nameIndex;
    }

    public int descriptorIndex() {
        return descriptorIndex;
    }

    public int attributeCount() {
        return attributes.length;
    }

    public AttributeInfo attribute(int index) {
        return attributes[index];
    }
}
