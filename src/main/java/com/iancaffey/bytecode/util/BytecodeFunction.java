package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;
import java.io.InputStream;

/**
 * BytecodeFunction
 *
 * @author Ian Caffey
 * @since 1.0
 */
@FunctionalInterface
public interface BytecodeFunction<V extends BytecodeVisitor, S extends InputStream, R> {
    R apply(V v, S stream) throws IOException;
}