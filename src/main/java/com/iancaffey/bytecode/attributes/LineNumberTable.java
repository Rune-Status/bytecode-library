package com.iancaffey.bytecode.attributes;

import com.iancaffey.bytecode.AttributeInfo;

/**
 * LineNumberTable
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LineNumberTable extends AttributeInfo {
    private final LineInfo[] info;

    public LineNumberTable(int nameIndex, int infoLength, LineInfo... info) {
        super(nameIndex, infoLength);
        this.info = info;
    }

    public int lineCount() {
        return info.length;
    }

    public LineInfo lineInfo(int index) {
        return info[index];
    }
}
