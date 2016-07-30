package com.iancaffey.bytecode.io.fast;

import com.iancaffey.bytecode.io.BytecodeReader;

import java.io.IOException;

/**
 * ClassInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassInfoHandler {
    public static void accept(BytecodeReader<ClassInfoVisitor> reader, ClassInfoVisitor visitor) throws IOException {
        visitor.visitData(reader.buffer());

    }
}
