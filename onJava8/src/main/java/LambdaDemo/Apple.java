package LambdaDemo;

public class Apple {

    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    private Integer weight;

    private String color;

    public Integer getWeight() {
        return 3;
    }

    public String getColor() {
        return "red";
    }

    @Override
    public String toString() {
        return weight.toString();
    }
}
