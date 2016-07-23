package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.util.BytecodeToken;
import com.iancaffey.bytecode.util.TokenReaderModel;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;

/**
 * SequentialBytecodeReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public abstract class SequentialBytecodeReader<T extends BytecodeToken, V extends BytecodeVisitor> extends AbstractBytecodeReader<V> {
    private final TokenReaderModel<T, V> model;
    private int index;

    public SequentialBytecodeReader(byte[] b, TokenReaderModel<T, V> model) {
        super(b);
        if (model == null)
            throw new IllegalArgumentException();
        this.index = 0;
        this.model = model;
    }

    public SequentialBytecodeReader(byte[] b, int offset, int length, TokenReaderModel<T, V> model) {
        super(b, offset, length);
        if (model == null)
            throw new IllegalArgumentException();
        this.index = 0;
        this.model = model;
    }

    public SequentialBytecodeReader(InputStream stream, TokenReaderModel<T, V> model) {
        super(stream);
        if (model == null)
            throw new IllegalArgumentException();
        this.index = 0;
        this.model = model;
    }

    public SequentialBytecodeReader(DataInputStream stream, TokenReaderModel<T, V> model) {
        super(stream);
        if (model == null)
            throw new IllegalArgumentException();
        this.index = 0;
        this.model = model;
    }

    @Override
    protected boolean canStep() {
        return index < model.tokenCount();
    }

    @Override
    protected void step(V visitor) throws IOException {
        if (!canStep())
            throw new BufferUnderflowException();
        model.adapter(model.token(index++)).accept(visitor, stream);
    }
}
