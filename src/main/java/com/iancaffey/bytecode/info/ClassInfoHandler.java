package com.iancaffey.bytecode.info;

import com.iancaffey.bytecode.io.BytecodeReader;
import com.iancaffey.bytecode.util.ClassInfoModel;

import java.io.IOException;

/**
 * ClassInfoHandler
 *
 * @author Ian Caffey
 * @since 1.0
 */
public class ClassInfoHandler {
    public static void accept(BytecodeReader<ClassInfoVisitor> reader, ClassInfoVisitor visitor) throws IOException {
        ClassInfoModel model = new ClassInfoModel();
        model.data = reader.buffer();

    }
}
