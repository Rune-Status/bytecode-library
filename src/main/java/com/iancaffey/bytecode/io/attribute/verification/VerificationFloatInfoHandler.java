package com.iancaffey.bytecode.io.attribute.verification;

import com.iancaffey.bytecode.BytecodeHandler;
import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.VerificationTypeHandler;

import java.io.IOException;

/**
 * VerificationFloatInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class VerificationFloatInfoHandler implements BytecodeHandler<ClassReader, VerificationTypeHandler> {
    @Override
    public void accept(ClassReader reader, VerificationTypeHandler visitor) throws IOException {
        visitor.visitFloat();
    }
}