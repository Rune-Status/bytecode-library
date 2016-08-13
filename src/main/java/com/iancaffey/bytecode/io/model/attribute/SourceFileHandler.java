package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.model.AttributeModelVisitor;
import com.iancaffey.bytecode.io.model.ClassModelVisitor;

import java.io.IOException;

/**
 * SourceFileHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SourceFileHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor) throws IOException {
        visitor.visitSourceFile(reader.readUnsignedShort());
    }
}
