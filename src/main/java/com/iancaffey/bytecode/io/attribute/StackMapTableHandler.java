package com.iancaffey.bytecode.io.attribute;

import com.iancaffey.bytecode.*;
import com.iancaffey.bytecode.util.AttributeHandler;

import java.io.IOException;

/**
 * StackMapTableHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class StackMapTableHandler implements AttributeHandler {
    private final BytecodeHandler<ClassReader, VerificationTypeInfoVisitor> handler;

    public StackMapTableHandler() {
        this.handler = new VerificationTypeInfoHandler();
    }

    @Override
    public void accept(ClassReader reader, AttributeVisitor visitor, int length) throws IOException {
        int count = reader.readUnsignedShort();
        StackMapTableVisitor stackMapTableVisitor = visitor.visitStackMapTable(count);
        stackMapTableVisitor.begin();
        for (int i = 0; i < count; i++) {
            int tag = reader.readUnsignedByte();
            if (tag < 0 || tag > 255)
                throw new IllegalArgumentException("Unable to locate handler for stack map frame: " + tag);
            int type = reader.readUnsignedByte();
            if (tag < 64) {
                stackMapTableVisitor.visitSameFrame(type);
            } else if (tag < 128) {
                stackMapTableVisitor.visitSingleStackItemFrame(type);
            } else if (tag < 247) {
                throw new UnsupportedOperationException("Tags [128-246] are reserved for future use");
            } else if (tag == 247) {
                stackMapTableVisitor.visitSingleStackItemFrameExtended(type);
            } else if (tag < 251) {
                int offset = reader.readUnsignedShort();
                stackMapTableVisitor.visitChopFrame(type, offset);
            } else if (tag == 251) {
                stackMapTableVisitor.visitSameFrameExtended(type);
            } else if (tag < 255) {
                int offset = reader.readUnsignedShort();
                int infoCount = type - 251;
                VerificationTypeInfoVisitor verificationTypeInfoVisitor = stackMapTableVisitor.visitAppendFrame(type, offset, infoCount);
                verificationTypeInfoVisitor.begin();
                for (int j = 0; j < infoCount; j++)
                    handler.accept(reader, verificationTypeInfoVisitor);
                verificationTypeInfoVisitor.end();
            } else {
                int offset = reader.readUnsignedShort();
                FullFrameVisitor fullFrameVisitor = stackMapTableVisitor.visitFullFrame(offset);
                fullFrameVisitor.begin();
                int locals = reader.readUnsignedShort();
                VerificationTypeInfoVisitor localVisitor = fullFrameVisitor.visitLocals(locals);
                localVisitor.begin();
                for (int j = 0; j < locals; j++)
                    handler.accept(reader, localVisitor);
                localVisitor.end();
                int stack = reader.readUnsignedShort();
                VerificationTypeInfoVisitor stackVisitor = fullFrameVisitor.visitStack(stack);
                stackVisitor.begin();
                for (int j = 0; j < locals; j++)
                    handler.accept(reader, stackVisitor);
                stackVisitor.end();
                fullFrameVisitor.end();
            }
        }
        stackMapTableVisitor.end();
    }
}
