package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.attribute.BootstrapMethodVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugBootstrapMethodVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugBootstrapMethodVisitor extends DebugVisitor implements BootstrapMethodVisitor {
    public DebugBootstrapMethodVisitor() {
        super("BootstrapMethod");
    }

    public DebugBootstrapMethodVisitor(int indent) {
        super("BootstrapMethod", indent);
    }

    @Override
    public void visit(int index, int[] argumentIndexes) {

    }
}
