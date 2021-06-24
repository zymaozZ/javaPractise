package Singleton;

public class Mgr07 {

    public static class SingletonHolder {
        private static final Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            new Thread(() -> {
                System.out.println(Mgr07.getInstance().hashCode());
            }).start();
        }
    }
}
