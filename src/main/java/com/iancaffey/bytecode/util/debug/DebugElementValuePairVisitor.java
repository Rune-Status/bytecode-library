package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.model.attribute.ElementValuePairVisitor;
import com.iancaffey.bytecode.io.model.attribute.ElementValueVisitor;

/**
 * DebugElementValueVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugElementValuePairVisitor extends DebugVisitor implements ElementValuePairVisitor {
    public DebugElementValuePairVisitor() {
    }

    public DebugElementValuePairVisitor(int indent) {
        super(indent);
    }

    @Override
    public ElementValueVisitor visit(int index) {
        log(String.format("ElementValue [index=%d, ]", index), 1);
        return new DebugElementValueVisitor(indent() + 1);
    }
}
