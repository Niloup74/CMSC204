import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class CarQueue {
	Random rand;
	Queue<Integer> queue;
	
	
	/*
	 * constructors
	 */
	
	public CarQueue() {
		rand = new Random();
		queue = new ArrayDeque<Integer>();
		queue.add(rand.nextInt(5));
		queue.add(rand.nextInt(5));
		queue.add(rand.nextInt(5));
		queue.add(rand.nextInt(5));
		queue.add(rand.nextInt(5));
		queue.add(rand.nextInt(5));
	}
	
	public int deleteQueue() {
		return queue.remove();
	}
	
	public void addToQueue() {
		class Run implements Runnable{
			public void run() {
				try {
					while(true) {
						queue.add(rand.nextInt(5));
						Thread.sleep(100);
					}
				
				}catch(InterruptedException e) {
					e.getMessage();
				}
			}
		}
		Run run = new Run();
		Thread t = new Thread(run);
		t.start();
	}

}
