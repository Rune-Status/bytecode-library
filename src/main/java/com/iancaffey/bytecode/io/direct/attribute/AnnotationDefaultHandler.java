package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.AttributeVisitor;
import com.iancaffey.bytecode.io.direct.ClassVisitor;

import java.io.IOException;

/**
 * AnnotationDefaultHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class AnnotationDefaultHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, AttributeVisitor visitor) throws IOException {
        ElementValueHandler.accept(reader, visitor.visitAnnotationDefault());
    }
}
