package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.model.AttributeModelVisitor;

import java.io.IOException;

/**
 * DeprecatedHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DeprecatedHandler {
    public static void accept(AttributeModelVisitor visitor, int nameIndex, int length) throws IOException {
        visitor.visitDeprecated(nameIndex, length);
    }
}
