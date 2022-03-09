import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

/**
 * 
 * @author Allan Kangethe
 *
 */


/**
 * This class uses a sorted linked lists in cooperation with basic double linked list 
 * 
 * 
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

	private Comparator<T> comparator;

	/**
	 * compare the sorted linked list
	 * 
	 * @param comparator is the data
	 * 
	 *  
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		this.comparator = comparator;
	}

	/**
	 * add theData in list
	 * 
	 * @param theData is the data
	 * 
	 *  
	 */
	public void add(T theData) {
		if (sizeOfNode == 0) {
			super.addToFront(theData);
			return;
		}
		if (comparator.compare(headNode.getData(), theData) > 0 || comparator.compare(tailNode.getData(), theData) == 0) {
			super.addToFront(theData);
			return;
		}
		if (comparator.compare(tailNode.getData(), theData) < 0 || comparator.compare(headNode.getData(), theData) == 0) {
			super.addToEnd(theData);
			return;
		}
		
		int prevCompare = -1;
		int currCompare;

		Node current = headNode;
		Node newNode;
		while (true) {
			currCompare = comparator.compare(current.getData(), theData);
			
			if ((prevCompare < 0 && currCompare > 0) || currCompare == 0) {
				newNode = new Node(theData, current.getPrev(), current);
				current.getPrev().setNext(newNode);
				current.setPrev(newNode);
				sizeOfNode++;
				break;
			}
			prevCompare = currCompare;
			current = current.getNext();
		}
	}

	/**
	 * add to end
	 * 
	 * @param theData the data in the node
	 * 
	 */
	@Override
	public void addToEnd(T theData) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
		}

	/**
	 * Gets the last data
	 * 
	 * 
	 * @return the last data of the node
	 * 
	 */
	@Override
	public T getLast() {
		return super.getLast();
	}

	/**
	 * Gets the first data
	 * 
	 * 
	 * @return the first data of the node
	 * 
	 */
	@Override
	public T getFirst() {
		return super.getFirst();
	}

	/**
	 * Gets the size
	 * 
	 * 
	 * @return the size
	 * 
	 */
	@Override
	public int getSize() {
		return super.getSize();
	}

	/**
	 * add to front
	 * 
	 * @param theData the data in the front
	 * 
	 */
	@Override
	public void addToFront(T theData) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retrieves the last element
	 * 
	 * 
	 * @return the last element
	 * 
	 */
	@Override
	public T retrieveLastElement() {
		return super.retrieveLastElement();
	}

	/**
	 * Retrieves the first element
	 * 
	 * 
	 * @return the first element
	 * 
	 */
	@Override
	public T retrieveFirstElement() {
		return super.retrieveFirstElement();
	}

	/**
	 * Arraylist of data
	 * 
	 * 
	 * @return an Array list
	 * 
	 */
	@Override
	public ArrayList<T> toArrayList() {
		return super.toArrayList();
	}

	/**
	 * Removes
	 * 
	 * @param targetData is the data being targeted
	 * @param comparator is the comparing data
	 * @return Double linked list
	 * 
	 */
	@Override
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		return super.remove(targetData, comparator);

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
		return super.iterator();
	}

}