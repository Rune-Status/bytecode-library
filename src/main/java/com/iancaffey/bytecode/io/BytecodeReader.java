package com.iancaffey.bytecode.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * BytecodeReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public abstract class BytecodeReader<V extends BytecodeVisitor> extends IndexedDataInputStream {
    public BytecodeReader(byte[] data) {
        super(data);
    }

    public BytecodeReader(byte[] data, int offset, int length) {
        super(data, offset, length);
    }

    public BytecodeReader(InputStream stream) throws IOException {
        super(stream);
    }

    public abstract void accept(V visitor) throws IOException;
}