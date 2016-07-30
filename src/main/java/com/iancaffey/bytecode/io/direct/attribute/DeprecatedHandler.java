package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.AttributeVisitor;
import com.iancaffey.bytecode.io.direct.ClassVisitor;

import java.io.IOException;

/**
 * DeprecatedHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DeprecatedHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, AttributeVisitor visitor, int length) throws IOException {
        visitor.visitDeprecated();
    }
}
