
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraverseTest {
	
//	public static void main(String[] args) {
//	
//		BinarySortTree<Integer> binarySortTree=new BinarySortTree<Integer>();
//	}
		
	/**
	 * node
	 */
	class Node<E extends Comparable<E>> {
		E value;
		Node<E> left;
		Node<E> right;

		public Node(E value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

	class BinarySortTree<E extends Comparable<E>> {
		private Node<E> root;

		public BinarySortTree() {
			root = null;
		}

		public void insertNode(E value) {
			if (root == null) {
				root = new Node<E>(value);
				return;
			}
			Node<E> currentNode = root;
			while (true) {
				if (value.compareTo(currentNode.value) > 0) {
					if (currentNode.right == null) {
						currentNode.right = new Node<E>(value);
						break;
					}
					currentNode = currentNode.right;
				} else {
					if (currentNode.left == null) {
						currentNode.left = new Node<E>(value);
						break;
					}
					currentNode = currentNode.left;
				}
			}
		}

		public Node<E> getRoot() {
			return root;
		}

		// 前序(先序)遍历二叉树----递归
		public void preOrderTraverse(Node<E> node) {
			System.out.println(node.value + "");
			if (node.left != null) {
				preOrderTraverse(node.left);
			}
			if (node.right != null) {
				preOrderTraverse(node.right);
			}
		}

		// 中序遍历二叉树----递归
		public void minOrderTraverse(Node<E> node) {

			if (node.left != null) {
				preOrderTraverse(node.left);
			}
			System.out.println(node.value + "");
			if (node.right != null) {
				preOrderTraverse(node.right);
			}
		}

		// 后序遍历二叉树----递归
		public void backOrderTraverse(Node<E> node) {
			if (node.left != null) {
				preOrderTraverse(node.left);
			}
			if (node.right != null) {
				preOrderTraverse(node.right);
			}
			System.out.println(node.value + "");
		}

		/***
		 * 非递归前序遍历二叉树
		 * 
		 * @param root
		 */
		public void preOrderTraverseNoRecursion(Node<E> root) {
			LinkedList<Node<E>> stack = new LinkedList<Node<E>>();
			Node<E> currentNode = null;
			stack.push(root);
			while (!stack.isEmpty()) {
				currentNode = stack.pop();
				System.out.println(currentNode.value + "");
				if (currentNode.right != null) {
					stack.push(currentNode.right);
				}
				if (currentNode.left != null) {
					stack.push(currentNode.left);
				}
			}
		}

		/***
		 * 非递归中序遍历二叉树
		 * 
		 * @param root
		 */
		public void minOrderTraverseNoRecursion(Node<E> root) {
			LinkedList<Node<E>> stack = new LinkedList<Node<E>>();
			Node<E> currentNode = null;
			// 找到最左边的子节点
			while (currentNode != null || !stack.isEmpty()) {
				while (currentNode != null) {
					stack.push(currentNode);
					currentNode = currentNode.left;
				}
				currentNode = stack.pop();
				System.out.println(currentNode.value + "");
				stack.push(currentNode.right);
			}
		}

		/***
		 * 非递归后序遍历二叉树
		 * 
		 * @param root
		 */
		public void backOrderTraverseNoRecursion(Node<E> root) {
			LinkedList<Node<E>> stack = new LinkedList<Node<E>>();
			Node<E> currentNode = root;
			Node<E> rightNode = null;
			// 找到最左边的子节点
			while (currentNode != null || !stack.isEmpty()) {
				while (currentNode != null) {
					stack.push(currentNode);
					currentNode = currentNode.left;
				}

				currentNode = stack.pop();

				while (currentNode.right == null
						|| currentNode.right == rightNode) {
					System.out.println(currentNode.value + "");
					rightNode = currentNode;
					if (stack.isEmpty()) {
						return;
					}
					currentNode = stack.pop();
				}
				stack.push(currentNode);
				
				currentNode = currentNode.right;
			}
		}
		
		public void breadthFirstTraverse(Node<E> root) { 
			Queue<Node<E>>  queue=new LinkedList<Node<E>>();
			Node<E> currentNode=null;
			queue.offer(root);
			while (!queue.isEmpty()) {
				currentNode=queue.poll();
				System.out.println(currentNode.value+"");
				if (currentNode.left!=null) {
					queue.offer(currentNode.left);
				}
				if (currentNode.right!=null) {
					queue.offer(currentNode.right);
				}
			}
		}
	}
}
