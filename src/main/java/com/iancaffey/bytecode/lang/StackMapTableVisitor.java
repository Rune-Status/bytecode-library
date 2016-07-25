package com.iancaffey.bytecode.lang;

import com.iancaffey.bytecode.attributes.VerificationTypeInfo;

/**
 * StackMapTableVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface StackMapTableVisitor extends BytecodeVisitor {
    public void visitSameFrame(int type);

    public void visitSingleStackItemFrame(VerificationTypeInfo info);

    public void visitSingleStackItemFrameExtended(int offset, VerificationTypeInfo info);

    public void visitChopFrame(int type, int offset);

    public void visitSameFrameExtended(int offset);

    public void visitAppendFrame(int type, int offset, VerificationTypeInfo[] info);

    public void visitFullFrame(int offset, VerificationTypeInfo[] localInfo, VerificationTypeInfo[] stackInfo);
}
