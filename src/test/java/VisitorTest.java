import com.iancaffey.bytecode.lang.BytecodeModel;
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
        BytecodeReader<BytecodeModel, ByteVisitor> r = new BytecodeReader<>(data, BytecodeReader.singletonController((reader, visitor) -> {
            byte[] b = new byte[reader.available()];
            reader.readFully(b);
            visitor.visit(b);
        }));
        r.accept(buffer -> Assert.assertArrayEquals(data, buffer));
    }
}
