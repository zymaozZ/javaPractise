package StreamDemo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapTest {

    public static void main(String[] args) {
//        List<User> users = Arrays.asList(
//                new User("张三"),
//                new User("李四"),
//                new User("王五")
//        );
//
//        List<String> nameList = users.stream().map(User::getName).collect(Collectors.toList());
//        nameList.forEach(System.out::println);

        List<User> users = Arrays.asList(
                new User("张三", "f1", "f2", "f3"),
                new User("李四", "f1", "f2", "f3"),
                new User("王五", "f1", "f2", "f3")
        );

        List<String> nameList = users.stream()
                .map(User::getFriends)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        nameList.forEach(System.out::println);
    }
}
