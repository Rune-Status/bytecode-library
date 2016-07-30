package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.direct.AttributeVisitor;

import java.io.IOException;

/**
 * SyntheticHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SyntheticHandler {
    public static void accept(AttributeVisitor visitor) throws IOException {
        visitor.visitSynthetic();
    }
}
