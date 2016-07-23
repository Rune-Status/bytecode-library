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
public abstract class AbstractBytecodeReader<T extends BytecodeToken, V extends BytecodeVisitor> implements BytecodeReader<T> {
    protected final DataInputStream stream;
    protected final V visitor;

    public AbstractBytecodeReader(byte[] b, V visitor) {
        this(new ByteArrayInputStream(b), visitor);
    }

    public AbstractBytecodeReader(byte[] b, int offset, int length, V visitor) {
        this(new ByteArrayInputStream(b, offset, length), visitor);
    }

    public AbstractBytecodeReader(InputStream stream, V visitor) {
        this(new DataInputStream(stream), visitor);
    }

    public AbstractBytecodeReader(DataInputStream stream, V visitor) {
        if (stream == null || visitor == null)
            throw new IllegalArgumentException();
        this.stream = stream;
        this.visitor = visitor;
    }

    @Override
    public void close() throws IOException {
        stream.close();
    }
}
