package com.iancaffey.bytecode.lang;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * BytecodeReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public abstract class BytecodeReader<V extends BytecodeVisitor> extends DataInputStream {
    public BytecodeReader(byte[] data) {
        this(new ByteArrayInputStream(data));
    }

    public BytecodeReader(byte[] data, int offset, int length) {
        this(new ByteArrayInputStream(data, offset, length));
    }

    public BytecodeReader(InputStream stream) {
        super(stream);
    }

    public abstract BytecodeReader<V> accept(V visitor) throws IOException;
}
