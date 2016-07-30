package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.AttributeInfoHandler;
import com.iancaffey.bytecode.io.direct.AttributeVisitor;
import com.iancaffey.bytecode.io.direct.ClassVisitor;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;
import java.nio.BufferUnderflowException;

/**
 * CodeHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class CodeHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, AttributeVisitor visitor, ConstantPoolCache cache) throws IOException {
        CodeVisitor codeVisitor = visitor.visitCode();
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
            AttributeInfoHandler.accept(reader, attributeVisitor, cache);
    }
}
