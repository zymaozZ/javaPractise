package LambdaDesignPatternDemo.Observer;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject{

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(v -> v.notify(tweet));
    }

    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.registerObserver(new NYTimes());
        f.notifyObservers("aaa queen  wine");
    }
}
