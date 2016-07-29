package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.TypeAnnotationVisitor;

/**
 * DebugTypeAnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugTypeAnnotationVisitor extends DebugVisitor implements TypeAnnotationVisitor {
    public DebugTypeAnnotationVisitor() {
        super("TypeAnnotation");
    }

    public DebugTypeAnnotationVisitor(int indent) {
        super("TypeAnnotation", indent);
    }
}
