package com.iancaffey.bytecode.io.model.attribute.annotation;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.model.AttributeModelVisitor;
import com.iancaffey.bytecode.io.model.ClassModelVisitor;
import com.iancaffey.bytecode.io.model.attribute.AnnotationHandler;
import com.iancaffey.bytecode.io.model.attribute.AnnotationVisitor;

import java.io.IOException;

/**
 * RuntimeVisibleAnnotationsHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class RuntimeVisibleAnnotationsHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        AnnotationVisitor attributeVisitor = visitor.visitRuntimeVisibleAnnotations(count);
        for (int i = 0; i < count; i++)
            AnnotationHandler.accept(reader, attributeVisitor);
    }
}
