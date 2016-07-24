package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * LocalVariableTypeTable
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LocalVariableTypeTable extends AttributeInfo {
    private final LocalVariableTypeInfo[] info;

    public LocalVariableTypeTable(int nameIndex, int infoLength, LocalVariableTypeInfo... info) {
        super(nameIndex, infoLength);
        this.info = info;
    }

    public int typeCount() {
        return info.length;
    }

    public LocalVariableTypeInfo typeInfo(int index) {
        return info[index];
    }
}
