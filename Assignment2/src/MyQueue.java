/*
 * @author Niloufar Zafari 
 * CMSC204 A2
 */
import java.util.ArrayList;

public class MyQueue <T> implements QueueInterface<T> {

	private ArrayList<T> queue;
	private final int SIZE;
	private int numOfItems = 0;
	
	
	public MyQueue (int i) {
		queue = new ArrayList<T>(i);
		SIZE = i;
		numOfItems = 0;
	}

	@Override
	public boolean isEmpty() {
		boolean status = false;
		if(numOfItems <= 0) { status = true;}
		return status;
		
	}

	@Override
	public boolean isFull() {
		boolean status = false;
		if(numOfItems >= SIZE) {status = true;}
		return status;
		
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(queue.isEmpty()) {
			throw new QueueUnderflowException();
		}
		
		numOfItems--;
		return queue.remove(0);
		
		}

	
	
	@Override
	public int size() {
		return numOfItems;	}
	
	
	

	@Override
	public boolean enqueue(T e) throws QueueOverflowException{

		if(numOfItems == SIZE) {
			throw new QueueOverflowException();
		}
		else {
		queue.add(e);
		numOfItems++;
		return true;}
	}

	@Override
	public String toString(String delimiter) {
		String respond = "";
		for(int i = 0; i < queue.size() ;i++) {
			respond += queue.get(i) + delimiter;
		}
		respond += queue.get(numOfItems-1);
		return respond;
	}
	public String toString() {
		String respond = "";
		for(int i = 0; i < queue.size() ;i++) {
			respond += queue.get(i);
		}
		return respond;
	}

	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> copy = new ArrayList<>(list);
		copy.forEach(t -> 
		{try
		{
			enqueue(t);}
		catch(QueueOverflowException e) {
			e.getMessage();
		}});
		}
	
	}
		
	

		


