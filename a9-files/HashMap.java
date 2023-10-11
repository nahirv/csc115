import java.util.*;

public class HashMap<K extends Comparable<K>, V> implements Map<K,V> {

	private List<List<Entry<K,V>>> 	table;
	private int	count;
	private int  tableSize;

	// For Part III
	private long getLoops;
	private long putLoops;
	

	public HashMap() {
		tableSize = 1000003; // prime number
		table = new ArrayList<List<Entry<K,V>>>(tableSize);

		// initializes table as a list of empty lists
		for (int i = 0; i < tableSize; i++) {
			table.add(new LinkedList<Entry<K,V>>());
		}

		count = 0;

		// For Part III:
		resetGetLoops();
		resetPutLoops();
	}

	// For Part III
	public long getGetLoopCount() {
		return getLoops;
	}

	// For Part III
	public long getPutLoopCount() {
		return putLoops;
	}

	// For Part III
	public void resetGetLoops() {
		getLoops = 0;
	}
	
	// For Part III
	public void resetPutLoops() {
		putLoops = 0;
	}

	public boolean containsKey(K key) {
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode()) % tableSize;

		// TODO: complete the rest of this method
		List<Entry<K,V>> list = table.get(index);
		Iterator<Entry<K,V>> iter = list.iterator();
		if (list.isEmpty()) {
			return false;
		} else {
			while (iter.hasNext()){
				Entry<K, V> n = iter.next();
				if (n.getKey().equals(key)) {
					return true;
				}
			}
		}
		return false;
	}

	public V get (K key) throws KeyNotFoundException {
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode()) % tableSize;

		// TODO: complete the rest of this method
		List<Entry<K,V>> list = table.get(index);
		Iterator<Entry<K,V>> iter = list.iterator();
		if (list.isEmpty() != true) {
			while (iter.hasNext()){
				Entry<K, V> n = iter.next();
				if (n.getKey().equals(key)) {
					return n.getValue();
				}
			}
		}
		throw new KeyNotFoundException();
	}


	public List<Entry<K,V> >	entryList() {
		List <Entry<K,V>> resultList = new LinkedList<Entry<K,V>>();
		// TODO: complete the rest of this method

		// Tip: you will need to iterate through each index in the table (and each index holds a list)
		//      you will THEN need to iterate through each element in the linked list chain at a 
		//      specific index and add each element to l
		for (int i = 0; i < tableSize; i++) {
			List<Entry<K,V>> list = table.get(i);
			Iterator<Entry<K,V>> iter = list.iterator();
			if (list.isEmpty() != true) {
				while (iter.hasNext()){
					Entry<K, V> n = iter.next();
					resultList.add(n);
				}
			}
		}
		
		return resultList;
	}
	
	public void put (K key, V value){
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode())%tableSize;

		// TODO: complete the rest of this method

		// if key is found, update value.  if key is not found add a new Entry with key,value
		// The tester expects that you will add the newest Entry to the END of the list
		List<Entry<K,V>> list = table.get(index);
        Iterator<Entry<K,V>> iter = list.iterator();
		boolean found = false;
		while (iter.hasNext()){
			Entry<K, V> n = iter.next();
			if (n.getKey().equals(key)) {
				n.setValue(value);
				found = true;
				break;
			}
		}
		if (found == false) {
			Entry<K, V> e = new Entry<K, V>(key, value);
			list.add(e);
			count++;
		}
	}

	public int size() {
		return count;
	}

    public void clear() {
		for(int i = 0; i < tableSize; i++) {
			table.get(i).clear();
		}
        count = 0;
    }

}