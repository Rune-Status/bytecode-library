package com.iancaffey.bytecode.model;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * AttributeModelsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AttributeModelsHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, ClassModelVisitor visitor, ConstantPoolCache cache) throws IOException {
        int count = reader.readUnsignedShort();
        AttributeModelVisitor attributeVisitor = visitor.visitAttributes(count);
        for (int i = 0; i < count; i++)
            AttributeInfoHandler.accept(reader, attributeVisitor, cache);
    }
}
