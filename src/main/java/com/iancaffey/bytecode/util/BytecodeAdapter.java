package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * BytecodeAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
@FunctionalInterface
public interface BytecodeAdapter<R extends BytecodeReader<V>, V extends BytecodeVisitor> {
    public void accept(R reader, V visitor, DataInputStream stream) throws IOException;
}
