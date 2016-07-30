package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.AttributeVisitor;
import com.iancaffey.bytecode.io.direct.ClassVisitor;

import java.io.IOException;

/**
 * BootstrapMethodsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BootstrapMethodsHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, AttributeVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        BootstrapMethodVisitor bootstrapMethodVisitor = visitor.visitBootstrapMethods(count);
        for (int i = 0; i < count; i++)
            BootstrapMethodHandler.accept(reader, bootstrapMethodVisitor);
    }
}
