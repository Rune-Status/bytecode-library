package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.model.AttributeInfoHandler;
import com.iancaffey.bytecode.io.model.AttributeModelVisitor;
import com.iancaffey.bytecode.io.model.ClassModelVisitor;
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
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor, ConstantPoolCache cache, int nameIndex, int length) throws IOException {
        CodeVisitor codeVisitor = visitor.visitCode(nameIndex, length);
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
        AttributeModelVisitor attributeVisitor = codeVisitor.visitAttributes(attributeCount);
        for (int i = 0; i < attributeCount; i++)
            AttributeInfoHandler.accept(reader, attributeVisitor, cache);
    }
}
