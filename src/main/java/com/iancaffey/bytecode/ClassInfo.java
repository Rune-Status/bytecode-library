package com.iancaffey.bytecode;

import com.iancaffey.bytecode.util.Type;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * ClassInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassInfo {
    public static final int MAGIC = 0xCAFEBABE;
    private int version;
    private int access;
    private String name;
    private String superClassName;
    private String outerClassName;
    private String outerMethodName;
    private String outerMethodDescriptor;
    private String signature;
    private Set<String> interfaces = new HashSet<>();
    private Set<FieldInfo> fields = new HashSet<>();
    private Set<MethodInfo> methods = new HashSet<>();

    public ClassInfo() {
    }

    public ClassInfo(int version, int access, String name, String superClassName, String outerClassName,
                     String outerMethodName, String outerMethodDescriptor, String signature) {
        this.version = version;
        this.access = access;
        this.name = name;
        this.superClassName = superClassName;
        this.outerClassName = outerClassName;
        this.outerMethodName = outerMethodName;
        this.outerMethodDescriptor = outerMethodDescriptor;
        this.signature = signature;
    }

    public int version() {
        return version;
    }

    public ClassInfo version(int version) {
        this.version = version;
        return this;
    }

    public int access() {
        return access;
    }

    public ClassInfo access(int access) {
        this.access = access;
        return this;
    }

    public String name() {
        return name;
    }

    public ClassInfo name(String name) {
        this.name = name;
        return this;
    }

    public String superClassName() {
        return superClassName;
    }

    public ClassInfo superClassName(String superClassName) {
        this.superClassName = superClassName;
        return this;
    }

    public String outerClassName() {
        return outerClassName;
    }

    public ClassInfo outerClassName(String outerClassName) {
        this.outerClassName = outerClassName;
        return this;
    }

    public String outerMethodName() {
        return outerMethodName;
    }

    public ClassInfo outerMethodName(String outerMethodName) {
        this.outerMethodDescriptor = outerMethodName;
        return this;
    }

    public String outerMethodDescriptor() {
        return outerMethodDescriptor;
    }

    public ClassInfo outerMethodDescriptor(String outerMethodDescriptor) {
        this.outerMethodDescriptor = outerMethodDescriptor;
        return this;
    }

    public String signature() {
        return signature;
    }

    public ClassInfo signature(String signature) {
        this.signature = signature;
        return this;
    }

    public Set<String> interfaces() {
        return new HashSet<>(interfaces);
    }

    public ClassInfo add(Class<?> c) {
        if (c == null || !c.isInterface())
            throw new IllegalArgumentException();
        return add(Type.getInternalForm(c));
    }

    public ClassInfo add(String iface) {
        if (iface == null)
            throw new IllegalArgumentException();
        interfaces.add(iface);
        return this;
    }

    public ClassInfo remove(Class<?> c) {
        if (c == null || !c.isInterface())
            throw new IllegalArgumentException();
        return remove(Type.getInternalForm(c));
    }

    public ClassInfo remove(String iface) {
        if (iface == null)
            throw new IllegalArgumentException();
        interfaces.remove(iface);
        return this;
    }

    public Set<FieldInfo> fields() {
        return new HashSet<>(fields);
    }

    public ClassInfo add(FieldInfo field) {
        if (field == null)
            throw new IllegalArgumentException();
        fields.add(field);
        return this;
    }

    public ClassInfo remove(FieldInfo field) {
        if (field == null)
            throw new IllegalArgumentException();
        fields.remove(field);
        return this;
    }

    public Set<MethodInfo> methods() {
        return new HashSet<>(methods);
    }

    public ClassInfo add(MethodInfo method) {
        if (method == null)
            throw new IllegalArgumentException();
        methods.add(method);
        return this;
    }

    public ClassInfo remove(MethodInfo method) {
        if (method == null)
            throw new IllegalArgumentException();
        methods.remove(method);
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, signature);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ClassInfo && Objects.equals(name(), ((ClassInfo) o).name()) && Objects.equals(signature(), ((ClassInfo) o).signature());
    }
}
