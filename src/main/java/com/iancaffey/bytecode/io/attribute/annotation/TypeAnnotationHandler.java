package com.iancaffey.bytecode.io.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.io.attribute.AnnotationVisitor;

import java.io.IOException;

/**
 * TypeAnnotationHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class TypeAnnotationHandler implements BytecodeHandler<ClassReader, TypeAnnotationVisitor> {
    @Override
    public void accept(ClassReader reader, TypeAnnotationVisitor visitor) throws IOException {
        int tag = reader.readUnsignedByte();
        if (true)
            throw new UnsupportedOperationException();
        //read target
        TypePathVisitor typePathVisitor = visitor.visitPath(reader.readUnsignedByte());
        typePathVisitor.begin();
        typePathVisitor.end();
        AnnotationVisitor annotationVisitor = visitor.visitAnnotation();
        annotationVisitor.begin();
        annotationVisitor.end();
    }
}
