package com.iancaffey.bytecode;

import com.iancaffey.bytecode.io.*;
import com.iancaffey.bytecode.util.ConstantPoolCache;
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
    private final BytecodeHandler<ClassReader, ClassVisitor> handler = ClassReader.newHandler();

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

    public static BytecodeHandler<ClassReader, ClassVisitor> newHandler() {
        ConstantPoolCache cache = new ConstantPoolCache();
        BytecodeHandler<ClassReader, AttributeVisitor> handler = new AttributeInfoHandler(cache);
        return BytecodeHandler.of(new HeaderHandler(cache), new FieldsHandler(handler), new MethodsHandler(handler), new AttributesHandler(handler));
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
