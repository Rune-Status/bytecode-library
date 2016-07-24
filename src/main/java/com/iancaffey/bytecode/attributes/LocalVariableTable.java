package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * LocalVariableTable
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableTable extends AttributeInfo {
    private final LocalVariableInfo[] info;

    public LocalVariableTable(int nameIndex, int infoLength, LocalVariableInfo... info) {
        super(nameIndex, infoLength);
        this.info = info;
    }

    public int variableCount() {
        return info.length;
    }

    public LocalVariableInfo variableInfo(int index) {
        return info[index];
    }
}
