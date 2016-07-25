package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * MethodAttributeInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodAttributeInfoHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        reader.model.methodAttributes[reader.model.methodsIndex][reader.model.methodAttributeIndexes[reader.model.methodsIndex]] = AttributeReader.getInstance().read(reader);
    }
}
