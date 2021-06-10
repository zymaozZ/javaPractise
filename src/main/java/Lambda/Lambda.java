import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

public class Lambda {

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> res = new ArrayList<>();
        for (T each : list) {
            if (p.test(each)) {
                res.add(each);
            }
        }
        return res;
    }

    public static <T> void foreach(List<T> list, Consumer<T> c) {
        for (T each : list) {
            c.accept(each);
        }
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> res = new ArrayList<>();
        for (T each : list) {
            res.add(f.apply(each));
        }
        Predicate<Integer> p = (Integer i) -> i > 0;
        p = (Integer i) -> i < 0;
        Integer integer = 333;
        String s = "333";

        return res;
    }

    public static void main(String[] args) {
//        List<Integer> res = filter(Arrays.asList(1, 2, 4, 5), (Integer i) -> i > 3);
//        System.out.println(res);

        List<String> str = Arrays.asList("a", "b", "A", "B");









        str.sort(String::compareTo);

        Function<String, Integer> stringToInteger =
                Integer::parseInt;

//        Supplier<Apple> s1 = Apple::new;
//        Apple a1 = s1.get();
    }
}
