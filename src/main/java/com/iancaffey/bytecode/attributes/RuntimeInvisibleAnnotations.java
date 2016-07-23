package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * RuntimeInvisibleAnnotations
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RuntimeInvisibleAnnotations extends AttributeInfo {
    private final Annotation[] annotations;

    public RuntimeInvisibleAnnotations(int nameIndex, int infoLength, Annotation[] annotations) {
        super(nameIndex, infoLength);
        this.annotations = annotations;
    }

    public int annotationCount() {
        return annotations.length;
    }

    public Annotation annotation(int index) {
        return annotations[index];
    }
}
