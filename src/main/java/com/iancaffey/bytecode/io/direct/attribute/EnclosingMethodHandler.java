package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.AttributeVisitor;
import com.iancaffey.bytecode.io.direct.ClassVisitor;

import java.io.IOException;

/**
 * EnclosingMethodHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class EnclosingMethodHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, AttributeVisitor visitor) throws IOException {
        visitor.visitEnclosingMethod(reader.readUnsignedShort(), reader.readUnsignedShort());
    }
}
