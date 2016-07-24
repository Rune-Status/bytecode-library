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
    private final String name;
    private final String descriptor;
    private final AttributeInfo[] attributes;

    public MethodInfo(int access, String name, String descriptor, AttributeInfo[] attributes) {
        this.access = access;
        this.name = name;
        this.descriptor = descriptor;
        this.attributes = attributes;
    }

    @Override
    public int access() {
        return access;
    }

    public String name() {
        return name;
    }

    public String descriptor() {
        return descriptor;
    }

    public int attributeCount() {
        return attributes.length;
    }

    public AttributeInfo attribute(int index) {
        return attributes[index];
    }
}
