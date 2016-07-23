package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.util.BytecodeFunction;
import com.iancaffey.bytecode.util.BytecodeToken;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.util.Map;

/**
 * StateMachineBytecodeReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class StateMachineBytecodeReader<T extends BytecodeToken, V extends BytecodeVisitor> extends AbstractBytecodeReader<T, V> {
    private T token;
    private final Map<T, BytecodeFunction<V, DataInputStream, T>> consumers;

    public StateMachineBytecodeReader(byte[] b, V visitor, T start, Map<T, BytecodeFunction<V, DataInputStream, T>> consumers) {
        super(b, visitor);
        if (start == null || consumers == null)
            throw new IllegalArgumentException();
        this.token = start;
        this.consumers = consumers;
    }

    public StateMachineBytecodeReader(byte[] b, int offset, int length, V visitor, T start, Map<T, BytecodeFunction<V, DataInputStream, T>> consumers) {
        super(b, offset, length, visitor);
        if (start == null || consumers == null)
            throw new IllegalArgumentException();
        this.token = start;
        this.consumers = consumers;
    }

    public StateMachineBytecodeReader(InputStream stream, V visitor, T start, Map<T, BytecodeFunction<V, DataInputStream, T>> consumers) {
        super(stream, visitor);
        if (start == null || consumers == null)
            throw new IllegalArgumentException();
        this.token = start;
        this.consumers = consumers;
    }

    public StateMachineBytecodeReader(DataInputStream stream, V visitor, T start, Map<T, BytecodeFunction<V, DataInputStream, T>> consumers) {
        super(stream, visitor);
        if (start == null || consumers == null)
            throw new IllegalArgumentException();
        this.token = start;
        this.consumers = consumers;
    }

    @Override
    public boolean hasNext() {
        return token != null;
    }

    @Override
    public T peek() {
        return token;
    }

    @Override
    public void read() throws IOException {
        if (!hasNext())
            throw new BufferUnderflowException();
        if (!consumers.containsKey(token))
            throw new IllegalArgumentException("Unable to parse token: " + token);
        token = consumers.get(token).apply(visitor, stream);
    }
}
