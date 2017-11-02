
public class Node<E extends Comparable<E>> {
	E value;
	Node<E> left;
	Node<E> right;

	public Node(E value) {
		this.value = value;
		left = null;
		right = null;
	}
}
