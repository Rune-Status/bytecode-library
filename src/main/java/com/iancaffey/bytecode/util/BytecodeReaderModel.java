package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.util.Map;

/**
 * BytecodeReaderModel
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BytecodeReaderModel<R extends BytecodeReader<V>, V extends BytecodeVisitor, S extends BytecodeStep> {
    private final S[] steps;
    private final Map<S, BytecodeAdapter<R, V>> adapters;

    public BytecodeReaderModel(S[] steps, Map<S, BytecodeAdapter<R, V>> adapters) {
        this.steps = steps;
        this.adapters = adapters;
    }

    public int steps() {
        return steps.length;
    }

    public BytecodeAdapter<R, V> adapter(int index) {
        S step = steps[index];
        if (!adapters.containsKey(step))
            throw new IllegalArgumentException("Unable to move at step: " + step);
        return adapters.get(step);
    }
}
