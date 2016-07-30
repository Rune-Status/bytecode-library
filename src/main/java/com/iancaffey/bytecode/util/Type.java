package com.iancaffey.bytecode.util;

/**
 * Type
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Type {
    public static String getInternalForm(Class<?> c) {
        if (c == null)
            throw new IllegalArgumentException();
        return c.getName().replace('.', '/');
    }
}
