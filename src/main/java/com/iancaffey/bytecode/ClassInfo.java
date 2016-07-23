package com.iancaffey.bytecode;

import com.iancaffey.bytecode.util.Accessible;

/**
 * ClassInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassInfo implements Accessible {
    public static final int MAGIC = 0xCAFEBABE;
    private final int magic;
    private final int minor;
    private final int major;
    private final ConstantPoolInfo[] constantPool;
    private final int access;
    private final int info;
    private final int parent;
    private final int[] interfaces;
    private final FieldInfo[] fields;
    private final MethodInfo[] methods;
    private final AttributeInfo[] attributes;

    public ClassInfo(int magic, int minor, int major, ConstantPoolInfo[] constantPool, int access, int info, int parent, int[] interfaces, FieldInfo[] fields, MethodInfo[] methods, AttributeInfo[] attributes) {
        if (magic != MAGIC || constantPool == null || interfaces == null || fields == null || methods == null || attributes == null)
            throw new IllegalArgumentException();
        this.magic = magic;
        this.minor = minor;
        this.major = major;
        this.constantPool = constantPool;
        this.access = access;
        this.info = info;
        this.parent = parent;
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
        return ((major & 0xFF) << 8) | (minor & 0xFF);
    }

    public int constantPoolCount() {
        return constantPool.length;
    }

    public ConstantPoolInfo constantPoolInfo(int index) {
        return constantPool[index];
    }

    @Override
    public int access() {
        return access;
    }

    public int infoIndex() {
        return info;
    }

    public ConstantPoolInfo info() {
        return constantPool[info];
    }

    public int parentIndex() {
        return parent;
    }

    public ConstantPoolInfo parent() {
        return constantPool[parent];
    }

    public int interfaceCount() {
        return interfaces.length;
    }

    public ConstantPoolInfo interfaceInfo(int index) {
        return constantPool[index];
    }

    public int fieldCount() {
        return fields.length;
    }

    public FieldInfo fieldInfo(int index) {
        return fields[index];
    }

    public int methodCount() {
        return methods.length;
    }

    public MethodInfo methodInfo(int index) {
        return methods[index];
    }

    public int attributeCount() {
        return attributes.length;
    }

    public AttributeInfo attributeInfo(int index) {
        return attributes[index];
    }
}
