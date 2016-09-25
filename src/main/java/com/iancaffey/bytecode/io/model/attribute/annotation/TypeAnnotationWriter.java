package com.iancaffey.bytecode.io.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeWriter;
import com.iancaffey.bytecode.io.model.attribute.AnnotationVisitor;

import java.io.IOException;

/**
 * TypeAnnotationWriter
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class TypeAnnotationWriter extends BytecodeWriter implements TypeAnnotationVisitor {
    @Override
    public TypeTargetVisitor visitTarget() throws IOException {
        return null;
    }

    @Override
    public TypePathVisitor visitPath(int count) throws IOException {
        return null;
    }

    @Override
    public AnnotationVisitor visitAnnotation() throws IOException {
        return null;
    }
}
