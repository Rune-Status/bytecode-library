package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.AttributeVisitor;
import com.iancaffey.bytecode.BootstrapMethodVisitor;
import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * BootstrapMethodsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BootstrapMethodsHandler implements AttributeHandler {
    private final BytecodeHandler<ClassReader, BootstrapMethodVisitor> handler;

    public BootstrapMethodsHandler() {
        this.handler = new BootstrapMethodHandler();
    }

    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        int count = reader.readUnsignedShort();
        BootstrapMethodVisitor bootstrapMethodVisitor = visitor.visitBootstrapMethods(count);
        bootstrapMethodVisitor.begin();
        for (int i = 0; i < count; i++)
            handler.accept(reader, bootstrapMethodVisitor);
        bootstrapMethodVisitor.end();
    }
}
