package com.iancaffey.bytecode.lang;

import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.util.Interval;

import java.io.IOException;
import java.util.Map;

/**
 * BytecodeController
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BytecodeController<R extends BytecodeReader, V extends BytecodeVisitor> {
    private final Interval[] intervals;
    private final Map<Interval, BytecodeHandler<R, V>> handlers;

    public BytecodeController(Interval[] intervals, Map<Interval, BytecodeHandler<R, V>> handlers) {
        this.intervals = intervals;
        this.handlers = handlers;
    }

    public boolean canRead(int index) {
        return index < intervals.length;
    }

    public void read(int index, R reader, V visitor) throws IOException {
        Interval interval = intervals[index];
        if (!handlers.containsKey(interval))
            throw new IllegalArgumentException("Unable to handle read from interval: " + interval);
        handlers.get(interval).accept(reader, visitor);
    }
}
