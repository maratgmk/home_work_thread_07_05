package trench;

import java.util.Objects;

public final class Trench {
    private final int targetTrench;
    private  int currentTrench;

    public Trench(int targetTrench) {
        this.targetTrench = targetTrench;
        this.currentTrench = 0;
    }

    public int targetTrench() {
        return targetTrench;
    }

    public int currentTrench() {
        return currentTrench;
    }

    public synchronized void increaseTrench(int targetTrench) {
        while (targetTrench >= currentTrench){
            currentTrench++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Trench has one meter else. Current long of trench is " + currentTrench);
        }
        System.out.println("Trench is completed");
    }
}
