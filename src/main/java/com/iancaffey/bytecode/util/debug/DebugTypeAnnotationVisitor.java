package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.attribute.AnnotationVisitor;
import com.iancaffey.bytecode.io.attribute.annotation.TypeAnnotationVisitor;
import com.iancaffey.bytecode.io.attribute.annotation.TypePathVisitor;
import com.iancaffey.bytecode.io.attribute.annotation.TypeTargetVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

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

    @Override
    public TypeTargetVisitor visitTarget() {
        return new DebugTypeTargetVisitor();
    }

    @Override
    public TypePathVisitor visitPath(int count) {
        return new DebugTypePathVisitor();
    }

    @Override
    public AnnotationVisitor visitAnnotation() {
        return new DebugAnnotationVisitor();
    }
}
