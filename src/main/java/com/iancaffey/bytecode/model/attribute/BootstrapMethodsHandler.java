package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.model.AttributeModelVisitor;
import com.iancaffey.bytecode.model.ClassModelVisitor;

import java.io.IOException;

/**
 * BootstrapMethodsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class BootstrapMethodsHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor, int nameIndex, int length) throws IOException {
        int count = reader.readUnsignedShort();
        BootstrapMethodVisitor bootstrapMethodVisitor = visitor.visitBootstrapMethods(nameIndex, length, count);
        for (int i = 0; i < count; i++)
            BootstrapMethodHandler.accept(reader, bootstrapMethodVisitor);
    }
}
