package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.BytecodeReader;
import com.iancaffey.bytecode.lang.ClassModel;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * MethodAttributeInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class MethodAttributeInfoHandler implements BytecodeHandler<BytecodeReader<ClassModel,ClassVisitor>, ClassVisitor> {
    @Override
    public void accept(BytecodeReader<ClassModel,ClassVisitor> reader, ClassVisitor visitor) throws IOException {
        reader.model.methodAttributes[reader.model.methodsIndex][reader.model.methodAttributeIndexes[reader.model.methodsIndex]] = AttributeReader.getInstance().read(reader);
    }
}
