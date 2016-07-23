package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * RuntimeVisibleParameterAnnotations
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RuntimeVisibleParameterAnnotations extends AttributeInfo {
    private final Annotation[][] parameterAnnotations;

    public RuntimeVisibleParameterAnnotations(int nameIndex, int infoLength, Annotation[][] parameterAnnotations) {
        super(nameIndex, infoLength);
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
