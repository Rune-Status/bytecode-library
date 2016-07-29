package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.BootstrapMethodVisitor;

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
}
