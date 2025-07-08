package Thread_States;

class Hello implements Runnable {
    public static synchronized void common() {
        System.out.println(Thread.currentThread().getName() + " is running");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() {
        common();
    }
}


public class BlockedThread {
    public static void main(String[] args) {
        Hello h = new Hello();

        Thread t1 = new Thread(h);
        Thread t2 = new Thread(h);

        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t1.start();
        t2.start();
        System.out.println(t1.getName() + " State1 is: " + t1.getState());
        System.out.println(t2.getName() + " State2 is: " + t2.getState());
    }
}
