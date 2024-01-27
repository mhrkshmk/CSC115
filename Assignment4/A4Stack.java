public class A4Stack<T> implements Stack<T> {
	private A4Node<T> head;

	public A4Stack() {
		head = null;
	}
	
	public void push(T value) {
		A4Node tmp_node = new A4Node(value);
		if (head == null) {
			head = tmp_node;
			return;
		}
		tmp_node.next = head;
		head = tmp_node;
	}

	public T pop() {
		if (head == null) return null;
		A4Node<T> tmp_node = new A4Node(head.getData());
		head = head.next;
		return tmp_node.getData();
	}

	public boolean isEmpty() {
		return head == null;
	}

	public T top() {
		return head.getData();
	}

	public void popAll() {
		while (!isEmpty()) {
			pop();
		}
	}
}