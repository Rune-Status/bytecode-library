package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.model.AttributeModelVisitor;
import com.iancaffey.bytecode.model.MethodModelVisitor;
import com.iancaffey.bytecode.util.Access;

/**
 * DebugMethodModelVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugMethodModelVisitor extends DebugVisitor implements MethodModelVisitor {
    public DebugMethodModelVisitor() {
    }

    public DebugMethodModelVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visit(int access, int nameIndex, int descriptorIndex) {
        log(String.format("Method [access=%s, nameIndex=%s, descriptorIndex=%s]", Access.of(access).toString().toLowerCase(), nameIndex, descriptorIndex), 1);
    }

    @Override
    public AttributeModelVisitor visitAttributes(int count) {
        if (count > 0) {
            log(String.format("Attributes [count=%d]", count), 1);
        }
        return new DebugAttributeModelVisitor(indent() + 1);
    }
}
