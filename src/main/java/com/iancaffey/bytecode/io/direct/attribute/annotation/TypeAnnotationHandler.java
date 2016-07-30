package com.iancaffey.bytecode.io.direct.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.ClassVisitor;
import com.iancaffey.bytecode.io.direct.attribute.AnnotationVisitor;

import java.io.IOException;

/**
 * TypeAnnotationHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class TypeAnnotationHandler {
    public static void accept(BytecodeReader<ClassVisitor> reader, TypeAnnotationVisitor visitor) throws IOException {
        int tag = reader.readUnsignedByte();
        if (true)
            throw new UnsupportedOperationException();
        //read target
        TypePathVisitor typePathVisitor = visitor.visitPath(reader.readUnsignedByte());
        AnnotationVisitor annotationVisitor = visitor.visitAnnotation();
    }
}
