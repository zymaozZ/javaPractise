package StreamDemo;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class User {

    private String name;

    private List<String> friends;

    public User(String name, String... friends) {
        this.name = name;
        this.friends = Arrays.asList(friends);
    }
}
