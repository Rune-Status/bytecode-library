package com.iancaffey.bytecode;

import com.iancaffey.bytecode.io.AttributesHandler;
import com.iancaffey.bytecode.io.FieldsHandler;
import com.iancaffey.bytecode.io.HeaderHandler;
import com.iancaffey.bytecode.io.MethodsHandler;
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
    private final BytecodeHandler<ClassReader, ClassVisitor> handler;

    public ClassReader(byte[] data) {
        super(data);
        ConstantPoolCache cache = new ConstantPoolCache();
        this.handler = BytecodeHandler.of(new HeaderHandler(cache), new FieldsHandler(cache), new MethodsHandler(cache), new AttributesHandler(cache));
    }

    public ClassReader(byte[] data, int offset, int length) {
        super(data, offset, length);
        ConstantPoolCache cache = new ConstantPoolCache();
        this.handler = BytecodeHandler.of(new HeaderHandler(cache), new FieldsHandler(cache), new MethodsHandler(cache), new AttributesHandler(cache));
    }

    public ClassReader(InputStream stream) {
        super(stream);
        ConstantPoolCache cache = new ConstantPoolCache();
        this.handler = BytecodeHandler.of(new HeaderHandler(cache), new FieldsHandler(cache), new MethodsHandler(cache), new AttributesHandler(cache));
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
