package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.direct.AttributeVisitor;
import com.iancaffey.bytecode.io.direct.MethodVisitor;
import com.iancaffey.bytecode.util.Access;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugMethodVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugMethodVisitor extends DebugVisitor implements MethodVisitor {
    public DebugMethodVisitor() {
    }

    public DebugMethodVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visit(int access, int nameIndex, int descriptorIndex) {
        log(String.format("Method [access=%s, nameIndex=%s, descriptorIndex=%s]", Access.of(access).toString().toLowerCase(), nameIndex, descriptorIndex), 1);
    }

    @Override
    public AttributeVisitor visitAttributes(int count) {
        if (count > 0)
            log(String.format("Attributes [count=%d]", count), 1);
        return new DebugAttributeVisitor(indent() + 1);
    }
}
