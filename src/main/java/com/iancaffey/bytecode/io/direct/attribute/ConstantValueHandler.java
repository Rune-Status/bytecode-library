package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.AttributeVisitor;
import com.iancaffey.bytecode.io.direct.ClassVisitor;

import java.io.IOException;

/**
 * ConstantValueHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ConstantValueHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, AttributeVisitor visitor, int length) throws IOException {
        visitor.visitConstantValue(reader.readUnsignedShort());
    }
}
