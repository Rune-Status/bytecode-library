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

    public BytecodeReader(byte[] data, BytecodeHandler<BytecodeReader<M, V>, V> handler) {
        this(data, BytecodeReader.singletonController(handler));
    }

    public BytecodeReader(byte[] data, BytecodeHandler<BytecodeReader<M, V>, V> handler, M model) {
        this(new ByteArrayInputStream(data), BytecodeReader.singletonController(handler), model);
    }

    public BytecodeReader(byte[] data, int offset, int length, BytecodeHandler<BytecodeReader<M, V>, V> handler) {
        this(data, offset, length, BytecodeReader.singletonController(handler));
    }

    public BytecodeReader(byte[] data, int offset, int length, BytecodeHandler<BytecodeReader<M, V>, V> handler, M model) {
        this(new ByteArrayInputStream(data, offset, length), BytecodeReader.singletonController(handler), model);
    }

    public BytecodeReader(InputStream stream, BytecodeHandler<BytecodeReader<M, V>, V> handler) {
        this(stream, BytecodeReader.singletonController(handler));
    }

    public BytecodeReader(InputStream stream, BytecodeHandler<BytecodeReader<M, V>, V> handler, M model) {
        this(stream, BytecodeReader.singletonController(handler), model);
    }

    public BytecodeReader(byte[] data, BytecodeController<BytecodeReader<M, V>, V> controller) {
        this(data, controller, null);
    }

    public BytecodeReader(byte[] data, BytecodeController<BytecodeReader<M, V>, V> controller, M model) {
        this(new ByteArrayInputStream(data), controller, model);
    }

    public BytecodeReader(byte[] data, int offset, int length, BytecodeController<BytecodeReader<M, V>, V> controller) {
        this(data, offset, length, controller, null);
    }

    public BytecodeReader(byte[] data, int offset, int length, BytecodeController<BytecodeReader<M, V>, V> controller, M model) {
        this(new ByteArrayInputStream(data, offset, length), controller, model);
    }

    public BytecodeReader(InputStream stream, BytecodeController<BytecodeReader<M, V>, V> controller) {
        this(stream, controller, null);
    }

    public BytecodeReader(InputStream stream, BytecodeController<BytecodeReader<M, V>, V> controller, M model) {
        super(stream);
        if (controller == null)
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
