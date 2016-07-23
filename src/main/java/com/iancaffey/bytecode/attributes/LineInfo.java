package com.iancaffey.bytecode.attributes;

/**
 * LineInfo
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class LineInfo {
    private final int startIndex;
    private final int line;

    public LineInfo(int startIndex, int line) {
        this.startIndex = startIndex;
        this.line = line;
    }

    public int startIndex() {
        return startIndex;
    }

    public int line() {
        return line;
    }
}
