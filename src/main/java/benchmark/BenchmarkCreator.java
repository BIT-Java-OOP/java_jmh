package benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Timeout;
import org.openjdk.jmh.annotations.Warmup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class BenchmarkCreator {

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1, time = 32, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, time = 300, timeUnit = TimeUnit.MILLISECONDS)
    @Timeout(time = 1)
    public void arrayList() {
        List<String> list = new ArrayList<>();
        list.add("1");
        for (int i = 0; i < 10000; i++) {
            list.add(0,"a" + i);
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1, time = 32, timeUnit = TimeUnit.MILLISECONDS)
    @Measurement(iterations = 2, time = 300, timeUnit = TimeUnit.MILLISECONDS)
    public void linkedList() {
        List<String> list = new LinkedList<>();
        list.add("1");
        for (int i = 0; i < 10000; i++) {
            list.add(0, "a" + i);
        }
    }
}
