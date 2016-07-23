package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * SourceDebugExtension
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class SourceDebugExtension extends AttributeInfo {
    private final String info; //size restricted as core implementation uses byte[]

    public SourceDebugExtension(int nameIndex, int infoLength, String info) {
        super(nameIndex, infoLength);
        this.info = info;
    }

    public String info() {
        return info;
    }
}
