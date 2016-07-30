import com.iancaffey.bytecode.ClassInfo;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.io.fast.ClassInfoVisitor;
import com.iancaffey.bytecode.util.Type;
import com.iancaffey.bytecode.util.debug.DebugClassVisitor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * A
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class A<C> extends Type implements Runnable {
    public static final long CONST = 12121212;
    public long count;
    public String name;
    public Object obj;

    public static void main(String[] args) throws IOException {
        long time = System.nanoTime();
        ClassReader.direct(A.class).accept(new DebugClassVisitor()).close();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - time) + "ms");
    }

    @Override
    public void run() {
        System.out.println();
    }
}
