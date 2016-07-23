package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.ClassVisitor;

/**
 * DebugClassVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugClassVisitor implements ClassVisitor {
    @Override
    public void begin() {
        System.out.println("Visited begin");
    }

    @Override
    public void visitMagic(int magic) {
        System.out.println("Visited magic: 0x" + Integer.toHexString(magic));
    }

    @Override
    public void visitVersion(int major, int minor) {
        System.out.println("Visited version: " + major + "." + minor);
    }

    @Override
    public void visitAccess() {

    }

    @Override
    public void end() {
        System.out.println("Visited end");
    }
}
