package Thread_States;

class SpawnedThread extends Thread {
    Thread mainThread;
    public SpawnedThread(Thread waitingThread) {
        this.mainThread = waitingThread;
    }
    public void run() {
        try {
            Thread.sleep(100);
            System.out.print("Main Thread is: "+mainThread.getState()+" for Spawned Thread to Finish!!");
            Thread.sleep(100);

        } catch (InterruptedException e) {}
    }
}
public class WaitingThread {
    public static void main(String[] args) {
        SpawnedThread spawnedThread = new SpawnedThread(Thread.currentThread());
        spawnedThread.start();

        try {
            spawnedThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
