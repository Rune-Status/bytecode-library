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
public class AttributesHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, ClassVisitor visitor, ConstantPoolCache cache) throws IOException {
        int count = reader.readUnsignedShort();
        AttributeVisitor attributeVisitor = visitor.visitAttributes(count);
        for (int i = 0; i < count; i++)
            AttributeInfoHandler.accept(reader, attributeVisitor, cache);
    }
}
