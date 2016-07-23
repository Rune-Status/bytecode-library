package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.util.BytecodeToken;

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
public abstract class AbstractBytecodeReader<T extends BytecodeToken, V extends BytecodeVisitor> implements BytecodeReader<V> {
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

    protected abstract void step(V visitor) throws IOException;

    protected abstract boolean hasNext();

    @Override
    public void accept(V visitor) throws IOException {
        while (hasNext())
            step(visitor);
    }

    @Override
    public void close() throws IOException {
        stream.close();
    }
}
