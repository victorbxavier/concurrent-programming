package taskwithsemaphore;

import java.util.List;

public class BaseThread extends Thread {
    protected final int total;
    protected final long sleep;
    protected List<String> elements;

    public BaseThread(List<String> elements, int total, long sleep, int priority) {
        this.total = total;
        this.sleep = sleep;
        this.elements = elements;

        setPriority(priority);
    }
}
