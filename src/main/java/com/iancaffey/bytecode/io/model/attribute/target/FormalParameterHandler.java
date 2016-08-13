package com.iancaffey.bytecode.io.model.attribute.target;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.model.ClassModelVisitor;
import com.iancaffey.bytecode.io.model.attribute.annotation.TypeTargetVisitor;

import java.io.IOException;

/**
 * FormalParameterHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class FormalParameterHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, TypeTargetVisitor visitor) throws IOException {
        visitor.visitFormalParameter(reader.readUnsignedByte());
    }
}
