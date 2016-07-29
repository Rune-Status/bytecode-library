package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.TypeAnnotationVisitor;

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
        throw new UnsupportedOperationException();
    }
}
