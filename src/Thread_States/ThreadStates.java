package Thread_States;

class Thread1 implements Runnable {
    int n = 0;

    public void run() {
        try {
            Thread.currentThread().sleep(1000);

            System.out.println("Thread State3 is: RUNNING");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class ThreadStates {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread t = new Thread(t1);
        System.out.println("Thread State1 is: " + t.getState());
        t.start();
        System.out.println("Thread State2 is: " + t.getState());
        try {
            Thread.sleep(100);
            System.out.println("Thread State4 is: " + t.getState());
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread State5 is: " + t.getState());
    }
}
