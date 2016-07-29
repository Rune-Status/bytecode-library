package com.iancaffey.bytecode.util;

import com.iancaffey.bytecode.ClassReader;
import com.iancaffey.bytecode.io.AttributeVisitor;

import java.io.IOException;

/**
 * AttributeHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public interface AttributeHandler {
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException;
}
