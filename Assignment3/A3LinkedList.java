// Name:
// Student number: v00

public class A3LinkedList implements A3List {
	private A3Node head;
	private A3Node tail;
	private int length;
	
	public A3LinkedList() {
		head = null;
		tail = null;
		length = 0;
	}
	
	public void addFront(String s) {
		A3Node tmp_node = new A3Node(s);
		tmp_node.next = head;
		tmp_node.prev = null;
		if (head != null)
			head.prev = tmp_node;
		if (head == null) {
			tail = tmp_node;
		}
		head = tmp_node;
		length ++;
	}

	public void addBack(String s) {
		A3Node tmp_node = new A3Node(s);
		tmp_node.next = null;
		A3Node cur = tail;
		tmp_node.prev = tail;
		if (tail != null) {
			tail.next = tmp_node;
		}
		if (tail == null) {
			head = tmp_node;
		}
		tail = tmp_node;
		length ++;
	}
	
	public int size() {
		return length;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public void removeFront() {
		head.next.prev = null;
		head = head.next;
	}
	
	public void removeBack() {
		tail.prev.next = null;
		tail = tail.prev;
	}
	
	
	public void rotate(int n) {
		if (n > length)
			n %= length;
		if (n == 0)
			return;
		int cnt = 1;
		A3Node cur = tail;
		while (cnt < n && cur != null) {
			cur = cur.prev;
			cnt++;
		}
		tail.next = head;
		tail = cur.prev;
		head.prev = null;
		head = cur;
		tail.next = null;
	}
	
	public void interleave(A3LinkedList other) {
		A3Node cur1 = this.head;
		A3Node cur2 = other.head;
		while (cur1 != null) {
			if (cur1.next != null) {
				A3Node tmp1 = cur1.next;
				A3Node tmp2 = cur2.next;
				cur1.next = tmp2;
				cur2.next = tmp1;
			}
			if (cur1.prev != null) {
				A3Node tmp1 = cur1.prev;
				A3Node tmp2 = cur2.prev;
				cur1.prev = tmp2;
				cur2.prev = tmp1;
			}
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		if (length % 2 == 0) {
			A3Node tmp1 = this.tail;
			A3Node tmp2 = other.tail;
			this.tail = tmp2;
			other.tail = tmp1;
		}
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from front to back
	 * Parameters: none
	 * Returns: nothing
	 */
	public String frontToBack() {
		String result = "{";
		A3Node cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	/*
	 * Purpose: return a string representation of the list 
	 *          when traversed from back to front
	 * Parameters: none
	 * Returns: nothing
	 */
	public String backToFront() {
		String result = "{";
		A3Node cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
}
	