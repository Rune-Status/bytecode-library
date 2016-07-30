package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.ClassInfo;
import com.iancaffey.bytecode.io.direct.ClassModelHandler;
import com.iancaffey.bytecode.io.direct.ClassModelVisitor;
import com.iancaffey.bytecode.io.fast.ClassInfoHandler;
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

    public static BytecodeReader<ClassInfo> fast(Class<?> c) throws IOException {
        return new FastClassReader(ClassLoader.getSystemResourceAsStream(Type.getInternalForm(c) + ".class"));
    }

    public static BytecodeReader<ClassModelVisitor> direct(Class<?> c) throws IOException {
        return new DirectClassReader(ClassLoader.getSystemResourceAsStream(Type.getInternalForm(c) + ".class"));
    }

    public static class FastClassReader extends BytecodeReader<ClassInfo> {

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
        public ClassInfo accept(ClassInfo visitor) throws IOException {
            if (visitor == null)
                throw new IllegalArgumentException();
            ClassInfoHandler.accept(this, visitor);
            return visitor;
        }
    }

    public static class DirectClassReader extends BytecodeReader<ClassModelVisitor> {
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
        public ClassModelVisitor accept(ClassModelVisitor visitor) throws IOException {
            if (visitor == null)
                throw new IllegalArgumentException();
            ClassModelHandler.accept(this, visitor);
            return visitor;
        }
    }
}
