import com.iancaffey.bytecode.lang.ClassReader;
import com.iancaffey.bytecode.lang.DebugClassVisitor;

import java.io.IOException;

/**
 * A
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class A {
    public static final long CONST = 12121212;
    public long count;
    public String name;
    public Object obj;

    public static void main(String[] args) throws IOException {
        ClassReader.of(A.class).accept(new DebugClassVisitor()).close();
    }
}
