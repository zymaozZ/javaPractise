import LambdaDemo.Apple;
import LambdaDemo.BufferReaderProcessor;
import LambdaDemo.Dish;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Test t = new Test();
        t.testStream2();
    }

    public static String processFile(BufferReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("file"))){
//            return br.readLine();
            return p.process(br);
        }
    }

    public void testLambda() {
        List<Apple> inventory = Arrays.asList(new Apple(280,"green"),
                new Apple(155, "green"),
                new Apple(180, "red"));
        /**
         * 1
         */
//        inventory.sort(new Lambda.Lambda.AppleComparator());
        /**
         * 2
         */
//        inventory.sort(new Comparator<Lambda.Lambda.Apple>() {
//            @Override
//            public int compare(Lambda.Lambda.Apple o1, Lambda.Lambda.Apple o2) {
//                return o1.getWeight().compareTo(o2.getWeight());
//            }
//        });
        /**
         * 3
         */
//        Comparator
//        inventory.sort((o1, o2) -> {
//            return o1.getWeight().compareTo(o2.getWeight());
//        });



//        inventory.sort(Comparator.comparing((a) -> a.getWeight()));
//
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());

        System.out.println(inventory.toString());
    }

    public void testStream1() {
        List<Dish> menu = getMenu();
//        List<String> names = new ArrayList<>();
//        for (Lambda.Dish d : menu) {
//            names.add(d.getName());
//        }

//        List<String> name = new ArrayList<>();
//        Iterator<Lambda.Dish> iterator = menu.iterator();
//        while (iterator.hasNext()) {
//            Lambda.Dish d = iterator.next();
//            name.add(d.getName());
//        }

        List<String> names = menu.stream().map(Dish::getName).collect(Collectors.toList());

    }

    public void testStream2() {
        List<Dish> menu = getMenu();
        List<String> names = menu.stream()
                .filter(d -> {
                    System.out.println("filtering " + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping " + d.getName());
                    return d.getName();
                })
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(names);
    }

    public void flatMapTest() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream().map(j -> new int[] {i, j}))
                .collect(Collectors.toList());

    }

    private List<Dish> getMenu() {
        return Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );
    }
}
