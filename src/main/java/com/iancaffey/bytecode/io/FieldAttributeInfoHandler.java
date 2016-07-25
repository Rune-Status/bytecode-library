package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * FieldAttributeInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FieldAttributeInfoHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        reader.model.fieldAttributes[reader.model.fieldsIndex][reader.model.fieldAttributeIndexes[reader.model.fieldsIndex]] = AttributeReader.getInstance().read(reader);
    }
}
