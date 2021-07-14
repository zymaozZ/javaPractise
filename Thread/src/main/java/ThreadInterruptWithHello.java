public class ThreadInterruptWithHello extends Thread{

    @Override
    public void run() {
        Thread hello = new HelloThread();
        hello.start();
        try {
            hello.join();
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
        hello.interrupt();
    }
}
