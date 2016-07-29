package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.io.attribute.VerificationTypeVisitor;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * FullFrameVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface FullFrameVisitor extends BytecodeVisitor {
    public static FullFrameVisitor of(FullFrameVisitor... visitors) {
        return FullFrameVisitor.of(Arrays.stream(visitors));
    }

    public static FullFrameVisitor of(Collection<FullFrameVisitor> visitors) {
        return FullFrameVisitor.of(visitors.stream());
    }

    public static FullFrameVisitor of(Stream<FullFrameVisitor> visitors) {
        return new FullFrameVisitor() {
            @Override
            public void begin() {
                visitors.forEach(FullFrameVisitor::begin);
            }

            @Override
            public VerificationTypeVisitor visitLocals(int count) {
                return VerificationTypeVisitor.of(visitors.map(visitor -> visitor.visitLocals(count)));
            }

            @Override
            public VerificationTypeVisitor visitStack(int count) {
                return VerificationTypeVisitor.of(visitors.map(visitor -> visitor.visitStack(count)));
            }

            @Override
            public void end() {
                visitors.forEach(FullFrameVisitor::end);
            }
        };
    }

    public VerificationTypeVisitor visitLocals(int count);

    public VerificationTypeVisitor visitStack(int count);
}