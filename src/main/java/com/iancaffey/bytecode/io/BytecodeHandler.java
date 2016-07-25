package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.BytecodeReader;
import com.iancaffey.bytecode.lang.BytecodeVisitor;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * BytecodeHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
@FunctionalInterface
public interface BytecodeHandler<R extends BytecodeReader, V extends BytecodeVisitor> {
    public static <R extends BytecodeReader<V>, V extends BytecodeVisitor> BytecodeHandler<R, V> of(BytecodeHandler<R, V>... handlers) {
        return BytecodeHandler.of(Arrays.asList(handlers));
    }

    public static <R extends BytecodeReader<V>, V extends BytecodeVisitor> BytecodeHandler<R, V> of(List<BytecodeHandler<R, V>> handlers) {
        return (reader, visitor) -> {
            for (BytecodeHandler<R, V> handler : handlers) {
                int remaining = reader.available();
                handler.accept(reader, visitor);
                if (reader.available() == remaining)
                    throw new IllegalArgumentException("Unable to move after handler: " + handler);
            }
        };
    }

    public void accept(R reader, V visitor) throws IOException;
}
