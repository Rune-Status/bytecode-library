package com.iancaffey.bytecode.io.info;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.util.Type;
import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassInfoReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassInfoReader extends BytecodeReader<ClassInfoVisitor> {
    public ClassInfoReader(byte[] data) {
        super(data);
    }

    public ClassInfoReader(byte[] data, int offset, int length) {
        super(data, offset, length);
    }

    public ClassInfoReader(InputStream stream) throws IOException {
        super(stream);
    }

    public static ClassInfoReader of(Class<?> c) throws IOException {
        return new ClassInfoReader(ClassLoader.getSystemResourceAsStream(Type.getInternalForm(c) + ".class"));
    }

    @Override
    public void accept(ClassInfoVisitor visitor) throws IOException {
        if (visitor == null)
            throw new IllegalArgumentException();
        ClassInfoHandler.accept(this, visitor);
    }
}
