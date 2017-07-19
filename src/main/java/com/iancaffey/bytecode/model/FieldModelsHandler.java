package com.iancaffey.bytecode.model;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * FieldModelsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldModelsHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, ClassModelVisitor visitor, ConstantPoolCache cache) throws IOException {
        int count = reader.readUnsignedShort();
        FieldModelVisitor fieldVisitor = visitor.visitFields(count);
        for (int i = 0; i < count; i++) {
            int access = reader.readUnsignedShort();
            int nameIndex = reader.readUnsignedShort();
            int descriptorIndex = reader.readUnsignedShort();
            int attributeCount = reader.readUnsignedShort();
            fieldVisitor.visit(access, nameIndex, descriptorIndex);
            AttributeModelVisitor attributeVisitor = fieldVisitor.visitAttributes(attributeCount);
            for (int j = 0; j < attributeCount; j++) {
                AttributeInfoHandler.accept(reader, attributeVisitor, cache);
            }
        }
    }
}
