package com.iancaffey.bytecode.lang;

import com.iancaffey.bytecode.attributes.VerificationTypeInfo;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * StackMapTableVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
//TODO:VerificationInfo and FullFrame visitors
public interface StackMapTableVisitor extends BytecodeVisitor {
    public static StackMapTableVisitor of(StackMapTableVisitor... visitors) {
        return StackMapTableVisitor.of(Arrays.stream(visitors));
    }

    public static StackMapTableVisitor of(Collection<StackMapTableVisitor> visitors) {
        return StackMapTableVisitor.of(visitors.stream());
    }

    public static StackMapTableVisitor of(Stream<StackMapTableVisitor> visitors) {
        return new StackMapTableVisitor() {
            @Override
            public void begin() {
                visitors.forEach(StackMapTableVisitor::begin);
            }

            @Override
            public void visitSameFrame(int type) {
                visitors.forEach(visitor -> visitor.visitSameFrame(type));
            }

            @Override
            public void visitSingleStackItemFrame(VerificationTypeInfo info) {
                visitors.forEach(visitor -> visitor.visitSingleStackItemFrame(info));
            }

            @Override
            public void visitSingleStackItemFrameExtended(int offset, VerificationTypeInfo info) {
                visitors.forEach(visitor -> visitor.visitSingleStackItemFrameExtended(offset, info));
            }

            @Override
            public void visitChopFrame(int type, int offset) {
                visitors.forEach(visitor -> visitor.visitChopFrame(type, offset));
            }

            @Override
            public void visitSameFrameExtended(int offset) {
                visitors.forEach(visitor -> visitor.visitSameFrameExtended(offset));
            }

            @Override
            public void visitAppendFrame(int type, int offset, VerificationTypeInfo[] info) {
                visitors.forEach(visitor -> visitor.visitAppendFrame(type, offset, info));
            }

            @Override
            public void visitFullFrame(int offset, VerificationTypeInfo[] localInfo, VerificationTypeInfo[] stackInfo) {
                visitors.forEach(visitor -> visitor.visitFullFrame(offset, localInfo, stackInfo));
            }

            @Override
            public void end() {
                visitors.forEach(StackMapTableVisitor::end);
            }
        };
    }

    public void visitSameFrame(int type);

    public void visitSingleStackItemFrame(VerificationTypeInfo info);

    public void visitSingleStackItemFrameExtended(int offset, VerificationTypeInfo info);

    public void visitChopFrame(int type, int offset);

    public void visitSameFrameExtended(int offset);

    public void visitAppendFrame(int type, int offset, VerificationTypeInfo[] info);

    public void visitFullFrame(int offset, VerificationTypeInfo[] localInfo, VerificationTypeInfo[] stackInfo);
}
