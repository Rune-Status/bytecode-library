package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.util.BytecodeConsumer;
import com.iancaffey.bytecode.util.BytecodeToken;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.util.Map;

/**
 * SequentialBytecodeReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SequentialBytecodeReader<T extends BytecodeToken, V extends BytecodeVisitor> extends AbstractBytecodeReader<T, V> {
    private int index = 0;
    private final T[] tokens;
    private final Map<T, BytecodeConsumer<V, DataInputStream>> consumers;

    public SequentialBytecodeReader(byte[] b, V visitor, T[] tokens, Map<T, BytecodeConsumer<V, DataInputStream>> consumers) {
        super(b, visitor);
        if (tokens == null || consumers == null)
            throw new IllegalArgumentException();
        this.tokens = tokens;
        this.consumers = consumers;
    }

    public SequentialBytecodeReader(byte[] b, int offset, int length, V visitor, T[] tokens, Map<T, BytecodeConsumer<V, DataInputStream>> consumers) {
        super(b, offset, length, visitor);
        if (tokens == null || consumers == null)
            throw new IllegalArgumentException();
        this.tokens = tokens;
        this.consumers = consumers;
    }

    public SequentialBytecodeReader(InputStream stream, V visitor, T[] tokens, Map<T, BytecodeConsumer<V, DataInputStream>> consumers) {
        super(stream, visitor);
        if (tokens == null || consumers == null)
            throw new IllegalArgumentException();
        this.tokens = tokens;
        this.consumers = consumers;
    }

    public SequentialBytecodeReader(DataInputStream stream, V visitor, T[] tokens, Map<T, BytecodeConsumer<V, DataInputStream>> consumers) {
        super(stream, visitor);
        if (tokens == null || consumers == null)
            throw new IllegalArgumentException();
        this.tokens = tokens;
        this.consumers = consumers;
    }

    @Override
    public boolean hasNext() {
        return index < tokens.length;
    }

    @Override
    public T peek() {
        return hasNext() ? tokens[index] : null;
    }

    @Override
    public void read() throws IOException {
        if (!hasNext())
            throw new BufferUnderflowException();
        T token = tokens[index++];
        if (!consumers.containsKey(token))
            throw new IllegalArgumentException("Unable to parse token: " + token);
        consumers.get(token).accept(visitor, stream);
    }
}
