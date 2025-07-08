package ThreadPriorities;


class Runner implements Runnable{
    public void run(){
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        for(int i=0;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+" is Ruuning! "+i+"\n");
        }
    }

}
public class ThreadPriority {
    public static void main(String[] args) {

        System.out.println("\nEven though we are using assigning priorities fro threads, it might be ignored by the OS!!");

        Runner r = new Runner();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);

        t1.setName("Thread 1");
        t2.setName("Thread 2");
        t3.setName("Thread 3");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Priority of Thread1 is: "+t1.getPriority());
        System.out.println("Priority of Thread2 is: "+t2.getPriority());
        System.out.println("Priority of Thread3 is: "+t3.getPriority());
        System.out.println();

        t1.start();
        t2.start();
        t3.start();

    }
}
