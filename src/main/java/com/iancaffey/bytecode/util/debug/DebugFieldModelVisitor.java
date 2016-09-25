package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.model.AttributeModelVisitor;
import com.iancaffey.bytecode.io.model.FieldModelVisitor;
import com.iancaffey.bytecode.util.Access;

/**
 * DebugFieldModelVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugFieldModelVisitor extends DebugVisitor implements FieldModelVisitor {
    public DebugFieldModelVisitor() {
    }

    public DebugFieldModelVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visit(int access, int nameIndex, int descriptorIndex) {
        log(String.format("Field [access=%s, nameIndex=%s, descriptorIndex=%s]", Access.of(access).toString().toLowerCase(), nameIndex, descriptorIndex), 1);
    }

    @Override
    public AttributeModelVisitor visitAttributes(int count) {
        if (count > 0)
            log(String.format("Attributes [count=%d]", count), 1);
        return new DebugAttributeModelVisitor(indent() + 1);
    }
}
