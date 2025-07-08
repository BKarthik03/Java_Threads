package Synchhronization;

class Kitchen {
    int n = 0;
    boolean food = false;

    synchronized void eat() {
        while (!food) {
            try {
                Thread.sleep(1000);
                System.out.println("Not Prepared, Customer Waiting!!");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Got InterruptedException!!");
            }
        }
        System.out.println("\nConsumer Ate: " + n);
        food = false;
        notify();
    }

    synchronized void prepare(int i) {
        while (food) {
            try {
                Thread.sleep(1000);
                System.out.println("Not Consumed, Producer Waiting!!");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Got InterruptedException!!");
            }
        }
        n = i;
        System.out.println("\nProducer Prepared: " + n);
        food = true;
        notify();
    }
}

class Producer implements Runnable {
    Kitchen k;

    Producer(Kitchen k) {
        this.k = k;
    }

    public void run() {
        int i = 1;
        while(true)
            k.prepare(i++);
    }
}

class Consumer implements Runnable {
    Kitchen k;

    Consumer(Kitchen k) {
        this.k = k;
    }
    public void run(){
        while(true)
            k.eat();
    }

}

public class ProducerConsumerProblem {
    public static void main(String[] args) {
        Kitchen k = new Kitchen();

        Producer p = new Producer(k);
        Consumer c = new Consumer(k);

        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();
    }
}
