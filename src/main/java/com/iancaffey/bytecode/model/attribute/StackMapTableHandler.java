package com.iancaffey.bytecode.model.attribute;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.model.AttributeModelVisitor;
import com.iancaffey.bytecode.model.ClassModelVisitor;

import java.io.IOException;

/**
 * StackMapTableHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class StackMapTableHandler {
    public static void accept(BytecodeReader<ClassModelVisitor> reader, AttributeModelVisitor visitor, int nameIndex, int length) throws IOException {
        int count = reader.readUnsignedShort();
        StackMapTableVisitor stackMapTableVisitor = visitor.visitStackMapTable(nameIndex, length, count);
        for (int i = 0; i < count; i++) {
            int type = reader.readUnsignedByte();
            if (type < 0 || type > 255)
                throw new IllegalArgumentException("Unable to locate handler for stack map frame: " + type);
            if (type < 64) {
                stackMapTableVisitor.visitSameFrame(type);
            } else if (type < 128) {
                VerificationTypeVisitor verificationTypeVisitor = stackMapTableVisitor.visitSingleStackItemFrame(type);
                VerificationTypeHandler.accept(reader, verificationTypeVisitor);
            } else if (type < 247) {
                throw new UnsupportedOperationException("Tags [128-246] are reserved for future use");
            } else if (type == 247) {
                int offset = reader.readUnsignedShort();
                VerificationTypeVisitor verificationTypeVisitor = stackMapTableVisitor.visitSingleStackItemFrameExtended(offset);
                VerificationTypeHandler.accept(reader, verificationTypeVisitor);
            } else if (type < 251) {
                int offset = reader.readUnsignedShort();
                stackMapTableVisitor.visitChopFrame(type, offset);
            } else if (type == 251) {
                stackMapTableVisitor.visitSameFrameExtended(type);
            } else if (type < 255) {
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
