package StreamTest;

import lombok.Data;

@Data
public class Trader {

    private final String name;

    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    @Override
    public String toString() {
        return "Trader: " + this.name + " in " + this.city;
    }
}
