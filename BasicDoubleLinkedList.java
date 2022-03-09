import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Comparator;

/**
 * 
 * @author Allan Kangethe
 *
 */


/**
 * This class uses linked lists in cooperation with iterable 
 * 
 * 
 */
public class BasicDoubleLinkedList<T> implements Iterable<T> {

	//Initialize the nodes and int size
	protected int sizeOfNode;
	protected Node headNode, tailNode;

	
	/**
	 * Constructor
	 * 
	 * The head node, size of node, and the tail node
	 * 
	 */
	public BasicDoubleLinkedList() {
		
		headNode = null;
		tailNode = null;
		sizeOfNode = 0;
	}

	
	/**
	 * add to end
	 * 
	 * @param theData the data in the node
	 * 
	 */
	public void addToEnd(T theData) {
		
		Node temp = new Node(theData, tailNode, null);
		if (tailNode != null) {
			tailNode.setNext(temp);
			tailNode = temp;
		} else {
			tailNode = temp;
			headNode = tailNode;
		}
		sizeOfNode++;
	}

	/**
	 * Gets the last data
	 * 
	 * 
	 * @return the last data of the node
	 * 
	 */
	public T getLast() {
		
		T result = null; //declares result null;
		
		//checks if tail is null
		if (tailNode != null) {
			result = tailNode.getData();
		}
		return result;
	}

	/**
	 * Gets the first data
	 * 
	 * 
	 * @return the first data of the node
	 * 
	 */
	public T getFirst() {
		
		//checks if head is null
		if (headNode != null) {
			return headNode.getData();
		}
		return null;
	}

	/**
	 * Gets size of the node
	 * 
	 * 
	 * @return the size of the node
	 * 
	 */
	public int getSize() {
		
		return sizeOfNode;
	}

	/**
	 * Adds to the front of the linked list
	 * 
	 * @param data is added to the front
	 * 
	 * 
	 */
	public void addToFront(T data) {
		Node tempNode = new Node(data, null, headNode);
		
	
		if (headNode != null) {
			headNode.setPrev(tempNode);
			headNode = tempNode;
		} 
		else 
		{
			headNode = tempNode;
			tailNode = headNode;
		}
		sizeOfNode++;
	}

	/**
	 * Retrieves the last element
	 * 
	 * 
	 * @return the last element
	 * 
	 */
	public T retrieveLastElement() {
		if (tailNode == null) {
			return null;
		}
		T last = tailNode.getData();

		
		if (sizeOfNode == 1) {
			headNode = null;
			tailNode = null;
			return last;
		}

		
		tailNode.setNext(null);
		sizeOfNode--;
		tailNode = tailNode.getPrev();
		return last;
	}

	/**
	 * Retrieves the first element
	 * 
	 * 
	 * @return the first element
	 * 
	 */
	public T retrieveFirstElement() {
		if (headNode == null) {
			return null;
		}
		T first = headNode.getData();

		if (sizeOfNode == 1) {
			headNode = null;
			tailNode = null;
			return first;
		}

		headNode = headNode.getNext();
		headNode.setPrev(null);
		sizeOfNode--;
		return first;
	}

	/**
	 * Arraylist of data
	 * 
	 * 
	 * @return an Array list
	 * 
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> list = new ArrayList<>();
		Node currentNode = headNode;

		while (currentNode != null) {
			list.add(currentNode.theData);
			currentNode = currentNode.next;
		}
		return list;
	}
	
	/**
	 * BasicDoubleLinked lists remove
	 * 
	 * @param targetData is the data being targeted
	 * @param comparator is the comparing data
	 * @return Double linked list
	 * 
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator)
	{
		Node currentNode = headNode;
		
		while(currentNode != null)
		{
			if (comparator.compare(targetData, currentNode.getData()) == 0)
			{
				if (headNode.theData == currentNode.getData())
					headNode = headNode.getNext();
				else if (tailNode.theData == currentNode.getData())
					tailNode = tailNode.getPrev();
				else if (tailNode != currentNode.getData() && headNode != currentNode.getData()) {
					currentNode.prev.next = currentNode.next;
				}
					
				sizeOfNode--;
				return null;
			}
			currentNode = currentNode.getNext();
		
		}
		return null;
		
	}

	
	/**
	 * Iterator
	 * 
	 * 
	 * @return ListIterator with data
	 * 
	 */
	@Override
	public ListIterator<T> iterator() {
		// TODO Auto-generated method stub
		return new DoubleLinkedListIterator();
	}

	
	//Nodes
	protected class Node {
		private T theData;
		private Node prev;
		private Node next;

		public Node(T theData, Node prev, Node next) {
			this.theData = theData;
			this.prev = prev;
			this.next = next;
		}

		public T getData() {
			return theData;
		}

		public Node getPrev() {
			return prev;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public void setData(T theData) {
			this.theData = theData;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

	}

	/**
	 * Protected Class with Double linked list iterator
	 * 
	 * 
	 * 
	 */
	protected class DoubleLinkedListIterator implements ListIterator<T> {

		private Node currentNode;
		private Node finalNode;

		DoubleLinkedListIterator(){
			currentNode = headNode;
			finalNode = null;
		}
		
		/**
		 * Checks if node has next
		 * 
		 * 
		 * @return boolean if it has next data
		 * 
		 */
		@Override
		public boolean hasNext() {
			return (currentNode != null);
		}

		/**
		 * Next data
		 * 
		 * 
		 * @return data
		 * @throws NoSuchElementException
		 */
		@Override
		public T next() throws NoSuchElementException {
			if (hasNext()) {
				finalNode = currentNode;
				currentNode = currentNode.getNext();
				return finalNode.getData();
			}
			throw new NoSuchElementException();
		}

		/**
		 * Previous data
		 * 
		 * 
		 * @return boolean if has previous
		 * 
		 */
		@Override
		public boolean hasPrevious() {
			return finalNode != null;
		}

		
		/**
		 * Previous data
		 * 
		 * 
		 * @return data of previous
		 * @throws NoSuchElementException
		 */
		@Override
		public T previous() throws NoSuchElementException {
			if (hasPrevious()) {
				currentNode = finalNode;
				finalNode = finalNode.getPrev();
				return currentNode.getData();
			}
			throw new NoSuchElementException();
		}

		/**
		 * Next Data
		 * 
		 * 
		 * @return int next index 
		 * @throws UnsupportedOperationException
		 */
		@Override
		public int nextIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		/**
		 * Previous Data
		 * 
		 * 
		 * @return int previous index 
		 * @throws UnsupportedOperationException
		 */
		@Override
		public int previousIndex() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		/**
		 * remove
		 * 
		 * 
		 * 
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		/**
		 * set data in list
		 * 
		 * 
		 * 
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void set(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}

		/**
		 * add data in list
		 * 
		 * 
		 * 
		 * @throws UnsupportedOperationException
		 */
		@Override
		public void add(T e) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}
}