package com.iancaffey.bytecode;

import com.iancaffey.bytecode.util.Accessible;

/**
 * ClassInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassInfo implements Accessible {
    private final int magic;
    private final int major;
    private final int minor;
    private final int access;
    private final String name;
    private final String superName;
    private final String[] interfaces;
    private final FieldInfo[] fields;
    private final MethodInfo[] methods;
    private final AttributeInfo[] attributes;

    public ClassInfo(int magic, int major, int minor, int access, String name, String superName, String[] interfaces, FieldInfo[] fields, MethodInfo[] methods, AttributeInfo[] attributes) {
        this.magic = magic;
        this.minor = minor;
        this.major = major;
        this.access = access;
        this.name = name;
        this.superName = superName;
        this.interfaces = interfaces;
        this.fields = fields;
        this.methods = methods;
        this.attributes = attributes;
    }

    public int magic() {
        return magic;
    }

    public int major() {
        return major;
    }

    public int minor() {
        return minor;
    }

    public int version() {
        return ((major & 0xFF) << 16) | (minor & 0xFF);
    }

    @Override
    public int access() {
        return access;
    }

    public String name() {
        return name;
    }

    public String superName() {
        return superName;
    }

    public int interfaceCount() {
        return interfaces.length;
    }

    public String interfaceName(int index) {
        return interfaces[index];
    }

    public int fieldCount() {
        return fields.length;
    }

    public FieldInfo field(int index) {
        return fields[index];
    }

    public int methodCount() {
        return methods.length;
    }

    public MethodInfo method(int index) {
        return methods[index];
    }

    public int attributeCount() {
        return attributes.length;
    }

    public AttributeInfo attribute(int index) {
        return attributes[index];
    }
}
