package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.io.info.ClassInfoHandler;
import com.iancaffey.bytecode.io.info.ClassVisitor;
import com.iancaffey.bytecode.util.Type;
import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassReader extends BytecodeReader<ClassVisitor> {
    public ClassReader(byte[] data) {
        super(data);
    }

    public ClassReader(byte[] data, int offset, int length) {
        super(data, offset, length);
    }

    public ClassReader(InputStream stream) throws IOException {
        super(stream);
    }

    public static ClassReader of(Class<?> c) throws IOException {
        return new ClassReader(ClassLoader.getSystemResourceAsStream(Type.getInternalForm(c) + ".class"));
    }

    @Override
    public void accept(ClassVisitor visitor) throws IOException {
        if (visitor == null)
            throw new IllegalArgumentException();
        ClassInfoHandler.accept(this, visitor);
    }
}
