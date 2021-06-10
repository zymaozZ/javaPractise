package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(raoul, 2011, 200),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        // 找出2011年发生的所有交易，并按交易额排序（从低到高）
        List<Transaction> res = transactions.stream()
                .filter(v -> v.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println(res);

        // 交易员都在哪些不同的ۡ市工作过
        List<String> cities = transactions.stream()
                .map(v -> v.getTrader().getCity())
                .distinct()
                .collect(Collectors.toList());

        // 查找所有来自于剑桥的交易员，并按姓名排序
        List<Trader> traders = transactions.stream()
                .map(v -> v.getTrader())
                .filter(v -> v.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(v -> v.getName()))
                .collect(Collectors.toList());

        // 返回所有交易员的姓名字符串，按字母顺序排序
        String sortedNames = transactions.stream()
                .map(v -> v.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);

        System.out.println(sortedNames);

        //  有没有交易员是在米兰工作的
        boolean anyMatchInMilan = transactions.stream()
                .anyMatch(v -> v.getTrader().getCity().equals("Milan"));

        // 打印生活在剑桥的交易员的所有交易额
        transactions.stream()
                .filter(v -> v.getTrader().getCity().equals("Cambridge"))
                .forEach(v -> System.out.println(v.getValue()));

        // 所有交易中，最高的交易额是多少
        Integer max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max)
                .orElse(0);

        // 找到交易额最小的交易
        Optional<Transaction> transaction = transactions.stream()
                .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        Optional<Transaction> transaction2 = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));


    }
}
