package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;
import java.io.InputStream;

/**
 * BytecodeConsumer
 *
 * @author Ian Caffey
 * @since 1.0
 */
@FunctionalInterface
public interface BytecodeConsumer<V extends BytecodeVisitor, S extends InputStream> {
    void accept(V visitor, S stream) throws IOException;
}
