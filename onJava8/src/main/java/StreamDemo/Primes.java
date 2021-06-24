package StreamDemo;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Primes {

    public boolean isPrime(int candidate) {
        return IntStream.range(2, candidate).noneMatch(n -> candidate % n == 0);
    }

    public boolean isPrimeV2(int candidate) {
        int candidateRoot = (int) Math.sqrt(candidate);
        return IntStream.rangeClosed(2, candidateRoot).noneMatch(n -> candidate % n == 0);
    }

    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(Collectors.partitioningBy(this::isPrime));
    }

    public static void main(String[] args) {
//        Collector
    }
}
