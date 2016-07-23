package com.iancaffey.bytecode.attributes;

/**
 * ElementValue
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ElementValue {
    public static final int BYTE = 'B';
    public static final int CHARACTER = 'C';
    public static final int DOUBLE = 'D';
    public static final int FLOAT = 'F';
    public static final int INTEGER = 'I';
    public static final int LONG = 'J';
    public static final int SHORT = 'S';
    public static final int BOOLEAN = 'Z';
    public static final int STRING = 's';
    public static final int ENUM = 'e';
    public static final int CLASS = 'c';
    public static final int ANNOTATION = '@';
    public static final int ARRAY = '[';
    private final int tag;

    public ElementValue(int tag) {
        this.tag = tag;
    }

    public int tag() {
        return tag;
    }
}
