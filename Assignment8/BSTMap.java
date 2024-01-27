import java.util.*;

public class BSTMap<K extends Comparable<K>, V > implements  Map<K, V>  {
    
	BinarySearchTree<K,V> bst;

	public BSTMap () {
		bst = new BinarySearchTree<K,V>();
	}

	public boolean containsKey(K key) {
		// TODO: implement this
		try {
			bst.find(key);
			return true;
		} catch (KeyNotFoundException e) {
			return false; // so it compiles
		}
	}

	public V get (K key) throws KeyNotFoundException {
		// TODO: implement this
		V tmp = bst.find(key);
		if (tmp == null)
			throw new KeyNotFoundException();
		return tmp; // so it compiles
	}

	public List<Entry<K,V> >	entryList() {
		return bst.entryList(); // so it compiles
	}

	public void put (K key, V value) {
		bst.insert(key, value);
		// TODO: implement this
	}

	public int size() {
		// TODO: implement this
		return bst.size(); // so it compiles
	}

	public void clear() {
		bst.clear();
		// TODO: implement this
	}

}