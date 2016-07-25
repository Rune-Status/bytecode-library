package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * Code
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class Code extends AttributeInfo {
    private final int stackDepthLimit;
    private final int localCountLimit;
    private final byte[] data;
    private final ExceptionHandler[] exceptions;
    private final AttributeInfo[] attributes;

    public Code(String name, int infoLength, int stackDepthLimit, int localCountLimit, byte[] data, ExceptionHandler[] exceptions, AttributeInfo... attributes) {
        super(name, infoLength);
        this.stackDepthLimit = stackDepthLimit;
        this.localCountLimit = localCountLimit;
        this.data = data;
        this.exceptions = exceptions;
        this.attributes = attributes;
    }

    public int stackDepthLimit() {
        return stackDepthLimit;
    }

    public int localCountLimit() {
        return localCountLimit;
    }

    public int dataCount() {
        return data.length;
    }

    public byte data(int index) {
        return data[index];
    }

    public int exceptionCount() {
        return exceptions.length;
    }

    public ExceptionHandler exceptionTable(int index) {
        return exceptions[index];
    }

    public int attributeCount() {
        return attributes.length;
    }

    public AttributeInfo attributeInfo(int index) {
        return attributes[index];
    }
}
