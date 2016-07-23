package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.util.BytecodeAdapter;
import com.iancaffey.bytecode.util.TokenReaderModel;
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
    private static TokenReaderModel<ClassInfoToken, ClassVisitor> infoModel;

    public ClassReader(byte[] b) {
        super(b, ClassReader.infoModel());
    }

    public ClassReader(byte[] b, int offset, int length) {
        super(b, offset, length, ClassReader.infoModel());
    }

    public ClassReader(InputStream stream) {
        super(stream, ClassReader.infoModel());
    }

    public ClassReader(DataInputStream stream) {
        super(stream, ClassReader.infoModel());
    }

    public static ClassReader of(Class<?> c) {
        return new ClassReader(ClassLoader.getSystemResourceAsStream(Type.getTypeIdentifier(c) + ".class"));
    }

    public static synchronized TokenReaderModel<ClassInfoToken, ClassVisitor> infoModel() {
        if (infoModel == null) {
            Map<ClassInfoToken, BytecodeAdapter<ClassVisitor>> consumers = new HashMap<>();
            consumers.put(ClassInfoToken.MAGIC, (visitor, stream) -> {
                visitor.begin();
                visitor.visitMagic(stream.readInt());
            });
            consumers.put(ClassInfoToken.VERSION, (visitor, stream) -> {
                int minor = stream.readUnsignedShort();
                int major = stream.readUnsignedShort();
                visitor.visitVersion(major, minor);
            });
            infoModel = new TokenReaderModel<>(ClassInfoToken.values(), consumers);
        }
        return infoModel;
    }
}
