package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeVisitor;

/**
 * FullFrameVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface FullFrameVisitor extends BytecodeVisitor {
    public VerificationTypeVisitor visitLocals(int count);

    public VerificationTypeVisitor visitStack(int count);
}
