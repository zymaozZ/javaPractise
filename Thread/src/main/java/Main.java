public class Main {

    public static void main(String[] args) throws InterruptedException {
//        t1();
//        t2();
//        t3();
//        t4();
//        testJoin();
//        testInterrupt();
        testInterruptWithJoin();
    }

    public static void t1() {
        Thread1 mTh1 = new Thread1("A");
        Thread1 mTh2 = new Thread1("B");
        mTh1.start();
        mTh2.start();
    }

    public static void t2() {
        new Thread(new Thread2("c")).start();
        new Thread(new Thread2("d")).start();
    }

    public static void t3() {
        System.out.println("main start...");
        Thread t = new Thread() {
            public void run() {
                System.out.println("thread run...");
                System.out.println("thread end.");
            }
        };
        t.start();
        System.out.println("main end...");
    }

    public static void t4() {
        System.out.println("main start...");
        Thread t = new Thread() {
            public void run() {
                System.out.println("thread run...");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
                System.out.println("thread end.");
            }
        };
        t.start();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {}
        System.out.println("main end...");
    }

    public static void testJoin() throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("hello");
        });
        System.out.println("start");
        t.start();
        t.join();
        System.out.println("end");
    }

    public static void testInterrupt() throws InterruptedException {
        Thread t = new ThreadInterrupt1();
        t.start();
        Thread.sleep(1);
        t.interrupt();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().isInterrupted());
        System.out.println(Thread.interrupted());
        System.out.println("end");
    }

    public static void testInterruptWithJoin() throws InterruptedException {
        Thread t = new ThreadInterruptWithHello();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        t.join();
        System.out.println("end");
    }
}
