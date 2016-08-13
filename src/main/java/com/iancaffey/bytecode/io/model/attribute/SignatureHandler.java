package com.iancaffey.bytecode.io.model.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.model.AttributeModelVisitor;
import com.iancaffey.bytecode.io.model.ClassModelVisitor;

import java.io.IOException;

/**
 * SignatureHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SignatureHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor) throws IOException {
        visitor.visitSignature(reader.readUnsignedShort());
    }
}
