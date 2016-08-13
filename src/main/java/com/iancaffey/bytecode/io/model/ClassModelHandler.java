package com.iancaffey.bytecode.io.model;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.util.ConstantPoolCache;

import java.io.IOException;

/**
 * ClassModelHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassModelHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, ClassModelVisitor visitor) throws IOException {
        ConstantPoolCache cache = new ConstantPoolCache();
        HeaderHandler.accept(reader, visitor, cache);
        FieldModelsHandler.accept(reader, visitor, cache);
        MethodModelsHandler.accept(reader, visitor, cache);
        AttributeModelsHandler.accept(reader, visitor, cache);
    }
}
