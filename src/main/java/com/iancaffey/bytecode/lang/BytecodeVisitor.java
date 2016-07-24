package com.iancaffey.bytecode.lang;

/**
 * BytecodeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface BytecodeVisitor {
    public default void begin() {
    }

    public default void end() {
    }
}
