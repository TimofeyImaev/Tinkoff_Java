package edu.hw11;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ByteArrayClassLoader;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import static net.bytebuddy.jar.asm.Opcodes.*;
import static net.bytebuddy.jar.asm.Opcodes.ACC_STATIC;
import static net.bytebuddy.jar.asm.Opcodes.ALOAD;
import static net.bytebuddy.jar.asm.Opcodes.ASTORE;
import static net.bytebuddy.jar.asm.Opcodes.IFLE;
import static net.bytebuddy.jar.asm.Opcodes.LCMP;
import static net.bytebuddy.jar.asm.Opcodes.LCONST_0;

public class Task3Test {
// я отчаялся
    public static byte[] generateFibClass() throws Exception {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        MethodVisitor mv;

        cw.visit(Opcodes.V11, Opcodes.ACC_PUBLIC, "Fibonacci", null, "java/lang/Object", null);

        mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "fib", "(I)J", null, null);
        mv.visitCode();

        mv.visitVarInsn(Opcodes.ILOAD, 0);
        Label ifeqLabel = new Label();
        mv.visitJumpInsn(Opcodes.IFEQ, ifeqLabel);

        mv.visitLdcInsn(1L);
        mv.visitVarInsn(Opcodes.LSTORE, 1);
        mv.visitLdcInsn(1L);
        mv.visitVarInsn(Opcodes.LSTORE, 3);

        Label loopStart = new Label();
        mv.visitLabel(loopStart);

        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitInsn(Opcodes.ICONST_1);
        mv.visitInsn(Opcodes.ISUB);
        mv.visitVarInsn(Opcodes.ISTORE, 0);

        mv.visitVarInsn(Opcodes.LLOAD, 1);
        mv.visitVarInsn(Opcodes.LLOAD, 3);
        mv.visitInsn(Opcodes.LADD);
        mv.visitVarInsn(Opcodes.LSTORE, 5);

        mv.visitVarInsn(Opcodes.LLOAD, 3);
        mv.visitVarInsn(Opcodes.LSTORE, 1);
        mv.visitVarInsn(Opcodes.LLOAD, 5);
        mv.visitVarInsn(Opcodes.LSTORE, 3);

        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitJumpInsn(Opcodes.IFGT, loopStart);

        mv.visitVarInsn(Opcodes.LLOAD, 1);
        mv.visitInsn(Opcodes.LRETURN);

        mv.visitLabel(ifeqLabel);
        mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
        mv.visitLdcInsn(0L);
        mv.visitInsn(Opcodes.LRETURN);

        mv.visitMaxs(0, 0);
        mv.visitEnd();

        cw.visitEnd();

        return cw.toByteArray();
    }

}
