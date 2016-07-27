package com.iancaffey.bytecode.lang;

import com.iancaffey.bytecode.io.AttributesHandler;
import com.iancaffey.bytecode.io.FieldsHandler;
import com.iancaffey.bytecode.io.HeaderHandler;
import com.iancaffey.bytecode.io.MethodsHandler;
import com.iancaffey.bytecode.util.Type;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassReader
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassReader extends BytecodeReader<ClassVisitor> {
    private final BytecodeHandler<ClassReader, ClassVisitor> handler = BytecodeHandler.of(new HeaderHandler(), new FieldsHandler(), new MethodsHandler(), new AttributesHandler());

    public ClassReader(byte[] data) {
        super(data);
    }

    public ClassReader(byte[] data, int offset, int length) {
        super(data, offset, length);
    }

    public ClassReader(InputStream stream) {
        super(stream);
    }

    public static ClassReader of(Class<?> c) {
        return new ClassReader(ClassLoader.getSystemResourceAsStream(Type.getInternalForm(c) + ".class"));
    }

    @Override
    public ClassReader accept(ClassVisitor visitor) throws IOException {
        if (visitor == null)
            return this;
        visitor.begin();
        handler.accept(this, visitor);
        visitor.end();
        return this;
    }
}
