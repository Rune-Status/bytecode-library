package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.model.attribute.AnnotationVisitor;
import com.iancaffey.bytecode.io.model.attribute.annotation.TypeAnnotationVisitor;
import com.iancaffey.bytecode.io.model.attribute.annotation.TypePathVisitor;
import com.iancaffey.bytecode.io.model.attribute.annotation.TypeTargetVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugTypeAnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugTypeAnnotationVisitor extends DebugVisitor implements TypeAnnotationVisitor {
    public DebugTypeAnnotationVisitor() {
    }

    public DebugTypeAnnotationVisitor(int indent) {
        super(indent);
    }

    @Override
    public TypeTargetVisitor visitTarget() {
        log("TypeTarget", 1);
        return new DebugTypeTargetVisitor(indent() + 1);
    }

    @Override
    public TypePathVisitor visitPath(int count) {
        log(String.format("TypePath [count=%d]", count), 1);
        return new DebugTypePathVisitor(indent() + 1);
    }

    @Override
    public AnnotationVisitor visitAnnotation() {
        log("Annotation", 1);
        return new DebugAnnotationVisitor(indent() + 1);
    }
}
