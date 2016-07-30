package com.iancaffey.bytecode.io.direct.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.direct.AttributeModelVisitor;
import com.iancaffey.bytecode.io.direct.ClassModelVisitor;

import java.io.IOException;

/**
 * StackMapTableHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class StackMapTableHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor) throws IOException {
        int count = reader.readUnsignedShort();
        StackMapTableVisitor stackMapTableVisitor = visitor.visitStackMapTable(count);
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
                VerificationTypeVisitor verificationTypeVisitor = stackMapTableVisitor.visitAppendFrame(type, offset, infoCount);
                for (int j = 0; j < infoCount; j++)
                    VerificationTypeHandler.accept(reader, verificationTypeVisitor);
            } else {
                int offset = reader.readUnsignedShort();
                FullFrameVisitor fullFrameVisitor = stackMapTableVisitor.visitFullFrame(offset);
                int locals = reader.readUnsignedShort();
                VerificationTypeVisitor localVisitor = fullFrameVisitor.visitLocals(locals);
                for (int j = 0; j < locals; j++)
                    VerificationTypeHandler.accept(reader, localVisitor);
                int stack = reader.readUnsignedShort();
                VerificationTypeVisitor stackVisitor = fullFrameVisitor.visitStack(stack);
                for (int j = 0; j < locals; j++)
                    VerificationTypeHandler.accept(reader, stackVisitor);
            }
        }
    }
}
