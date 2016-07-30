package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.direct.attribute.AnnotationVisitor;
import com.iancaffey.bytecode.io.direct.attribute.ParameterAnnotationVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugParameterAnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugParameterAnnotationVisitor extends DebugVisitor implements ParameterAnnotationVisitor {
    public DebugParameterAnnotationVisitor() {
    }

    public DebugParameterAnnotationVisitor(int indent) {
        super(indent);
    }

    @Override
    public AnnotationVisitor visitAnnotations(int count) {
        log(String.format("Annotations [count=%d]", count), 1);
        return new DebugAnnotationVisitor(indent() + 1);
    }
}
