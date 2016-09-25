package com.iancaffey.bytecode.util;

/**
 * ConstantPoolCache
 * <p>
 * A representation of all constant pool UTF8Info strings required for parsing attributes.
 * Shared between all default ClassInfoReader BytecodeHandler.
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ConstantPoolCache {
    public int index;
    public String[] strings;
}
