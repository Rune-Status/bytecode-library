package com.iancaffey.bytecode.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeVisitor;
import com.iancaffey.bytecode.model.attribute.AnnotationVisitor;

import java.io.IOException;

/**
 * TypeAnnotationVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface TypeAnnotationVisitor extends BytecodeVisitor {
    TypeTargetVisitor visitTarget() throws IOException;

    TypePathVisitor visitPath(int length) throws IOException;

    AnnotationVisitor visitAnnotation() throws IOException;
}
