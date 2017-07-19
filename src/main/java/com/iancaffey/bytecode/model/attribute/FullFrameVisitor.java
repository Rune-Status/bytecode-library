package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

import java.io.IOException;

/**
 * FullFrameVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface FullFrameVisitor extends BytecodeVisitor {
    VerificationTypeVisitor visitLocals(int count) throws IOException;

    VerificationTypeVisitor visitStack(int count) throws IOException;
}
