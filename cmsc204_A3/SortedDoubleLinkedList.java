import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	private Comparator comparator;

	public SortedDoubleLinkedList(Comparator<T> comp) {
		this.comparator= comp;
	}
	
	
	public SortedDoubleLinkedList<T> add(T data) {
		Node newNode = new Node(data);
		Node currentNode = head;
		Node prev;
		if(size==0) {
			head = newNode;
			tail= newNode;
			size++;
			return this;
		}
		if(size==1) {
			if(comparator.compare(data, currentNode.data)<0 || comparator.compare(data, currentNode.data)==0) {
				super.addToFront(data);
				return this;
			}
			else {
				super.addToEnd(data);
				return this;
			}
		}
		else {
			while(comparator.compare(currentNode.data, data)<0) {
				prev=currentNode;
				currentNode=currentNode.next;
				if(currentNode == null) {
					currentNode = newNode;
					newNode.prev=prev;
					prev.next=newNode;
					tail = newNode;
					size++;
					return this;
				}
			}
			if(currentNode== head) {
				if(comparator.compare(data, currentNode.data)<0) {
					super.addToFront(data);
				}
			}
			else if(currentNode == tail) {
				currentNode.prev.next=newNode;
				newNode.next=currentNode;
				newNode.prev=currentNode.prev;
				currentNode.prev=newNode;
				size++;
			}
			else {
				currentNode.prev.next = newNode;
				newNode.next=currentNode;
				newNode.prev= currentNode.prev;
				currentNode.prev = newNode;
				size++;
			}
			return this;
		}
	}
	@Override
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	@Override
	public Node remove(T data, Comparator<T> comparator) {
		return super.remove(data, comparator);
	}
	@Override
	public void addToFront(T data) {
		throw new UnsupportedOperationException();
	}
	@Override
	public void addToEnd(T data) {
		throw new UnsupportedOperationException();
	}
	
	
	
}
