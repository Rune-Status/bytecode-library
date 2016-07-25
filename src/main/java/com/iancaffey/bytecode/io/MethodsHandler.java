package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeInfo;
import com.iancaffey.bytecode.MethodInfo;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * MethodsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodsHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    private final BytecodeHandler<ClassReader, ClassVisitor> handler;

    public MethodsHandler() {
        this.handler = new MethodInfoHandler();
    }

    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        int length = reader.readUnsignedShort();
        reader.model.methods = new MethodInfo[length];
        reader.model.methodAttributeIndexes = new int[length];
        reader.model.methodAttributes = new AttributeInfo[length][];
        for (reader.model.methodsIndex = 0; reader.model.methodsIndex < length; reader.model.methodsIndex++)
            handler.accept(reader, visitor);
    }
}
