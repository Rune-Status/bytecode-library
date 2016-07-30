package com.iancaffey.bytecode.io.direct.attribute.target;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.ClassModelVisitor;
import com.iancaffey.bytecode.io.direct.attribute.annotation.TypeTargetVisitor;

import java.io.IOException;

/**
 * TypeParameterBoundHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class TypeParameterBoundHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, TypeTargetVisitor visitor) throws IOException {
        visitor.visitTypeParameterBound(reader.readUnsignedByte(), reader.readUnsignedByte());
    }
}
