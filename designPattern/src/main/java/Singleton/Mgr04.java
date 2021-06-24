package Singleton;

/**
 * 懒汉式
 * 通过 synchronized 解决多个线程创建问题。同时效率下降
 */
public class Mgr04 {

    private static Mgr04 INSTANCE;

    private Mgr04() {

    }

    public static synchronized Mgr04 getINSTANCE() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr04();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100 ; i++) {
            new Thread(() -> {
                System.out.println(Mgr04.getINSTANCE().hashCode());
            }).start();
        }
    }
}
