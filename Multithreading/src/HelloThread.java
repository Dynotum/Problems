public class HelloThread implements Runnable{

    @Override
    public void run() {
        System.out.println("My name is " + Thread.currentThread().getName());
    }
}
