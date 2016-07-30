package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.ClassVisitor;

import java.io.IOException;

/**
 * AnnotationHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AnnotationHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, AnnotationVisitor visitor) throws IOException {
        int index = reader.readUnsignedShort();
        int count = reader.readUnsignedShort();
        ElementValuePairVisitor elementValueVisitor = visitor.visit(index, count);
        for (int i = 0; i < count; i++)
            ElementValueHandler.accept(reader, elementValueVisitor.visit(reader.readUnsignedShort()));
    }
}
