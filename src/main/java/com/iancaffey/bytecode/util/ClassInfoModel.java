package com.iancaffey.bytecode.util;

/**
 * ClassInfoModel
 * <p>
 * A representation of the layout of a class by providing the offsets for points of interest (constant pool entries, methods, fields, etc.).
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassInfoModel {
    public byte[] data;
    public int[] offsets;
    public int header;
}
