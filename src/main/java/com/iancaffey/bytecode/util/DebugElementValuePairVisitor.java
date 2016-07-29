package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.ElementValuePairVisitor;
import com.iancaffey.bytecode.ElementValueVisitor;

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
