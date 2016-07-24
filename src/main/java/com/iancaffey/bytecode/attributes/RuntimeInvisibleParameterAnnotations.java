package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * RuntimeInvisibleParameterAnnotations
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RuntimeInvisibleParameterAnnotations extends AttributeInfo {
    private final Annotation[][] parameterAnnotations;

    public RuntimeInvisibleParameterAnnotations(String name, int infoLength, Annotation[]... parameterAnnotations) {
        super(name, infoLength);
        this.parameterAnnotations = parameterAnnotations;
    }

    public int parameterCount() {
        return parameterAnnotations.length;
    }

    public int annotationCount(int index) {
        return parameterAnnotations[index].length;
    }

    public Annotation annotation(int parameter, int index) {
        return parameterAnnotations[parameter][index];
    }
}
