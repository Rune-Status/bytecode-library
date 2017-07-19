package com.iancaffey.bytecode.io;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/**
 * IndexedByteArrayInputStream
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class IndexedByteArrayInputStream extends ByteArrayInputStream {
    public IndexedByteArrayInputStream(byte[] buf) {
        super(buf);
    }

    public IndexedByteArrayInputStream(byte[] buf, int offset, int length) {
        super(buf, offset, length);
    }

    public IndexedByteArrayInputStream(InputStream stream) throws IOException {
        super(IndexedByteArrayInputStream.of(stream));
    }

    public static byte[] of(InputStream stream) throws IOException {
        byte[] data = new byte[stream.available()];
        int len = stream.read(data);
        if (len != data.length) {
            throw new EOFException();
        }
        return data;
    }

    public byte[] buffer() {
        return buf;
    }

    public int position() {
        return pos;
    }

    public void reset(int position) {
        if (position < 0 || position >= buf.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        pos = position;
    }
}
