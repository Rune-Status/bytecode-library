package com.iancaffey.bytecode.attributes;

/**
 * ElementPair
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ElementPair {
    private final String name;
    private final ElementValue value;

    public ElementPair(String name, ElementValue value) {
        this.name = name;
        this.value = value;
    }

    public String name() {
        return name;
    }

    public ElementValue value() {
        return value;
    }
}
