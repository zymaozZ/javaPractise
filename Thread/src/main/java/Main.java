public class Main {

    public static void main(String[] args) {
        Thread1 mTh1 = new Thread1("A");
        Thread1 mTh2 = new Thread1("B");
        mTh1.start();
        mTh2.start();

        new Thread(new Thread2("c")).start();
        new Thread(new Thread2("d")).start();
    }
}
