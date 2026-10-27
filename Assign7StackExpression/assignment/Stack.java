package assignment;

public class Stack<T> implements StackInterface<T> {
	
	private Node<T> HEAD;
	private int size;
	
	public Stack() {
		this.HEAD = null;
		this.size = 0;
	}

	@Override
	public void push(T item) {
		Node newNode = new Node(item);		
		newNode.next = this.HEAD;
		this.HEAD = newNode;
		this.size++;
	}

	@Override
	public T pop() {
		Node node = this.HEAD;
		this.HEAD = this.HEAD.next;
		this.size--;
		return (T) node.value;
	}

	@Override
	public T peek() {
		return this.HEAD.value;
	}

	@Override
	public boolean isEmpty() {
		return this.HEAD == null;
	}

	@Override
	public int size() {
		return this.size;
	}

}
