/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and intamassia
*
* inthis implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeMin is called.
*
* inthis implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/
public class HeapPriorityQueue implements PriorityQueue {

	protected final static int DEFAULT_SIZE = 10000;
	
	protected int[] storage;
	protected int currentSize;
	int rootIndex = 1; // should be 0 or 1 depending on implementation

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	public HeapPriorityQueue() {
		// TODO: implement this
		storage = new int[DEFAULT_SIZE + 1];
		currentSize = 0;
		rootIndex = 1;
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	public HeapPriorityQueue(int size) {
		// TODO: implement this
		storage = new int[size + 1];
		currentSize = 0;
		rootIndex = 1;
		// if using a 1-based implementation, remember to allocate an 
		// extra space in the array since index 0 is not used. 
	}

	public void insert (int element) throws HeapFullException {
		// TODO: implement this
		if (isFull()) {
			throw new HeapFullException();
		}
		storage[currentSize + 1] = element;
		currentSize++;
		bubbleUp(currentSize);
		
		// When inserting the first element, choose whether to use 
		// a 0-based on 1-based implementation. Whatever you choose,
		// make sure your implementation for the rest of the program
		// is consistent with this choice.		
    }
	
	private void bubbleUp(int index) {
		// TODO: implement this
		// if (storage[index] > storage[index/2] || index <= 1) {
			// return;
		// } else {
			// int a = storage[index];
			// storage[index] = storage[index/2];
			// storage[index/2] = a;
			// bubbleUp(index/2);
		// }
		
		if (index <= 0) {
      return;
    }
    int parent = index / 2;
    if (parent >= 0) {
      if (storage[index].compareTo(storage[parent]) < 0) {
        int temp = storage[parent];
        storage[parent]  = storage[index];
        storage[index] = temp;
        bubbleUp(parent);
      }
    }
		
	}
			
	public int removeMin() throws HeapEmptyException {
		// TODO: implement this
		if (isEmpty()) {
			throw new HeapEmptyException();
		}
		int a = storage[1];
		storage[1] = storage[currentSize];
		currentSize--;
		bubbleDown(1);
		return a;
	}
	
	private void bubbleDown(int index) {
		// TODO: implement this
		if (index > currentSize || index * 2 > currentSize || index * 2 +1 > currentSize) {
			return;
		}
		if (storage[index] <= storage[index * 2] || storage[index] <= storage[index * 2 +1]) {
			return;
		}
		if (storage[index * 2] > storage[index * 2 +1]) {
			int a = storage[index];
			storage[index] = storage[index * 2];
			storage[index * 2] = a;
			bubbleDown(index * 2);
		} else {
			int a = storage[index];
			storage[index] = storage[index * 2 + 1];
			storage[index * 2 + 1] = a;
			bubbleDown(index * 2 + 1);
		}
	}

	public boolean isEmpty(){
		// TODO: implement this
		if (currentSize == 0) {
			return true;
		}
		return false;
	}
	
	public boolean isFull() {
		// TODO: implement this
		if (storage.length <= currentSize){
			return true;
		}
		return false;
	}
	
	public int size () {
		// TODO: implement this
		return currentSize;
	}

	public String toString() {
		String s = "";
		String sep = "";
		if (rootIndex == 0) {
			for (int i = 0; i < currentSize; i++) {
				s += sep + storage[i];
				sep = " ";				
			}
		} else if (rootIndex == 1) {
			for(int i=1; i<=currentSize; i++) {
				s += sep + storage[i];
				sep = " ";
			}
		}
		return s;
	}
}
