package InterThreadCommunicatrion;
class Kitchen{
    int n = 0;
    boolean food = false;

    synchronized void eat(){
        while(!food){
            try{
                Thread.sleep(1000);
                wait();
            }catch(InterruptedException e){
                System.out.println("Got Interrupted!");
            }
        }
        System.out.println("Ate food: "+n);
        food = false;
        notify();
    }

    synchronized void cook(int i){
        while(food){
            try{
                Thread.sleep(1000);
                wait();
            }catch(InterruptedException e){
                System.out.println("Got Interrupted!");
            }
        }
        n = i;
        System.out.println("Prepared food: "+n);
        food = true;
        notify();
    }
}

class Producer implements  Runnable{
    Kitchen k;
    Producer(Kitchen k){
        this.k = k;
    }
    public void run(){
        while(true){
            k.eat();
        }
    }
}

class Consumer implements Runnable{
    Kitchen k;
    Consumer (Kitchen k){
        this.k = k;
    }

    public void run(){
        int i=0;
        while(true){
            k.cook(++i);
        }
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
