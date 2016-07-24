package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeInfo;
import com.iancaffey.bytecode.FieldInfo;
import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * FieldsAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldsAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        int length = stream.readUnsignedShort();
        reader.fields = new FieldInfo[length];
        reader.fieldAttributeIndexes = new int[length];
        reader.fieldAttributes = new AttributeInfo[length][];
        for (reader.fieldsIndex = 0; reader.fieldsIndex < length; reader.fieldsIndex++)
            reader.model.fieldAdapter().accept(reader, visitor, stream);
    }
}
