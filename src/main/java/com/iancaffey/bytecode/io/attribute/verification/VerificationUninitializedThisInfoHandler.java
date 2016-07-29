package com.iancaffey.bytecode.io.attribute.verification;

import com.iancaffey.bytecode.io.BytecodeHandler;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.io.attribute.VerificationTypeVisitor;

import java.io.IOException;

/**
 * VerificationUninitializedThisInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class VerificationUninitializedThisInfoHandler implements BytecodeHandler<ClassReader, VerificationTypeVisitor> {
    @Override
    public void accept(ClassReader reader, VerificationTypeVisitor visitor) throws IOException {
        visitor.visitUninitializedThis();
    }
}