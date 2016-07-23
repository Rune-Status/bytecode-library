package com.iancaffey.bytecode.io;

import java.io.IOException;

/**
 * BytecodeReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface BytecodeReader<V extends BytecodeVisitor> extends AutoCloseable {
    public void accept(V visitor) throws IOException;
}
