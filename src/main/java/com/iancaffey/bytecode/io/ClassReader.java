package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.util.BytecodeConsumer;
import com.iancaffey.bytecode.util.Type;
import com.iancaffey.bytecode.util.token.ClassInfoToken;
import com.sun.org.apache.bcel.internal.util.ClassLoader;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassReader extends SequentialBytecodeReader<ClassInfoToken, ClassVisitor> {
    private static Map<ClassInfoToken, BytecodeConsumer<ClassVisitor, DataInputStream>> consumers;

    public ClassReader(byte[] b) {
        super(b, ClassInfoToken.values(), consumers());
    }

    public ClassReader(byte[] b, int offset, int length) {
        super(b, offset, length, ClassInfoToken.values(), consumers());
    }

    public ClassReader(InputStream stream) {
        super(stream, ClassInfoToken.values(), consumers());
    }

    public ClassReader(DataInputStream stream) {
        super(stream, ClassInfoToken.values(), consumers());
    }

    public static ClassReader of(Class<?> c) {
        return new ClassReader(ClassLoader.getSystemResourceAsStream(Type.getTypeIdentifier(c) + ".class"));
    }

    private static synchronized Map<ClassInfoToken, BytecodeConsumer<ClassVisitor, DataInputStream>> consumers() {
        if (consumers == null) {
            consumers = new HashMap<>();
            consumers.put(ClassInfoToken.MAGIC, (visitor, stream) -> {
                visitor.begin();
                visitor.visitMagic(stream.readInt());
            });
            consumers.put(ClassInfoToken.VERSION, (visitor, stream) -> {
                int minor = stream.readUnsignedShort();
                int major = stream.readUnsignedShort();
                visitor.visitVersion(major, minor);
            });
        }
        return consumers;
    }
}
