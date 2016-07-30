package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.direct.AttributeModelVisitor;

import java.io.IOException;

/**
 * SyntheticHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SyntheticHandler {
    public static void accept(AttributeModelVisitor visitor) throws IOException {
        visitor.visitSynthetic();
    }
}
