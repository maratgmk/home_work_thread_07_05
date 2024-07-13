package trench;

public class Digger extends Thread {
    public Trench trench;

    public Digger(Trench trench) {
        this.trench = trench;

    }

    @Override
    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + " начал копать");
        trench.increaseTrench(trench.targetTrench());
    }
}
