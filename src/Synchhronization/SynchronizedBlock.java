package Synchhronization;

class Caller {
    void call(String msg) {
        System.out.print("[ " + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Got InterruptedException!!");
        }
        System.out.println(" ]");
    }

}

class CallMe implements Runnable {
    Caller caller;
    String msg;
    Thread t;

    CallMe(Caller cl, String msg) {
        caller = cl;
        this.msg = msg;
        t = new Thread(this);
    }

    public void run() {
        synchronized (caller) {
            caller.call(msg);
        }
    }
}

public class SynchronizedBlock {
    public static void main(String[] args) {
        System.out.println("\nWelcome to SynchronizedBlock\nYou will find Three Messages by Three Different Threads." +
                "\nThe Threads wait for the currently executing Thread to finish, because they are accessing the method through the same object which is put within synchronized block!!");

        Caller cr = new Caller();

        CallMe cm1 = new CallMe(cr, "Hi");
        CallMe cm2 = new CallMe(cr, "Hello");
        CallMe cm3 = new CallMe(cr, "Namaskara");

        cm1.t.start();
        cm2.t.start();
        cm3.t.start();
    }
}
