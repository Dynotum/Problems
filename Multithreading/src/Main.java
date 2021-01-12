import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Thread helloThread = new Thread(new HelloThread(), "dynothunder");
        Thread helloThread2 = new Thread(new HelloThread());
        helloThread.start();
        helloThread2.start();

        Thread bye = new ByeThread("dyno");
        Thread bye2 = new ByeThread();
        bye.start();
//        bye.start(); IllegalThreadStateException
        bye2.start();

        Thread lambda = new Thread(() -> {
            System.out.println("I'm a lambda thread called " + Thread.currentThread().getName());
        });

        lambda.start();
        Thread worker_X = new WorkerThread();
        worker_X.setName("worker-X");
        Thread worker_Y = new WorkerThread();
        worker_Y.setName("worker-Y");
        worker_Y.start();
        worker_X.start();

        Thread worker = new WorkerThread();
        worker.start(); // start the worker

        Thread.sleep(100L);

        System.out.println("Do something useful");

        worker.join(3000L);  // waiting for the worker`
        System.out.println("The program stopped");

    }
}

class WorkerThread extends Thread {

    private static final int NUMBER_OF_LINES = 3;

    @Override
    public void run() {
        final String name = Thread.currentThread().getName();


        if (!name.startsWith("worker-")) {
            return;
        }

        for (int i = 0; i < NUMBER_OF_LINES; i++) {
            System.out.println("do something...");
        }
    }
}