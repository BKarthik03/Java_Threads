package Thread_Creation;

public class LambdaExpression {
    public static void main(String[] args) {

        //Thread using Thread class and lamda expression
        Thread t1 = new Thread(()->{
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+" : "+i);
            }
        },"Java");

        //Thread using Runnable interface and lamda expression
        Runnable r2 = () -> {
            for(int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+" : "+i);
            }
        };
        Thread t2 = new Thread(r2, "Python");

        Runnable r3 = () -> System.out.println("I'm the Demo for single statement using lambda Expression and" +
                ", using it as a thread!!");
        Thread t3 = new Thread(r3, "C");


        t1.start();
        t2.start();
        t3.start();
    }
}
