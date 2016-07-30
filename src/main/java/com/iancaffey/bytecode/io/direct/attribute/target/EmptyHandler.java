package com.iancaffey.bytecode.io.direct.attribute.target;

import com.iancaffey.bytecode.io.direct.attribute.annotation.TypeTargetVisitor;

import java.io.IOException;

/**
 * EmptyHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class EmptyHandler {
    public static void accept(TypeTargetVisitor visitor) throws IOException {
        visitor.visitEmpty();
    }
}
