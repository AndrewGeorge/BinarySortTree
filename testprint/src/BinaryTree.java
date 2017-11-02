import java.awt.geom.CubicCurve2D;
import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree<E extends Comparable<E>>{
	private  Node<E> root;
	private Node<E> courrnetNode;
	
	public Node<E> getRoot(){
		return root;
	}
	
	/**
	 * 二叉排序树的插入
	 * @param value
	 */
	public void insertNode(E value){
		if (root==null) {
			root=new Node<E>(value);
			return;
		}
		courrnetNode=root;
		while (true) {
			if (value.compareTo(courrnetNode.value)>0) {
				if (courrnetNode.left==null) {
					courrnetNode.left=new Node<E>(value);
					break;
				}
				courrnetNode=courrnetNode.left;
			}else {
				if (courrnetNode.right==null) {
					courrnetNode.right=new Node<E>(value);
					break;
				}
				courrnetNode=courrnetNode.right;
			}
		}
	}
	
	/***
	 * 前序递归遍历二叉树
	 * @param root
	 */
	public void preDisplayTree(Node<E> root){
		Node<E> currentNode=root;
		System.out.println(currentNode.value+"");
		if (currentNode.left!=null) {
			preDisplayTree(currentNode.left);
		}
		if (currentNode.right!=null) {
			preDisplayTree(currentNode.right);
		}
		
	}
	/**
	 * 中序递归遍历二叉树
	 * @param root
	 */
	public void modDisplayTree(Node<E> root){
		Node<E> currentNode=root;
		if (currentNode.left!=null) {
			modDisplayTree(currentNode.left);
		}
		System.out.println(currentNode.value+"");
		if (currentNode.right!=null) {
			modDisplayTree(currentNode.right);
		}
	}
	
	/**
	 * 后序递归遍历二叉树
	 * @param root
	 */
	public void backDisplayTree(Node<E> root){
		Node<E> currentNode=root;
		if (currentNode.left!=null) {
			preDisplayTree(currentNode.left);
		}
		if (currentNode.right!=null) {
			preDisplayTree(currentNode.right);
		}
		System.out.println(currentNode.value+"");
	}
	
	/**
	 * 非递归用栈的方式前序
	 * @param root
	 */
	public void preDisplayTreeNoRecursion(Node<E> root){
		LinkedList< Node<E>> stack =new LinkedList<>();
		stack.push(root);
		Node<E> currentnode=null;
		while (!stack.isEmpty()) {
			currentnode=stack.pop();
			System.out.println(currentnode.value);
			if (currentnode.right!=null) {
				stack.push(currentnode.right);
			}
			if (currentnode.left!=null) {
				stack.push(currentnode.left);
			}
		}
	}
	
	
	/**
	 * 非递归用栈的方式中序
	 * @param root
	 */
	public void modDisplayTreeNoRecursion(Node<E> root){
		LinkedList< Node<E>> stack =new LinkedList<>();
		Node<E> currentnode=root;
		while (currentnode!=null||!stack.isEmpty()) {
			while (currentnode!=null) {
				stack.push(currentnode);
				currentnode=currentnode.left;
			}
			
			currentnode=stack.pop();
			System.out.println(currentnode.value);
			currentnode=currentnode.right;
				
		}
	}
	
	/**
	 * 非递归用栈的方式后序
	 * @param root
	 */
	public void backDisplayTreeNoRecursion(Node<E> root){
		LinkedList< Node<E>> stack =new LinkedList<>();
		Node<E> currentnode=root;
		Node<E> rightNode = null;
		
		while (currentnode!=null||!stack.isEmpty()) {
			while (currentnode!=null) {
				stack.push(currentnode);
				currentnode=currentnode.left;
			}
			
			currentnode=stack.pop();
			
			while (currentnode.right == null
					|| currentnode.right == rightNode) {
				System.out.println(currentnode.value + "");
				rightNode = currentnode;
				if (stack.isEmpty()) {
					return;
				}
				currentnode = stack.pop();
			}
			
			stack.push(currentnode);
			currentnode=currentnode.right;
				
		}
	}
	
	public void breadthFirstTraverse(Node<E> root){
		Queue<Node<E>> queue=new LinkedList<Node<E>>();
		queue.offer(root);
		Node<E> currentNode=null;
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
