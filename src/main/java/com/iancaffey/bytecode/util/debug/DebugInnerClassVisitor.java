package com.iancaffey.bytecode.util.debug;

import com.iancaffey.bytecode.io.direct.attribute.InnerClassVisitor;
import com.iancaffey.bytecode.util.DebugVisitor;

/**
 * DebugInnerClassVisitor
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class DebugInnerClassVisitor extends DebugVisitor implements InnerClassVisitor {
    public DebugInnerClassVisitor() {
    }

    public DebugInnerClassVisitor(int indent) {
        super(indent);
    }

    @Override
    public void visit(int innerClassInfoIndex, int outerClassInfoIndex, int innerNameIndex, int innerClassAccess) {
        log(String.format("InnerClass [innerClassInfoIndex=%d, outerClassInfoIndex=%d, innerNameIndex=%d, innerClassAccess=%d]",
                innerClassInfoIndex, outerClassInfoIndex, innerNameIndex, innerClassAccess), 1);
    }
}
