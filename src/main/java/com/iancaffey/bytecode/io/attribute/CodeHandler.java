package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;
import java.nio.BufferUnderflowException;

/**
 * CodeHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class CodeHandler implements AttributeHandler {
    private final BytecodeHandler<ClassReader, AttributeVisitor> handler;

    public CodeHandler(BytecodeHandler<ClassReader, AttributeVisitor> handler) {
        this.handler = handler;
    }

    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        CodeVisitor codeVisitor = visitor.visitCode();
        codeVisitor.begin();
        int maxStack = reader.readUnsignedShort();
        int maxLocals = reader.readUnsignedShort();
        codeVisitor.visitDepth(maxStack, maxLocals);
        int codeLength = reader.readInt();
        byte[] code = new byte[codeLength];
        int read = reader.read(code);
        if (read != codeLength)
            throw new BufferUnderflowException();
        codeVisitor.visitData(code);
        int exceptionCount = reader.readUnsignedShort();
        ExceptionVisitor exceptionVisitor = codeVisitor.visitExceptionTable(exceptionCount);
        for (int i = 0; i < exceptionCount; i++) {
            int startIndex = reader.readUnsignedShort();
            int endIndex = reader.readUnsignedShort();
            int handlerIndex = reader.readUnsignedShort();
            int catchIndex = reader.readUnsignedShort();
            exceptionVisitor.visit(startIndex, endIndex, handlerIndex, catchIndex);
        }
        int attributeCount = reader.readUnsignedShort();
        AttributeVisitor attributeVisitor = codeVisitor.visitAttributes(attributeCount);
        for (int i = 0; i < attributeCount; i++)
            handler.accept(reader, attributeVisitor);
        codeVisitor.end();
    }
}
