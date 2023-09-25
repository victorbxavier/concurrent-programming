package taskwithsemaphore;

import java.util.List;
import java.util.concurrent.Semaphore;

public class Consumer extends BaseThread{
	private Semaphore semConsumer;
	private int count = 0;
	
	 public Consumer(List<String> elements, int total, long sleep, int priority, Semaphore semConsumer) {
	        super(elements, total, sleep, priority);
	        this.semConsumer = semConsumer;

	    }
	
	
	public void run() {

		for(; count < 60;) {
			if(!(elements.isEmpty())) {
				consume();
			}
		}
		
		System.out.println("#Consumer " + Thread.currentThread().getName() + " Finished"); 
		//Com problema, não chega aqui pq o contador nunca chega a 60 daí acontece um livelock
	}

	public void consume(){
		try {
			semConsumer.acquire();
			if(!(elements.isEmpty())) {
				String removed = elements.remove(0);
				count++;
				System.out.println("Removeu "+removed+" ");
			}
			Thread.sleep(sleep);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			semConsumer.release();
		}
		
	}
}

