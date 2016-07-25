package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.AttributeInfo;
import com.iancaffey.bytecode.FieldInfo;
import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * FieldsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldsHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    private final BytecodeHandler<ClassReader, ClassVisitor> handler;

    public FieldsHandler() {
        this.handler = new FieldInfoHandler();
    }

    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        int length = reader.readUnsignedShort();
        reader.model.fields = new FieldInfo[length];
        reader.model.fieldAttributeIndexes = new int[length];
        reader.model.fieldAttributes = new AttributeInfo[length][];
        for (reader.model.fieldsIndex = 0; reader.model.fieldsIndex < length; reader.model.fieldsIndex++)
            handler.accept(reader, visitor);
    }
}
