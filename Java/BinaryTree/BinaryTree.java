package DataStructure;

import java.util.Queue;
import java.util.Stack;

class NodeTree{
	int data;
	NodeTree left,right;
	NodeTree(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class BinaryTree {
	
	 //1.InOrder Traversal
	public void InorderTraversalRecursive(NodeTree root){
		if(root == null) {
			return;
		} 
		 InorderTraversalRecursive(root.left);
		 System.out.print(root.data + "->");
		 InorderTraversalRecursive(root.right);
	}
	public void InOrderTraversalIterative(NodeTree root) {
		if(root == null) {
			return;
		}
		Stack<NodeTree> st = new Stack<NodeTree>();
		while(root != null) {
			st.push(root);
			root = root.left;
		}
		while(st.size()>0) {
			NodeTree t = st.pop();
			System.out.print(t.data+"->");
			if(t.right != null) {
				NodeTree temp = t.right;
				while(temp!= null) {
					st.push(temp);
					temp = temp.left;
				}
			}
		}
	}
	//2.PreOrder Traversal
	public void PreOrderTraversalRecursive(NodeTree root){
		 if(root == null) {
			 return;
		 }
		 System.out.print(root.data+"->");
		 PreOrderTraversalRecursive(root.left);
		 PreOrderTraversalRecursive(root.right);
	}
	public void PreOrderTraversalIterative(NodeTree root) {
		if(root == null) {
			return;
		}
		Stack<NodeTree> st = new Stack<NodeTree>();
		st.add(root);
		
		while(st.size() > 0) {
			NodeTree t = st.pop();
			System.out.print(t.data + "->");
			
			if(t.right != null) {
				st.push(t.right);
			}
			
			if(t.left != null) {
				st.push(t.left);
			}
		}
	}
	//3.
	public void PostOrderTraversal(NodeTree root){
		if(root == null) {
			 return;
		 }
		 PostOrderTraversal(root.left);
		 PostOrderTraversal(root.right);
		 System.out.print(root.data+"->");
	}
	public void PostOrderTraversalIterative(NodeTree root) {
		if(root == null) {
			return;
		}
		Stack<NodeTree> s1 = new Stack<NodeTree>();
		Stack<NodeTree> s2 = new Stack<NodeTree>();
		
		s1.push(root);
		
		while(s1.size()>0) {
			NodeTree t = s1.pop();
			
			if(t.left != null) {
				s1.push(t.left);
			}
			if(t.right!=null) {
				s1.push(t.right);
			}
		s2.push(t);
		}
		while(s2.size() > 0) {
			System.out.print(s2.pop().data + "->");
		}
	}
	//4.
	public int sumOfAllNodeTree(NodeTree root) {
		if(root == null) {
			return 0 ;
		}
		System.out.println(root.data + sumOfAllNodeTree(root.left) + sumOfAllNodeTree(root.right));
		return root.data + sumOfAllNodeTree(root.left) + sumOfAllNodeTree(root.right);
	}
	//5.
	public int differencebetweenEvenAndOddLevel(NodeTree root) {
		if(root == null) {
			return 0 ;
		}
		return root.data - differencebetweenEvenAndOddLevel(root.left) - differencebetweenEvenAndOddLevel(root.right);
	}
	//6.
	public int numberOfNodeTree(NodeTree root) {
		if(root == null) {
			return 0 ;
		}
		return 1 + numberOfNodeTree(root.left) + numberOfNodeTree(root.right);
	}
	//7.
	public int getNumberOfLeafNodeTree(NodeTree root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		return getNumberOfLeafNodeTree(root.left) + getNumberOfLeafNodeTree(root.right);
	}
	
	//8.
	public int heightOfTree(NodeTree root) {
		if(root==null) {
			return -1;
		}
		return max(heightOfTree(root.left),heightOfTree(root.right)) + 1;
	}
	private int max(int a , int b) {
		return a > b ? a : b;
	}
	//9.
	public void printNodeTreeAtAGivenLevel(NodeTree root,int level) {
		if(root == null) {
			return;
		}
		if(level == 1) {
			System.out.print(root.data + "->");
			return ;
		}
		printNodeTreeAtAGivenLevel(root.left, level-1);
		printNodeTreeAtAGivenLevel(root.right, level-1);
	}
	//10.1=O(n2)
	public void PrintAllTheNodeTreesLevelWise(NodeTree root) {
		if(root == null) {
			return;
		}
		int height = heightOfTree(root);
		for(int i = 0; i <= height; i++) {
			printNodeTreeAtAGivenLevel(root,i+1);
			System.out.println();
		}
	}
	public void PrintAllTheNodeTreesLevelWiseIteration(NodeTree root) {
		if(root==null) {
			return;
		}
		Queue<NodeTree> q = new java.util.LinkedList<NodeTree>();
		q.add(root);
		
		while(true) {
			int count = q.size();
			if(count == 0)
				break;
			
			while(count > 0) {
				NodeTree top = q.remove();
				System.out.print(top.data + " ");
				
				if(top.left != null) {
					q.add(top.left);
				}
				if(top.right != null) {
					q.add(top.right);
				}
				count--;
			}
			System.out.println();
		}
	}
	//11.
	public void PrintAllTheNodeLevelWiseInReverse(NodeTree root) {
		if(root == null ) {
			return;
		}
		int height = heightOfTree(root);
		for(int i = height+1;i>=0;i--) {
			printNodeTreeAtAGivenLevel(root,i);
			System.out.println();
		}
	}
	public void PrintAllTheNodeLevelWiseInReverseIteration(NodeTree root) {
		if(root == null) {
			return;
		}
		Queue<NodeTree> q = new java.util.LinkedList<NodeTree>();
		   q.add(root);
		Stack<NodeTree> st = new Stack<NodeTree>();
		
		while(q.size()>0) {
			NodeTree temp = q.remove();
			
			if(temp.right!=null) {
				q.add(temp.right);
			}
			if(temp.left != null) {
				q.add(temp.left);
			}
			st.push(temp);
		}
		while(st.size()>0) {
			System.out.print(st.pop().data + "->");
		}
	}
	//12.left view of the tree
	int maxlevel;
	public void LeftViewOfTree(NodeTree root, int level) {
		if(root == null) {
			return;
		}
		if(level >= maxlevel) {
			System.out.println(root.data + " ");
			maxlevel++;
		}
		LeftViewOfTree(root.left, level+1);
		LeftViewOfTree(root.right, level+1);
	}
	//13.Right view of a tree
	int maxlvl;
	public void RightViewOfTree(NodeTree root,int level) {
		if(root==null) {
			return;
		}
		if(level >= maxlvl) {
			System.out.print(root.data + " ");
			maxlvl++;
		}
		
		RightViewOfTree(root.right, level+1);
		RightViewOfTree(root.left, level+1);
	}
	//14.
	public void ConvertTreeIntoItsMirrorTree(NodeTree root) {
		if(root==null) {
			return;
		}
		NodeTree temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		ConvertTreeIntoItsMirrorTree(root.left);
		ConvertTreeIntoItsMirrorTree(root.right);
	}
	//15.
	public boolean CheckForIdentical(NodeTree root1 , NodeTree root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		if(root1 == null || root2 == null) {
			return false;
		}
		return root1.data == root2.data && CheckForIdentical(root1.left, root2.left) && CheckForIdentical(root1.right, root2.right);
	}
	//16.Get Level of a given node
	public void GetLevelOfGivenNode(NodeTree root) {
		
	}int sum = 0;
	
    public int rangeSumBST(NodeTree root, int L, int R) {
       if(root == null)  return 0;
       
       if(root.data >= L && root.data <= R) {
    	   return root.data + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
       } else if(root.data > L ){
    	   return rangeSumBST(root.left, L, R);
       } else if(root.data < R) {
    	   return rangeSumBST(root.right, L, R);
       }
       return 0;
    }
	public static void main(String[] args) {
		/*NodeTree root = new NodeTree(12);
		root.left = new NodeTree(7);
		root.left.left = new NodeTree(2);
		root.left.right = new NodeTree(6);
		root.left.right.left = new NodeTree(5);
		root.left.right.right = new NodeTree(11);
		root.right = new NodeTree(5);
		root.right.right = new NodeTree(9);
		root.right.right.left = new NodeTree(4);*/
		
		NodeTree root = new NodeTree(10);
		root.left = new NodeTree(5);
		root.left.left = new NodeTree(3);
		root.left.right = new NodeTree(7);
		root.right = new NodeTree(15);
		root.right.right = new NodeTree(18);	
		
		
		BinaryTree tree = new BinaryTree();
		//System.out.println("Inorder Traversal");  tree.InorderTraversal(root); System.out.println();
		//System.out.println("Inorder Traversal");  tree.InOrderTraversalIterative(root);
		//System.out.println("PreOrder Traversal"); tree.PreOrderTraversalRecursive(root); System.out.println();
		//System.out.println("PreOrder Traversal"); tree.PreOrderTraversalIterative(root);
		//System.out.println("Postorder Traversal"); tree.PostOrderTraversal(root); System.out.println();
		//System.out.println("Postorder Traversal"); tree.PostOrderTraversalIterative(root);
		//System.out.println("Sum of all NodeTree : " + tree.sumOfAllNodeTree(root));
		//System.out.println(" Difference between Even and Odd Level : " + tree.differencebetweenEvenAndOddLevel(root));
		//System.out.println("NUmber of NodeTrees : " + tree.numberOfNodeTree(root));
		//System.out.println("Number of Leaf NodeTrees are : " + tree.getNumberOfLeafNodeTree(root));
		System.out.println("Height of Tree : " + tree.heightOfTree(root));
		//System.out.print("Printing NodeTrees at a Given Level : "); tree.printNodeTreeAtAGivenLevel(root,2);
		//tree.PrintAllTheNodeTreesLevelWise(root);
		//tree.PrintAllTheNodeTreesLevelWiseIteration(root);
		//tree.PrintAllTheNodeLevelWiseInReverse(root);
		//tree.PrintAllTheNodeLevelWiseInReverseIteration(root);
		//tree.LeftViewOfTree(root,0);
		//tree.RightViewOfTree(root,0);
		//tree.ConvertTreeIntoItsMirrorTree(root);
	    //System.out.println(	tree.CheckForIdentical(root, root2) );
        //System.out.println(tree.rangeSumBST(root,7,15) );
		
	}
	
}
