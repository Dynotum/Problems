public class ByeThread extends Thread {

    public ByeThread(String dyno) {
        setName(dyno);
    }

    public ByeThread() {
    }

    public void run() {
        System.out.println("Bye " + getName() + " thread!");
    }
}
