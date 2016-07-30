package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.AttributeVisitor;
import com.iancaffey.bytecode.io.direct.ClassVisitor;

import java.io.IOException;

/**
 * SourceFileHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SourceFileHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, AttributeVisitor visitor) throws IOException {
        visitor.visitSourceFile(reader.readUnsignedShort());
    }
}
