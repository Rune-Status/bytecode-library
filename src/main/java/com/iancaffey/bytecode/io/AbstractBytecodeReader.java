package com.iancaffey.bytecode.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * AbstractBytecodeReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public abstract class AbstractBytecodeReader<V extends BytecodeVisitor> implements BytecodeReader<V> {
    protected final DataInputStream stream;

    protected AbstractBytecodeReader(byte[] b) {
        this(new ByteArrayInputStream(b));
    }

    protected AbstractBytecodeReader(byte[] b, int offset, int length) {
        this(new ByteArrayInputStream(b, offset, length));
    }

    protected AbstractBytecodeReader(InputStream stream) {
        this(new DataInputStream(stream));
    }

    protected AbstractBytecodeReader(DataInputStream stream) {
        if (stream == null)
            throw new IllegalArgumentException();
        this.stream = stream;
    }

    protected abstract boolean canStep();

    protected abstract void step(V visitor) throws IOException;

    @Override
    public void accept(V visitor) throws IOException {
        while (canStep())
            step(visitor);
    }

    @Override
    public void close() throws IOException {
        stream.close();
    }
}
