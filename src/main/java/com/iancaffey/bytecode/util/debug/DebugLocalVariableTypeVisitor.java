package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.direct.attribute.LocalVariableTypeVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugLocalVariableTypeVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugLocalVariableTypeVisitor extends DebugVisitor implements LocalVariableTypeVisitor {
    public DebugLocalVariableTypeVisitor() {
    }

    public DebugLocalVariableTypeVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visit(int startIndex, int length, int nameIndex, int signatureIndex, int index) {
        log(String.format("LocalVariableTypeIndex [startIndex=%d, length=%d, nameIndex=%d, signatureIndex=%d, index=%d]",
                startIndex, length, nameIndex, signatureIndex, index), 1);
    }
}
