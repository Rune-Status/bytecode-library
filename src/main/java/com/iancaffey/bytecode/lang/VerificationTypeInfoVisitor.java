package com.iancaffey.bytecode.lang;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * VerificationTypeInfoVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface VerificationTypeInfoVisitor extends BytecodeVisitor {
    public static VerificationTypeInfoVisitor of(VerificationTypeInfoVisitor... visitors) {
        return VerificationTypeInfoVisitor.of(Arrays.stream(visitors));
    }

    public static VerificationTypeInfoVisitor of(Collection<VerificationTypeInfoVisitor> visitors) {
        return VerificationTypeInfoVisitor.of(visitors.stream());
    }

    public static VerificationTypeInfoVisitor of(Stream<VerificationTypeInfoVisitor> visitors) {
        return new VerificationTypeInfoVisitor() {
            @Override
            public void begin() {
                visitors.forEach(VerificationTypeInfoVisitor::begin);
            }

            @Override
            public void end() {
                visitors.forEach(VerificationTypeInfoVisitor::end);
            }
        };
    }
}
