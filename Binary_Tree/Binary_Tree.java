import java.util.Arrays;
class Node{
	  int value;
	  Node left;
	  Node right;
	  Node(int value){
	    this.value = value;
	    left = null;
	    right = null;        
	  }
	}
class Tree{
			  Node node;
			  Tree(int value){
			    node = new Node(value);
			  }
			  public Node insert(Node node, int value){
			    if(node == null){
			      return new Node(value);
			    }
			    // Move to the left if passed value is 
			    // less than the current node
			    if(value < node.value){
			      node.left = insert(node.left, value);
			    }
			    else if(value > node.value){
			        node.right = insert(node.right, value);
			      }
			      return node;
			    }
			      
			    // For traversing in order
			    public void inOrder(Node node){
			      if(node != null){
			        inOrder(node.left);
			        System.out.print(node.value + " ");
			        inOrder(node.right);
			      }
			    }
			      
			    public void inOrderDesc(Node node){
			      if(node != null){
			        inOrderDesc(node.right);
			        System.out.print(node.value + " ");
			        inOrderDesc(node.left);
			      }
			    }
			    public static void main(String[] args) {
			    	 int[] arr = {51, 33, 77, 15, 7, 63, 22, 35, 85, 22, 32};
					    System.out.println("The Original array is- "+Arrays.toString(arr));
					    Tree tree = new Tree(arr[0]);
					    for(int num : arr){
					        tree.insert(tree.node, num);
					    }
					    System.out.println("Sorted Array in ascending order is- ");
					    tree.inOrder(tree.node);
					    System.out.println();
					    System.out.println("Sorted Array in Descending order is - ");
					    tree.inOrderDesc(tree.node);
			    }
			  }

	


