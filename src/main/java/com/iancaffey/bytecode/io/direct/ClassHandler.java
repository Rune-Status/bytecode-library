package com.iancaffey.bytecode.io.direct;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * ClassHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, ClassVisitor visitor) throws IOException {
        ConstantPoolCache cache = new ConstantPoolCache();
        HeaderHandler.accept(reader, visitor, cache);
        FieldsHandler.accept(reader, visitor, cache);
        MethodsHandler.accept(reader, visitor, cache);
        AttributesHandler.accept(reader, visitor, cache);
    }
}
