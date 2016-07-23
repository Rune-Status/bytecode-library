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
public abstract class SequentialBytecodeReader<T extends BytecodeToken, V extends BytecodeVisitor> extends AbstractBytecodeReader<V> {
    private final T[] tokens;
    private final Map<T, BytecodeConsumer<V, DataInputStream>> consumers;
    private int index = 0;

    public SequentialBytecodeReader(byte[] b, T[] tokens, Map<T, BytecodeConsumer<V, DataInputStream>> consumers) {
        super(b);
        if (tokens == null || consumers == null)
            throw new IllegalArgumentException();
        this.tokens = tokens;
        this.consumers = consumers;
    }

    public SequentialBytecodeReader(byte[] b, int offset, int length, T[] tokens, Map<T, BytecodeConsumer<V, DataInputStream>> consumers) {
        super(b, offset, length);
        if (tokens == null || consumers == null)
            throw new IllegalArgumentException();
        this.tokens = tokens;
        this.consumers = consumers;
    }

    public SequentialBytecodeReader(InputStream stream, T[] tokens, Map<T, BytecodeConsumer<V, DataInputStream>> consumers) {
        super(stream);
        if (tokens == null || consumers == null)
            throw new IllegalArgumentException();
        this.tokens = tokens;
        this.consumers = consumers;
    }

    public SequentialBytecodeReader(DataInputStream stream, T[] tokens, Map<T, BytecodeConsumer<V, DataInputStream>> consumers) {
        super(stream);
        if (tokens == null || consumers == null)
            throw new IllegalArgumentException();
        this.tokens = tokens;
        this.consumers = consumers;
    }

    @Override
    protected boolean canStep() {
        return index < tokens.length;
    }

    @Override
    protected void step(V visitor) throws IOException {
        if (!canStep())
            throw new BufferUnderflowException();
        T token = tokens[index++];
        if (!consumers.containsKey(token))
            throw new IllegalArgumentException("Unable to parse token: " + token);
        consumers.get(token).accept(visitor, stream);
    }
}
