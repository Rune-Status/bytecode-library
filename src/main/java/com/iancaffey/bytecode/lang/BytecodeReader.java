package com.iancaffey.bytecode.lang;

import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.util.Interval;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.util.Collections;

/**
 * BytecodeReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BytecodeReader<M extends BytecodeModel, V extends BytecodeVisitor> extends DataInputStream {
    public final M model;
    private final BytecodeController<BytecodeReader<M, V>, V> controller;
    private int index;

    public BytecodeReader(byte[] data, BytecodeController<BytecodeReader<M, V>, V> controller, M model) {
        this(new ByteArrayInputStream(data), controller, model);
    }

    public BytecodeReader(byte[] data, int offset, int length, BytecodeController<BytecodeReader<M, V>, V> controller, M model) {
        this(new ByteArrayInputStream(data, offset, length), controller, model);
    }

    public BytecodeReader(InputStream stream, BytecodeController<BytecodeReader<M, V>, V> controller, M model) {
        super(stream);
        if (controller == null || model == null)
            throw new IllegalArgumentException();
        this.controller = controller;
        this.model = model;
        this.index = 0;
    }

    public static <R extends BytecodeReader, V extends BytecodeVisitor> BytecodeController<R, V> singletonController(BytecodeHandler<R, V> handler) {
        return new BytecodeController<>(new Interval[]{null}, Collections.singletonMap(null, handler));
    }

    public void accept(V visitor) throws IOException {
        if (visitor == null)
            throw new IllegalArgumentException();
        if (!controller.canRead(index))
            throw new BufferUnderflowException();
        visitor.begin();
        while (controller.canRead(index))
            controller.read(index++, this, visitor);
        visitor.end();
    }
}
