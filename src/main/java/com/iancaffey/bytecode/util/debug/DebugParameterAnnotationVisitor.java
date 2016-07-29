package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.AnnotationVisitor;
import com.iancaffey.bytecode.ParameterAnnotationVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugParameterAnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugParameterAnnotationVisitor extends DebugVisitor implements ParameterAnnotationVisitor {
    public DebugParameterAnnotationVisitor() {
        super("ParameterAnnotation");
    }

    public DebugParameterAnnotationVisitor(int indent) {
        super("ParameterAnnotation", indent);
    }

    @Override
    public AnnotationVisitor visitAnnotations(int count) {
        return new DebugAnnotationVisitor(indent() + 1);
    }
}
