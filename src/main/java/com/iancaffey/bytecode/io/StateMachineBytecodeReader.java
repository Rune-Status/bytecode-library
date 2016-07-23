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
public class StateMachineBytecodeReader<T extends BytecodeToken, V extends BytecodeVisitor> extends AbstractBytecodeReader<V> {
    private final Map<T, BytecodeFunction<V, DataInputStream, T>> consumers;
    private T token;

    public StateMachineBytecodeReader(byte[] b, T start, Map<T, BytecodeFunction<V, DataInputStream, T>> consumers) {
        super(b);
        if (start == null || consumers == null)
            throw new IllegalArgumentException();
        this.token = start;
        this.consumers = consumers;
    }

    public StateMachineBytecodeReader(byte[] b, int offset, int length, T start, Map<T, BytecodeFunction<V, DataInputStream, T>> consumers) {
        super(b, offset, length);
        if (start == null || consumers == null)
            throw new IllegalArgumentException();
        this.token = start;
        this.consumers = consumers;
    }

    public StateMachineBytecodeReader(InputStream stream, T start, Map<T, BytecodeFunction<V, DataInputStream, T>> consumers) {
        super(stream);
        if (start == null || consumers == null)
            throw new IllegalArgumentException();
        this.token = start;
        this.consumers = consumers;
    }

    public StateMachineBytecodeReader(DataInputStream stream, T start, Map<T, BytecodeFunction<V, DataInputStream, T>> consumers) {
        super(stream);
        if (start == null || consumers == null)
            throw new IllegalArgumentException();
        this.token = start;
        this.consumers = consumers;
    }

    @Override
    protected boolean canStep() {
        return token != null;
    }

    @Override
    protected void step(V visitor) throws IOException {
        if (!canStep())
            throw new BufferUnderflowException();
        if (!consumers.containsKey(token))
            throw new IllegalArgumentException("Unable to parse token: " + token);
        token = consumers.get(token).apply(visitor, stream);
    }
}
