package com.iancaffey.bytecode.io.direct.attribute.target;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.ClassVisitor;
import com.iancaffey.bytecode.io.direct.attribute.annotation.TypeTargetVisitor;

import java.io.IOException;

/**
 * CatchHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class CatchHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, TypeTargetVisitor visitor) throws IOException {
        visitor.visitCatch(reader.readUnsignedShort());
    }
}
