package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.model.attribute.BootstrapMethodVisitor;

import java.util.Arrays;

/**
 * DebugBootstrapMethodVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugBootstrapMethodVisitor extends DebugVisitor implements BootstrapMethodVisitor {
    public DebugBootstrapMethodVisitor() {
    }

    public DebugBootstrapMethodVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visit(int index, int[] argumentIndexes) {
        log(String.format("BootstrapMethod [index=%d, argumentIndexes=%s]", index, Arrays.toString(argumentIndexes)), 1);
    }
}
