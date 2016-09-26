package com.iancaffey.bytecode.model;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * MethodModelsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodModelsHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, ClassModelVisitor visitor, ConstantPoolCache cache) throws IOException {
        int count = reader.readUnsignedShort();
        MethodModelVisitor methodVisitor = visitor.visitMethods(count);
        for (int i = 0; i < count; i++) {
            int access = reader.readUnsignedShort();
            int nameIndex = reader.readUnsignedShort();
            int descriptorIndex = reader.readUnsignedShort();
            methodVisitor.visit(access, nameIndex, descriptorIndex);
            int attributeCount = reader.readUnsignedShort();
            AttributeModelVisitor attributeVisitor = methodVisitor.visitAttributes(attributeCount);
            for (int j = 0; j < attributeCount; j++)
                AttributeInfoHandler.accept(reader, attributeVisitor, cache);
        }
    }
}
