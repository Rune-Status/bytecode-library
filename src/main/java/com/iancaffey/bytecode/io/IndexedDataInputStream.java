package com.iancaffey.bytecode.io;

import java.io.*;

/**
 * IndexedDataInputStream
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class IndexedDataInputStream extends IndexedByteArrayInputStream implements DataInput {
    private final byte readBuffer[] = new byte[8];

    public IndexedDataInputStream(byte[] buf) {
        super(buf);
    }

    public IndexedDataInputStream(byte[] buf, int offset, int length) {
        super(buf, offset, length);
    }

    public IndexedDataInputStream(InputStream stream) throws IOException {
        super(stream);
    }

    @Override
    public void readFully(byte[] b) throws IOException {
        readFully(b, 0, b.length);
    }

    @Override
    public void readFully(byte[] b, int off, int len) throws IOException {
        if (len < 0)
            throw new IndexOutOfBoundsException();
        if (pos + len >= buf.length)
            throw new EOFException();
        System.arraycopy(buf, pos, b, off, len);
        pos += len;
    }

    @Override
    public int skipBytes(int n) throws IOException {
        pos += n;
        if (pos >= buf.length)
            throw new EOFException();
        return pos;
    }

    @Override
    public boolean readBoolean() throws IOException {
        int ch = read();
        if (ch < 0)
            throw new EOFException();
        return (ch != 0);
    }

    @Override
    public byte readByte() throws IOException {
        int ch = read();
        if (ch < 0)
            throw new EOFException();
        return (byte) (ch);
    }

    @Override
    public int readUnsignedByte() throws IOException {
        int ch = read();
        if (ch < 0)
            throw new EOFException();
        return ch;
    }

    @Override
    public short readShort() throws IOException {
        int ch1 = read();
        int ch2 = read();
        if ((ch1 | ch2) < 0)
            throw new EOFException();
        return (short) ((ch1 << 8) + ch2);
    }

    @Override
    public int readUnsignedShort() throws IOException {
        int ch1 = read();
        int ch2 = read();
        if ((ch1 | ch2) < 0)
            throw new EOFException();
        return (ch1 << 8) + ch2;
    }

    @Override
    public char readChar() throws IOException {
        int ch1 = read();
        int ch2 = read();
        if ((ch1 | ch2) < 0)
            throw new EOFException();
        return (char) ((ch1 << 8) + ch2);
    }

    @Override
    public int readInt() throws IOException {
        int ch1 = read();
        int ch2 = read();
        int ch3 = read();
        int ch4 = read();
        if ((ch1 | ch2 | ch3 | ch4) < 0)
            throw new EOFException();
        return ((ch1 << 24) + (ch2 << 16) + (ch3 << 8) + ch4);
    }

    @Override
    public long readLong() throws IOException {
        readFully(readBuffer, 0, 8);
        return (((long) readBuffer[0] << 56) +
                ((long) (readBuffer[1] & 255) << 48) +
                ((long) (readBuffer[2] & 255) << 40) +
                ((long) (readBuffer[3] & 255) << 32) +
                ((long) (readBuffer[4] & 255) << 24) +
                ((readBuffer[5] & 255) << 16) +
                ((readBuffer[6] & 255) << 8) +
                (readBuffer[7] & 255));
    }

    @Override
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override
    public String readLine() throws IOException {
        throw new UnsupportedOperationException();
    }

    @Override
    public String readUTF() throws IOException {
        return DataInputStream.readUTF(this);
    }
}
