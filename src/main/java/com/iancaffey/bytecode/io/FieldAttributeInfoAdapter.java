package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * FieldAttributeInfoAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldAttributeInfoAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        reader.fieldAttributes[reader.fieldsIndex][reader.fieldAttributeIndexes[reader.fieldsIndex]] = AttributeReader.getInstance().read(reader, stream);
    }
}
