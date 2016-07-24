package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeInfo;
import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * AttributesAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AttributesAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        int length = stream.readUnsignedShort();
        reader.attributes = new AttributeInfo[length];
        for (reader.attributesIndex = 0; reader.attributesIndex < length; reader.attributesIndex++)
            reader.model.attributeAdapter().accept(reader, visitor, stream);
    }
}
