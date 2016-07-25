package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.ClassVisitor;

import java.io.IOException;

/**
 * AttributeInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AttributeInfoHandler implements BytecodeHandler<ClassReader, ClassVisitor> {
    @Override
    public void accept(ClassReader reader, ClassVisitor visitor) throws IOException {
        reader.model.attributes[reader.model.attributesIndex] = AttributeReader.getInstance().read(reader);
    }
}