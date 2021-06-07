import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));
        /**
         * 1
         */
//        inventory.sort(new AppleComparator());
        /**
         * 2
         */
//        inventory.sort(new Comparator<Apple>() {
//            @Override
//            public int compare(Apple o1, Apple o2) {
//                return o1.getWeight().compareTo(o2.getWeight());
//            }
//        });
        /**
         * 3
         */
        Comparator
        inventory.sort((o1, o2) -> {
            return o1.getWeight().compareTo(o2.getWeight());
        });
    }
}
