package Thread_Creation;

class Thread2 implements Runnable{

    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+" : "+i);
        }
    }

}
public class RunnableInterface {
    public static void main(String[] args) {
        //creating object for the Thread2 class
        Thread2 t2 = new Thread2();

        //creating  thread object and passing the object of Thread2 class, so the that Thread2 class's run() is the target.
        Thread t = new Thread(t2,"JAVA");

        //invoking run() method using Thread object t which targets the object of Thread2 class.
        t.start();
    }
}
