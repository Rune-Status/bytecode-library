import com.iancaffey.bytecode.lang.BytecodeReader;
import com.iancaffey.bytecode.lang.BytecodeVisitor;
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
            public BytecodeReader<ByteVisitor> accept(ByteVisitor visitor) throws IOException {
                byte[] b = new byte[available()];
                readFully(b);
                visitor.visit(b);
                return this;
            }
        };
        r.accept(buffer -> Assert.assertArrayEquals(data, buffer));
    }
}
