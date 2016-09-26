package com.iancaffey.bytecode.io;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * VisitorTest
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class VisitorTest {
    private static interface ByteVisitor extends BytecodeVisitor {
        public void visit(byte[] data);
    }

    @Test
    public void visitorTest() throws IOException {
        byte[] data = new byte[]{2, 0, 1, 0, 2, 0, 3, 0, 4, 0, 3, 0, 2, 0, 1, 0, 4, 0, 5, 0, 3, 0, 4, 0, 2, 0, 3, 0};
        BytecodeReader<ByteVisitor> r = new BytecodeReader<ByteVisitor>(data) {
            @Override
            public void accept(ByteVisitor visitor) throws IOException {
                visitor.visit(buffer());
            }
        };
        r.accept(buffer -> Assert.assertEquals(data, buffer));
    }
}
