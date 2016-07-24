package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeInfo;
import com.iancaffey.bytecode.MethodInfo;
import com.iancaffey.bytecode.util.BytecodeAdapter;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * MethodsAdapter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodsAdapter implements BytecodeAdapter<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor, DataInputStream stream) throws IOException {
        int length = stream.readUnsignedShort();
        reader.methods = new MethodInfo[length];
        reader.methodAttributeIndexes = new int[length];
        reader.methodAttributes = new AttributeInfo[length][];
        for (reader.methodsIndex = 0; reader.methodsIndex < length; reader.methodsIndex++)
            reader.model.methodAdapter().accept(reader, visitor, stream);
    }
}
