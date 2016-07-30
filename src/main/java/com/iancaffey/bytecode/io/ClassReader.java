package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.io.direct.ClassHandler;
import com.iancaffey.bytecode.io.direct.ClassVisitor;
import com.iancaffey.bytecode.io.fast.ClassInfoHandler;
import com.iancaffey.bytecode.io.fast.ClassInfoVisitor;
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
public class ClassReader {
    private ClassReader() {
    }

    public static BytecodeReader<ClassInfoVisitor> fast(Class<?> c) throws IOException {
        return new FastClassReader(ClassLoader.getSystemResourceAsStream(Type.getInternalForm(c) + ".class"));
    }

    public static BytecodeReader<ClassVisitor> direct(Class<?> c) throws IOException {
        return new DirectClassReader(ClassLoader.getSystemResourceAsStream(Type.getInternalForm(c) + ".class"));
    }

    public static class FastClassReader extends BytecodeReader<ClassInfoVisitor> {

        public FastClassReader(byte[] data) {
            super(data);
        }

        public FastClassReader(byte[] data, int offset, int length) {
            super(data, offset, length);
        }

        public FastClassReader(InputStream stream) throws IOException {
            super(stream);
        }

        @Override
        public BytecodeReader<ClassInfoVisitor> accept(ClassInfoVisitor visitor) throws IOException {
            if (visitor == null)
                return this;
            ClassInfoHandler.accept(this, visitor);
            return this;
        }
    }

    public static class DirectClassReader extends BytecodeReader<ClassVisitor> {
        public DirectClassReader(byte[] data) {
            super(data);
        }

        public DirectClassReader(byte[] data, int offset, int length) {
            super(data, offset, length);
        }

        public DirectClassReader(InputStream stream) throws IOException {
            super(stream);
        }

        @Override
        public DirectClassReader accept(ClassVisitor visitor) throws IOException {
            if (visitor == null)
                return this;
            ClassHandler.accept(this, visitor);
            return this;
        }
    }
}
