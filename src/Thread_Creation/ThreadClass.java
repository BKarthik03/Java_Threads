package Thread_Creation;

//extending the Thread class
class Thread1 extends Thread{

    Thread1(String name){
        this.setName(name);
        System.out.println("Name of the Thread is: "+this.getName());
    }
    //overriding run() method
    public void run(){
        for(int i=1;i<=10;i++){
            System.out.println(this.getName()+" : "+i);
        }
    }

}
public class ThreadClass {
    public static void main(String[] args) {
        //creating object for the Thread1 Thread
        Thread1 t1 = new Thread1("Java");

        //starting the thread, it invokes run() method of the thread that 't1' is pointing to
        t1.start();
    }
}
