import com.iancaffey.bytecode.lang.BytecodeModel;
import com.iancaffey.bytecode.lang.BytecodeReader;
import com.iancaffey.bytecode.lang.BytecodeVisitor;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * VisitorTest
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class VisitorTest {
    private static interface ByteVisitor extends BytecodeVisitor {
        public void visit(ByteBuffer buffer);
    }

    private static class ByteModel implements BytecodeModel {
        public ByteBuffer buffer;
    }

    @Test
    public void visitorTest() throws IOException {
        byte[] data = new byte[]{2, 0, 1, 0, 2, 0, 3, 0, 4, 0, 3, 0, 2, 0, 1, 0, 4, 0, 5, 0, 3, 0, 4, 0, 2, 0, 3, 0};
        BytecodeReader<ByteModel, ByteVisitor> r = new BytecodeReader<>(data, BytecodeReader.singletonController((reader, visitor) -> {
            byte[] b = new byte[reader.available()];
            reader.readFully(b);
            reader.model.buffer = ByteBuffer.wrap(b);
            visitor.visit(reader.model.buffer);
        }), new ByteModel());
        r.accept(buffer -> {
        });
        Assert.assertArrayEquals(data, r.model.buffer.array());
    }
}
