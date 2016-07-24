package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.BytecodeReader;
import com.iancaffey.bytecode.lang.BytecodeVisitor;

import java.io.IOException;

/**
 * BytecodeHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
@FunctionalInterface
public interface BytecodeHandler<R extends BytecodeReader, V extends BytecodeVisitor> {
    public void accept(R reader, V visitor) throws IOException;
}
