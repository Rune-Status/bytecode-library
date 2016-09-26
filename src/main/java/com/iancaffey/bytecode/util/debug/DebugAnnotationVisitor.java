package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.model.attribute.AnnotationVisitor;
import com.iancaffey.bytecode.model.attribute.ElementValuePairVisitor;

/**
 * DebugAnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugAnnotationVisitor extends DebugVisitor implements AnnotationVisitor {
    public DebugAnnotationVisitor() {
    }

    public DebugAnnotationVisitor(int indent) {
        super(indent);
    }

    @Override
    public ElementValuePairVisitor visit(int typeIndex, int count) {
        log(String.format("Annotation [typeIndex=%d, count=%d]", typeIndex, count), 1);
        return new DebugElementValuePairVisitor(indent() + 1);
    }
}
