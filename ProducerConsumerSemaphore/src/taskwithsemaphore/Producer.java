package taskwithsemaphore;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Producer extends BaseThread{
	private Semaphore semProducer;
	public Producer(List<String> elements, int total, long sleep, int priority, Semaphore semProducer) {
        super(elements, total, sleep, priority);
        this.semProducer = semProducer;

    }
	
	public void run() {
		for(int i = 0; i < 60; i++) {
			produce(i);
		}

		System.out.println("# Producer " + Thread.currentThread().getName() + " Finished");
	}

	public void produce(int count){
		try {
			semProducer.acquire();
			elements.add("E"+count);
			System.out.println("Adicionou E"+count+" ");
			Thread.sleep(sleep);
						
		}catch(InterruptedException e) {
			System.err.println("ERROR==>" + e.getMessage());
		}finally {
			semProducer.release();
		}
	}
}

