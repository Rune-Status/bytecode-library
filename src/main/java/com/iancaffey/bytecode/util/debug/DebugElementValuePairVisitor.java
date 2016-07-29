package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.attribute.ElementValuePairVisitor;
import com.iancaffey.bytecode.io.attribute.ElementValueVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugElementValueVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugElementValuePairVisitor extends DebugVisitor implements ElementValuePairVisitor {
    public DebugElementValuePairVisitor() {
        super("ElementValuePair");
    }

    public DebugElementValuePairVisitor(int indent) {
        super("ElementValuePair", indent);
    }

    @Override
    public ElementValueVisitor visit(int index) {
        return new DebugElementValueVisitor(indent() + 1);
    }
}