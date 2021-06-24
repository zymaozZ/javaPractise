package Singleton;

/**
 * 懒汉式
 * 按需初始化 线程不安全(两个线程都创建了instance)
 */
public class Mgr03 {

    private static Mgr03 INSTANCE;

    private Mgr03() {

    }

    public static Mgr03 getINSTANCE() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            new Thread(() -> {
                System.out.println(Mgr03.getINSTANCE().hashCode());
            }).start();
        }
    }
}
