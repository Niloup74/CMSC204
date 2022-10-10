/*
 * @author Niloufar Zafari 
 * CMSC204 A2
 */
import java.util.ArrayList;

public class MyStack <T> implements StackInterface<T>{
	private ArrayList<T> stack;
	final private int SIZE;
	private int numOfItems;
	private int topIndex;

	public MyStack( int size) {
	 ArrayList temp = new ArrayList<T>(size);
	 stack = temp;
		SIZE = size;
		numOfItems = 0;
		topIndex = -1;
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
	public T pop() throws StackUnderflowException{
		if(stack.isEmpty()) {
			throw new StackUnderflowException();
		}
		else {
			
			T c = stack.get(topIndex);
			stack.remove(topIndex);
			numOfItems --;
			topIndex--;
			return c;		
		}
	}

	@Override
	public T top() throws StackUnderflowException {
		if(stack.isEmpty()) {
			throw new StackUnderflowException();
		}
		else {
			return stack.get(topIndex);

		}
	}

	@Override
	public int size() {
		
		return numOfItems;
	}

	public boolean push(T e) throws StackOverflowException{
		if(numOfItems >= SIZE) {
			throw new StackOverflowException();
		}
		else {
			stack.add(topIndex+1, e);;
			numOfItems++;
			topIndex++;
		}
		return true;
	}
	

	@Override
	public String toString(String delimiter) {
		String result = "";
		for(int i = 0; i<numOfItems-1; i++) {
			result += stack.get(i) + delimiter;
		}
		result += stack.get(numOfItems-1);
		return result;
	}

	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i<numOfItems; i++) {
			result += stack.get(i);
		}
		return result;
	}

	@Override
	public void fill(ArrayList<T> list) {
		ArrayList<T> stack2 = new ArrayList<T>(list);
		stack.addAll(stack2);
		numOfItems = stack.size();
	/*			new ArrayList<>(list.size());
		numOfItems = list.size();
		for(int i = 0; i<list.size(); i++)
		{
			stack.set(i, list.get(i));
			
		}*/
		
	}

	
}
