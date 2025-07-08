package InterThreadCommunicatrion;
class Factory{
    int n = 0;
    boolean food = false;
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
        System.out.println(Thread.currentThread().getName()+" Produced: "+n);
        food = true;
        notifyAll();
    }

    synchronized void eat(){
        while(!food){
            try{
                Thread.sleep(1000);
                wait();
            }catch(InterruptedException e){
                System.out.println("Got Interrupted!");
            }
        }
        food = false;
        System.out.println(Thread.currentThread().getName()+" Consumed: "+n);
        notifyAll();
    }
}

class Producer_ implements Runnable{
    Factory f;
    Producer_(Factory f) {
        this.f = f;
    }
    public void run(){
        int i=0;
        while(true)
            f.cook(++i);
    }
}

class Consumer_ implements Runnable{
    Factory f;
    Consumer_(Factory f){
        this.f = f;
    }

    public void run(){
        while(true)
            f.eat();
    }
}

public class NotifyAll {
    public static void main(String[] args) {
        Factory f = new Factory();

       Thread t1 =  new Thread(new Producer_(f));
       Thread t2 =new Thread(new Producer_(f));
       Thread t3 = new Thread(new Consumer_(f));
       Thread t4 = new Thread(new Consumer_(f));


       t1.start();
       t2.start();
       t3.start();
       t4.start();
    }
}
