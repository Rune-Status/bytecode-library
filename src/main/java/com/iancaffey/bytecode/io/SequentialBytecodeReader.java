package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.util.BytecodeReaderModel;
import com.iancaffey.bytecode.util.BytecodeStep;

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
public abstract class SequentialBytecodeReader<R extends SequentialBytecodeReader<R, V, M, S>, V extends BytecodeVisitor, M extends BytecodeReaderModel<R, V, S>, S extends BytecodeStep> extends AbstractBytecodeReader<V> {
    protected final M model;
    private int index;

    public SequentialBytecodeReader(byte[] data, M model) {
        super(data);
        if (model == null)
            throw new IllegalArgumentException();
        this.index = 0;
        this.model = model;
    }

    public SequentialBytecodeReader(byte[] data, int offset, int length, M model) {
        super(data, offset, length);
        if (model == null)
            throw new IllegalArgumentException();
        this.index = 0;
        this.model = model;
    }

    public SequentialBytecodeReader(InputStream stream, M model) {
        super(stream);
        if (model == null)
            throw new IllegalArgumentException();
        this.index = 0;
        this.model = model;
    }

    public SequentialBytecodeReader(DataInputStream stream, M model) {
        super(stream);
        if (model == null)
            throw new IllegalArgumentException();
        this.index = 0;
        this.model = model;
    }

    @Override
    protected boolean canStep() {
        return index < model.steps();
    }

    @Override
    protected void step(V visitor) throws IOException {
        if (!canStep())
            throw new BufferUnderflowException();
        model.adapter(index++).accept(getThis(), visitor, stream);
    }

    protected abstract R getThis();
}
