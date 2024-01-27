import javax.security.sasl.RealmChoiceCallback;

/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeLow is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/
@SuppressWarnings({"rawtypes", "unchecked"})
public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;
	
	protected Comparable[] storage;
	protected int currentSize;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		storage = new Comparable[DEFAULT_SIZE + 1];
		currentSize = 0;
		// TODO: implement this
		
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	public HeapPriorityQueue(int size) {
		// TODO: implement this
		storage = new Comparable[size + 1];
		currentSize = 0;
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
	}

	public void insert (Comparable element) throws HeapFullException {
		// TODO implement this
		if (isFull())
			throw new HeapFullException();
		storage[size() + 1] = element;
		bubbleUp(size() + 1);
		currentSize++;
		// When inserting the first element, choose whether to use 
		// a 0-based on 1-based implementation. Whatever you choose,
		// make sure your implementation for the rest of the program
		// is consistent with this choice.		
    }
	
	public void swap(int ind1, int ind2) {
		Comparable tmp1 = storage[ind1];
		Comparable tmp2 = storage[ind2];
		storage[ind1] = tmp2;
		storage[ind2] = tmp1;
	}

	public void bubbleUp(int index) {
		if (index == 1)
			return;
		if (storage[index].compareTo(storage[index / 2]) < 0) {
			swap(index, index / 2);
		}
		bubbleUp(index / 2);
		// TODO: implement this
	}
			
	public Comparable removeMin() throws HeapEmptyException {
		if (isEmpty()) {
			throw new HeapEmptyException("Heap is Empty");
		}

		swap(1, size());
		bubbleDown(1);
		Comparable tmp = storage[size()];
		currentSize--;
		// TODO: implement this
		
		return tmp; // so it compiles
	}
	
	private void bubbleDown(int index) {
		boolean hasLChild = (index * 2 < currentSize);
		boolean hasRChild = (index * 2 + 1 < currentSize);
		if (!hasRChild) {
			if (hasLChild) {
				if (storage[index].compareTo(storage[index * 2]) > 0) {
					swap(index, index * 2);
					bubbleDown(index * 2);
				}
			} else {
				return;
			}
		} else if (hasLChild & hasRChild) {
			if (storage[index * 2].compareTo(storage[index * 2 + 1]) <= 0) {
				if (storage[index].compareTo(storage[index * 2]) >= 0) {
					swap(index, index * 2);
					bubbleDown(index * 2);
				}
			} else {
				if (storage[index].compareTo(storage[index * 2 + 1]) >= 0) {
					swap(index, index * 2 + 1);
					bubbleDown(index * 2 + 1);
				}
			}
		}
		// TODO: implement this
	}

	public boolean isEmpty(){
		// TODO: implement this
		
		return size() == 0; // so it compiles
	}
	
	public boolean isFull() {
		// TODO: implement this
		return storage.length == currentSize + 1; // so it compiles
	}
	
	public int size () {
		// TODO: implement this
		
		return currentSize; // so it compiles
	}

	public String toString() {
		String s = "";
		String sep = "";
		// This implementation of toString assumes you 
		// are using a 1-based approach. Update the initial
		// and final value for i if using a 0-based
		for(int i=1; i<=currentSize; i++) {
			s += sep + storage[i];
			sep = " ";
		}
		return s;
	}
}
