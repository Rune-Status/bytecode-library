import com.iancaffey.bytecode.ClassInfo;
import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.io.ClassReader;
import com.iancaffey.bytecode.util.Type;

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
        BytecodeReader<ClassInfo> reader = ClassReader.fast(A.class);
        long time = System.nanoTime();
        ClassInfo info = reader.accept(new ClassInfo());
        System.out.println(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - time) + "ms");
        reader.close();
    }

    @Override
    public void run() {
        System.out.println();
    }
}
