package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.io.AttributeVisitor;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * SignatureHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SignatureHandler implements AttributeHandler {
    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        visitor.visitSignature(reader.readUnsignedShort());
    }
}
