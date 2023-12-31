package edu.project5;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaConversionException;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

@State(Scope.Thread)
public class ReflectionBenchmark {
    private Student student;
    private Method method;
    private MethodHandle replaceMH;
    private MethodType methodType;
    private CallSite callSite;

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
            .include(ReflectionBenchmark.class.getSimpleName())
            .shouldFailOnError(true)
            .shouldDoGC(true)
            .mode(Mode.AverageTime)
            .timeUnit(TimeUnit.NANOSECONDS)
            .forks(1)
            .warmupForks(1)
            .warmupIterations(1)
            .warmupTime(TimeValue.seconds(20))
            .measurementIterations(1)
            .measurementTime(TimeValue.minutes(3))
            .build();

        new Runner(options).run();
    }

    @Setup
    public void setup() throws Throwable {
        student = new Student("Alexander", "Biryukov");
        method = Student.class.getMethod("name");
        methodType = MethodType.methodType(String.class);
        var publicLookup = MethodHandles.publicLookup();
        replaceMH = publicLookup.findVirtual(Student.class, "name", methodType);

        var lookup = MethodHandles.lookup();

        MethodHandle handle = lookup.unreflect(method);
        callSite = LambdaMetafactory.metafactory(
            lookup,
            "get",
            MethodType.methodType(Supplier.class, Student.class),
            MethodType.methodType(Object.class),
            handle,
            MethodType.methodType(String.class));
    }

    @Benchmark
    public void directAccess(Blackhole bh) {
        String name = student.name();
        bh.consume(name);
    }

    @Benchmark
    public void reflection(Blackhole bh) throws InvocationTargetException, IllegalAccessException {
        String name = (String) method.invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void invokeHandles(Blackhole bh) throws Throwable {
        String name = (String) replaceMH.invoke(student);
        bh.consume(name);
    }

    @Benchmark
    public void invokeLambda(Blackhole bh)
        throws Throwable {
        Supplier<String> lambda = (Supplier<String>) callSite.getTarget().bindTo(student).invoke();

        bh.consume(lambda.get());
    }

    interface IStudent {
        String name();
    }

    public record Student(String name, String surname) implements IStudent {
        public String name() {
            return name;
        }
    }
}
/*
Benchmark                          Mode  Cnt   Score   Error  Units
ReflectionBenchmark.directAccess   avgt        0,716          ns/op
ReflectionBenchmark.invokeHandles  avgt        6,338          ns/op
ReflectionBenchmark.invokeLambda   avgt       46,439          ns/op
ReflectionBenchmark.reflection     avgt        8,181          ns/op
 */
