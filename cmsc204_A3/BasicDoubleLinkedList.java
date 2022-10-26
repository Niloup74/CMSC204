import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/*
 * an inner class Node with three fields data, prev, next reference .
 * inner class named DoubleLinkedListIterator that implements ListIterator.
 * This inner class implements only the hasNext(), next(), hasPrevious() 
 * and previous() methods of ListIterator , all other methods can throw the UnsupportedOperationException:
 * All the entities are defined as protected so they can be accessed by the subclasses.
 */
class BasicDoubleLinkedList<T> implements Iterable<T> {
	// attributes
	Node head;
	Node tail;
	int size;

	// Constructor
	public BasicDoubleLinkedList() {

		head = new Node(null);
		tail = new Node(null);
		size = 0;
	}

	// Methods
	/*
	 * adds the data to the end of the list.
	 */
	public void addToEnd(T data) {
		Node newNode = new Node(data);
		if (size == 0) {
			head = newNode;

		} else if (size == 1) {
			tail = newNode;
			tail.prev = head;
			head.next = tail;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;
		size++;
	}

	/*
	 * adds data to the head of the list
	 */
	public void addToFront(T data) {
		Node newNode = new Node(data);
		newNode.next = null;
		newNode.prev = null;
		if (head == null) {

			tail = newNode;

		} else if (size == 1) {
			head = newNode;
			head.next = tail;
			tail.prev = head;
		} else {

			head.prev = newNode;
			newNode.next = head;
		}
		head = newNode;
		size++;
	}

	/*
	 * checks if the list is empty
	 */
	public boolean isEmpty() {
		boolean result;
		if (size == 0) {
			result = true;
		} else
			result = false;
		return result;
	}

	/*
	 * returns the first item.
	 */
	public T getFirst() {
		if (isEmpty()) {
			return null;
		}
		return this.head.data;
	}

	/*
	 * returns the tail of the list
	 */
	public T getLast() {
		if (isEmpty()) {
			return null;
		}
		return tail.data;
	}

	/*
	 * return the size of the list
	 */
	public int getSize() {
		return size;
	}
	/*
	 * 
	 */
	// public BasicDoubleLinkedListIterator<T> iterator1(){return null;}

	public Node remove(T targetData, Comparator<T> comparator) {
		T result = null;
		Node currentNode = head;
		Node toRemove = null;
		Node prev = null;
		BasicDoubleLinkedList<T> list = new BasicDoubleLinkedList<T>();
		while (!isEmpty()) {
			if (comparator.compare(targetData, currentNode.data) == 0) {
				if (size == 1) {
					toRemove = head;
					tail = null;
					head = null;
					size--;
					break;
				} else if (currentNode == head) {
					toRemove = currentNode;
					head.next.prev = null;
					head = head.next;
					size--;
					break;
				} else if (currentNode == tail) {
					toRemove = currentNode;
					tail.prev.next = null;
					tail = tail.prev;
					size--;
					break;
				} else {
					toRemove = currentNode;
					currentNode.prev.next = currentNode.next;
					currentNode.next.prev = currentNode.prev;
					size--;
					break;
				}
			}
			prev = currentNode;
			currentNode = currentNode.next;
		}
		return toRemove;
	}

	/*
	 * returns the head of the list and removes it.
	 */
	public T retrieveFirstElement() {

		Node nodeToRemove = head;
		head = head.next;

		return nodeToRemove.data;
	}

	/*
	 * retrun the last/tail of the list and removes it
	 */
	public T retrieveLastElement() {
		Node nodeToRemove = tail;
		tail = tail.prev;
		return nodeToRemove.data;
	}

	/*
	 * returns the list in an ArrayList format
	 */
	public ArrayList<T> toArrayList() {

		ArrayList<T> res = new ArrayList<T>();

		int index = 0;
		Node currentNode = head;
		while ((index < size) && (currentNode != null)) {

			res.add(currentNode.data);
			currentNode = currentNode.next;
			index++;
		}

		return res;
	}

	@Override
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
		return new BasicDoubleLinkedListIterator();
	}

	/*
	 * private Node class
	 */
	public class Node {
		T data;
		Node next;
		Node prev;

		Node(T data) {
			this(data, null, null);
		}

		private Node(T data, Node next, Node prev) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	public class BasicDoubleLinkedListIterator implements ListIterator<T> {

		private Node currentNode;
		private Node prev;

		// Iterator<T> it = BasicDoubleLinkedList.iterator();
		public BasicDoubleLinkedListIterator() {
			prev = null;
			currentNode = head;
		}

		@Override
		public boolean hasNext() {
			return currentNode != null;

		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} else {
				prev = currentNode;
				currentNode = currentNode.next;
				return prev.data;
			}
		}

		@Override
		public boolean hasPrevious() {
			return prev != null;
		}

		@Override
		public T previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			} else {
				currentNode = prev;
				prev = prev.prev;
				return currentNode.data;
			}
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(Object e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(Object e) {
			throw new UnsupportedOperationException();
		}
	}

}
