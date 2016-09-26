package com.iancaffey.bytecode.io;

import com.iancaffey.bytecode.Comprehensive;
import com.iancaffey.bytecode.model.ClassModelReader;
import com.iancaffey.bytecode.model.ClassModelWriter;
import com.iancaffey.bytecode.util.Type;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * WriterTest
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class WriterTest {
    @Test
    public void classATest() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream in = ClassLoader.getSystemResourceAsStream(Type.getInternalForm(Comprehensive.class) + ".class");
        int next;
        while ((next = in.read()) != -1)
            out.write(next);
        byte[] read = out.toByteArray();
        ClassModelWriter writer = new ClassModelWriter();
        new ClassModelReader(read).accept(writer);
        byte[] written = writer.toByteArray();
        Assert.assertArrayEquals(read, written);
    }
}
