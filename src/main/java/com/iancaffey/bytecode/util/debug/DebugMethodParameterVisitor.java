package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.model.attribute.MethodParameterVisitor;

/**
 * DebugMethodParameterVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugMethodParameterVisitor extends DebugVisitor implements MethodParameterVisitor {
    public DebugMethodParameterVisitor() {
    }

    public DebugMethodParameterVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visit(int nameIndex, int access) {
        log(String.format("MethodParameter [nameIndex=%d, access=%d]", nameIndex, access), 1);
    }
}
