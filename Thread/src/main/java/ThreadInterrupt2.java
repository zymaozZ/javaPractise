public class ThreadInterrupt2 extends Thread{

    @Override
    public void run() {
        int n = 0;
        while (!isInterrupted()) {
            n++;
            System.out.println(n + " hello");
            try {
                Thread.sleep(100);
            } catch ()
        }
    }
}
