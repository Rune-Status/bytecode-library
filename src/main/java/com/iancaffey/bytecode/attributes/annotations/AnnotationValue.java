package com.iancaffey.bytecode.attributes.annotations;

import com.iancaffey.bytecode.attributes.Annotation;
import com.iancaffey.bytecode.attributes.ElementValue;

/**
 * AnnotationValue
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AnnotationValue extends ElementValue {
    private final Annotation annotation;

    public AnnotationValue(int tag, Annotation annotation) {
        super(tag);
        this.annotation = annotation;
    }

    public Annotation annotation() {
        return annotation;
    }
}
