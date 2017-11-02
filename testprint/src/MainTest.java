public class MainTest {
	public static void main(String args[]) {
		// Singletn singleton = Singletn.getSingletion();
		// System.out.println("counter1="+singleton.couremt1);
		// System.out.println("counter2="+singleton.couremt2);
		BinarySortTree<Integer> treey=new BinarySortTree<Integer>();
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		 tree.insertNode(35);  
	        tree.insertNode(20);  
	        tree.insertNode(15);  
	        tree.insertNode(16);  
	        tree.insertNode(29);  
	        tree.insertNode(28);  
	        System.out.println("先序遍历（递归）：");
	        tree.preDisplayTree(tree.getRoot());
	        System.out.println();  
	        
	        System.out.println("先序遍历（非递归）：");
	        tree.preDisplayTreeNoRecursion(tree.getRoot());
	        System.out.println();  
	        
	        System.out.println("先序遍历（验证递归）：");
	        treey.preOrderTraverseNoRecursion(tree.getRoot());
	        System.out.println(); 
	        
	        
	        
	        
	        
	        System.out.println("中序序遍历（递归）：");
	        tree.modDisplayTree(tree.getRoot());
	        System.out.println();  
	        
	        System.out.println("中序遍历（非递归）：");
	        tree.modDisplayTreeNoRecursion(tree.getRoot());
	        System.out.println();  
	        
	        System.out.println("中序遍历（验证递归）：");
	        treey.minOrderTraverseNoRecursion(tree.getRoot());
	        System.out.println(); 
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
		
//		System.out.println("先序遍历（递归）：");  
//        tree.preOrderTraverse(tree.getRoot());  
//        System.out.println();  
//        System.out.println("中序遍历（递归）：");  
//        tree.minOrderTraverse(tree.getRoot());  
//        System.out.println();  
//        System.out.println("后序遍历（递归）：");  
//        tree.backOrderTraverse(tree.getRoot());  
//        System.out.println();  
//          
//        System.out.println("先序遍历（非递归）：");  
//        tree.preOrderTraverseNoRecursion(tree.getRoot());  
//        System.out.println();  
//        System.out.println("中序遍历（非递归）：");  
//        tree.minOrderTraverseNoRecursion(tree.getRoot());  
//        System.out.println();  
//        System.out.println("后序遍历（非递归）：");  
//        tree.backOrderTraverseNoRecursion(tree.getRoot());  
//        System.out.println();  
//          
//        System.out.println("广度优先遍历：");  
//        tree.breadthFirstTraverse(tree.getRoot()); 
	}
}
