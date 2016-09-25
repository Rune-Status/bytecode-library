package com.iancaffey.bytecode.io.model;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.util.Type;
import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassModelReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassModelReader extends BytecodeReader<ClassModelVisitor> {
    public ClassModelReader(byte[] data) {
        super(data);
    }

    public ClassModelReader(byte[] data, int offset, int length) {
        super(data, offset, length);
    }

    public ClassModelReader(InputStream stream) throws IOException {
        super(stream);
    }

    public static ClassModelReader of(Class<?> c) throws IOException {
        return new ClassModelReader(ClassLoader.getSystemResourceAsStream(Type.getInternalForm(c) + ".class"));
    }

    @Override
    public void accept(ClassModelVisitor visitor) throws IOException {
        if (visitor == null)
            throw new IllegalArgumentException();
        ClassModelHandler.accept(this, visitor);
    }
}
