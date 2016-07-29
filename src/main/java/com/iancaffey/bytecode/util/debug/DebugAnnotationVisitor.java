package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.AnnotationVisitor;
import com.iancaffey.bytecode.ElementValuePairVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugAnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugAnnotationVisitor extends DebugVisitor implements AnnotationVisitor {
    public DebugAnnotationVisitor() {
        super("Annotation");
    }

    public DebugAnnotationVisitor(int indent) {
        super("Annotation", indent);
    }

    @Override
    public ElementValuePairVisitor visit(int typeIndex, int count) {
        return new DebugElementValuePairVisitor(indent() + 1);
    }
}
