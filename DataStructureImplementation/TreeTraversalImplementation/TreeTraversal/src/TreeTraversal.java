import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

class Node {
	int key;
	Node left,right;

	public Node(int item) {
		key = item;
		left = right = null;
	}
}
public class TreeTraversal {

	Node root;

	TreeTraversal(){
		root = null;
	}

	public void insert(int key) {
		root = insertNode(root,key);
	}

	//Recursive function to insert a new key in BST
	public Node insertNode(Node root,int key) {
		//if tree is empty insert root and return root
		System.out.println("Item to be inserted:" + key);

		if(root == null) {
			root = new Node(key);
			System.out.println("Root inserted:" + key);
			return root;
		}
		//insert to the left of the node
		if(key<root.key) {
			root.left = insertNode(root.left,key);
		}
		//insert to the right of the node 
		if(key>root.key){
			root.right = insertNode(root.right,key);
		}

		System.out.println("Item inserted:" + key);
		return root;
	}

	public void deleteNode(Node root,int key) {

	}
	
	int height(Node root) {
		if(root == null)
			return 0;
		else {
			int lheight = height(root.left);
			int rheight = height(root.right);
			
			if(lheight>rheight)
				return(lheight+1);
			else
				return(rheight+1);
		}
	}
	
	void printLevelOrder() {
		System.out.println("\nLevel order Traversal recursive");
		int h = height(root);
		for(int i =0;i<=h;i++) {
			printGivenLevelRecursive(root,i);
		}
		
		System.out.println("\nLevel order Traversal Iterative");
		levelOrderIterative(root);
	}

	void printGivenLevelRecursive(Node root,int level) {
		if(root == null) 
			return;
		if(level == 1)
			System.out.print(root.key + " ");
		else if(level>1) {
			printGivenLevelRecursive(root.left,level-1);
			printGivenLevelRecursive(root.right,level-1);
		}
	}
	
	void levelOrderIterative(Node root) {
		if (root!=null) {
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(root);
			
			while(!queue.isEmpty()) {
				Node tempNode = queue.poll();
				System.out.print(tempNode.key + " ");
				
				if(tempNode.left!=null)
					queue.add(tempNode.left);
				if(tempNode.right!=null)
					queue.add(tempNode.right);
			}
		}
	}
	
	
	void printInOrder() {
		System.out.println("\nInorder Traversal recursive");
		inOrderRecursive(root);
		
		System.out.println("\nInorder Traversal iterative");
		inOrderIterative(root);
	}
	void inOrderRecursive(Node root) {
		if(root!=null) {
			inOrderRecursive(root.left);
			System.out.print(root.key + " ");
			inOrderRecursive(root.right);
		}
	}
	void inOrderIterative(Node root) {
		if(root!=null){
			Stack<Node> stack = new Stack<Node>();
			Node node = root;

			//first node to be visited will be the left one
			while (node != null) {
				stack.push(node);
				node = node.left;
			}

			// traverse the tree
			while (stack.size() > 0) {

				// visit the top node
				node = stack.pop();
				System.out.print(node.key + " ");
				if (node.right != null) {
					node = node.right;

					// the next node to be visited is the leftmost
					while (node != null) {
						stack.push(node);
						node = node.left;
					}
				}
			}
		}
	}

	void printPreOrder() {
		System.out.println("\nPreOrder Traversal");
		preOrderRecursive(root);
		
		System.out.println("\nPreOrder Traversal iterative");
		preOrderIterative(root);
	}
	
	void preOrderRecursive(Node root) {
		if(root!=null) {
			System.out.print(root.key + " ");
			preOrderRecursive(root.left);
			preOrderRecursive(root.right);
		}
	}
	void preOrderIterative(Node root) {
		if(root!=null){
			Stack<Node> stack = new Stack<Node>();
			stack.push(root);

			/* Pop all items one by one. Do following for every popped item
		         a) print it
		         b) push its right child
		         c) push its left child
		         Note that right child is pushed first so that left is processed first */
			while (stack.empty() == false) {

				// Pop the top item from stack and print it
				Node mynode = stack.peek();
				System.out.print(mynode.key + " ");
				stack.pop();

				// Push right and left children of the popped node to stack
				if (mynode.right != null) {
					stack.push(mynode.right);
				}
				if (mynode.left != null) {
					stack.push(mynode.left);
				}
			}
		}
	}

	void printPostOrder() {
		System.out.println("\nPostOrder Traversal");
		postOrderRecursive(root);
	}
	void postOrderRecursive(Node root) {
		if(root!=null) {
			postOrderRecursive(root.left);
			postOrderRecursive(root.right);
			System.out.print(root.key + " ");
		}
	}
	void postOrderIterative(Node root) {

	}

	public static void main(String[] args) {
		TreeTraversal tree = new TreeTraversal();

		/*           50
		 *          /  \
		 * 		   30	70
		 * 		 /  \   /  \
		 * 		20  40 60  80
		 */

		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);

		tree.printLevelOrder();
		tree.printInOrder();
		tree.printPreOrder();
		tree.printPostOrder();

	}

}
