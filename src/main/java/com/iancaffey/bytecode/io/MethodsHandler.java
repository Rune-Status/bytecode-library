package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.ClassVisitor;
import com.iancaffey.bytecode.MethodVisitor;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * MethodsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodsHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    private final BytecodeHandler<ClassReader, MethodVisitor> handler;

    public MethodsHandler(ConstantPoolCache cache) {
        this.handler = new MethodInfoHandler(cache);
    }

    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        MethodVisitor methodVisitor = visitor.visitMethods(count);
        methodVisitor.begin();
        for (int i = 0; i < count; i++)
            handler.accept(reader, methodVisitor);
        methodVisitor.end();
    }
}
