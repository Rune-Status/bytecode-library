package com.iancaffey.bytecode.io.direct;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * FieldsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldsHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, ClassVisitor visitor, ConstantPoolCache cache) throws IOException {
        int count = reader.readUnsignedShort();
        FieldVisitor fieldVisitor = visitor.visitFields(count);
        for (int i = 0; i < count; i++) {
            int access = reader.readUnsignedShort();
            int nameIndex = reader.readUnsignedShort();
            int descriptorIndex = reader.readUnsignedShort();
            int attributeCount = reader.readUnsignedShort();
            fieldVisitor.visit(access, nameIndex, descriptorIndex);
            AttributeVisitor attributeVisitor = fieldVisitor.visitAttributes(attributeCount);
            for (int j = 0; j < attributeCount; j++)
                AttributeInfoHandler.accept(reader, attributeVisitor, cache);
        }
    }
}
