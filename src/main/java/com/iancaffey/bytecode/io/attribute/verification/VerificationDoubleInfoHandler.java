package com.iancaffey.bytecode.io.attribute.verification;

import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.VerificationTypeHandler;

import java.io.IOException;

/**
 * VerificationDoubleInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class VerificationDoubleInfoHandler implements BytecodeHandler<ClassReader, VerificationTypeHandler> {
    @Override
    public void accept(ClassReader reader, VerificationTypeHandler visitor) throws IOException {
        visitor.visitDouble();
    }
}