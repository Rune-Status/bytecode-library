package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.util.BytecodeToken;

import java.io.IOException;

/**
 * BytecodeReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface BytecodeReader<T extends BytecodeToken> extends AutoCloseable {
    public T peek();

    public void read() throws IOException;

    public default boolean hasNext() {
        return peek() != null;
    }

    public default void readFully() throws IOException {
        while (hasNext())
            read();
    }
}
