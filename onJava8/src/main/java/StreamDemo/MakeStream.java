package StreamDemo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MakeStream {

    public static void main(String[] args) {
//        long uniqueWords = 0;
//        try(Stream<String> lines = Files.lines(Paths.get(""))) {
//            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
//        } catch (Exception ignored) {
//
//        }

//        Stream.iterate(0, n -> n + 2)
//                .limit(10)
//                .forEach(System.out::println);

        List<Integer> seed = Arrays.asList(0, 1);
        List<Integer> res = new ArrayList<>();
        res.addAll(seed);
        Stream.iterate(seed, n -> {
            System.out.println(n.toString() + "--------");
            Integer a = n.get(0);
            Integer b = n.get(1);
            res.add(a + b);
            return Arrays.asList(b, a + b);
        })
                .limit(19)
                .forEach(System.out::println)
        ;
        System.out.println(res);

//        Stream.iterate(new int[]{0, 1},
//                t -> new int[]{t[1], t[0]+t[1]})
//                .limit(20)
//                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));

        IntSupplier fib = new IntSupplier() {
            private int pre = 0;
            private int cru = 1;
            @Override
            public int getAsInt() {
                int old = this.pre;
                int next = this.pre + this.cru;
                this.pre = this.cru;
                this.cru = next;
                return old;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);

    }
}
