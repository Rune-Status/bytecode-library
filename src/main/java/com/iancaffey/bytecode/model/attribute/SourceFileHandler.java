package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.model.AttributeModelVisitor;
import com.iancaffey.bytecode.model.ClassModelVisitor;

import java.io.IOException;

/**
 * SourceFileHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SourceFileHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor, int nameIndex, int length) throws IOException {
        visitor.visitSourceFile(nameIndex, length, reader.readUnsignedShort());
    }
}
