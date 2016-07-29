package com.iancaffey.bytecode;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * StackMapTableVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
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
            public VerificationTypeHandler visitSingleStackItemFrame(int type) {
                return VerificationTypeHandler.of(visitors.map(visitor -> visitor.visitSingleStackItemFrame(type)));
            }

            @Override
            public VerificationTypeHandler visitSingleStackItemFrameExtended(int offset) {
                return VerificationTypeHandler.of(visitors.map(visitor -> visitor.visitSingleStackItemFrameExtended(offset)));
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
            public VerificationTypeHandler visitAppendFrame(int type, int offset, int count) {
                return VerificationTypeHandler.of(visitors.map(visitor -> visitor.visitAppendFrame(type, offset, count)));
            }

            @Override
            public FullFrameVisitor visitFullFrame(int offset) {
                return FullFrameVisitor.of(visitors.map(visitor -> visitor.visitFullFrame(offset)));
            }

            @Override
            public void end() {
                visitors.forEach(StackMapTableVisitor::end);
            }
        };
    }

    public void visitSameFrame(int type);

    public VerificationTypeHandler visitSingleStackItemFrame(int type);

    public VerificationTypeHandler visitSingleStackItemFrameExtended(int offset);

    public void visitChopFrame(int type, int offset);

    public void visitSameFrameExtended(int offset);

    public VerificationTypeHandler visitAppendFrame(int type, int offset, int count);

    public FullFrameVisitor visitFullFrame(int offset);
}
