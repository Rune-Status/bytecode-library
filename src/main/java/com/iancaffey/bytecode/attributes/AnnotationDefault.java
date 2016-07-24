package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * AnnotationDefault
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AnnotationDefault extends AttributeInfo {
    private final ElementValue defaultValue;

    public AnnotationDefault(String name, int infoLength, ElementValue defaultValue) {
        super(name, infoLength);
        this.defaultValue = defaultValue;
    }

    public ElementValue defaultValue() {
        return defaultValue;
    }
}
