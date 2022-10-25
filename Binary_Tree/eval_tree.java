
	class Node{
			String data;
			Node left, right;
			Node(){}
			Node(String d) {
				data = d;
				left = null;
				right = null;
			}
		}
		public class eval_tree{

			private static int toInt(String s) {
				int num = 0;
				
				if (s.charAt(0)!= '-')
					for (int i =0; i<s.length(); i++)
						num = num*10 + ((int)s.charAt(i)- 48);
				else
				{
					for (int i = 1; i< s.length(); i++)
						num = num*10 + ((int)(s.charAt(i)) - 48);
					num = num* -1;
				}
				return num;
			}
			
			public static int evalTree(Node root) {
				if (root == null)
					return 0;
				
				if (root.left==null && root.right == null)
					return toInt(root.data);
				
				int leftEval = evalTree(root.left);
				
				int rightEval = evalTree(root.right);
				
				if (root.data.equals("+"))
					return leftEval +rightEval;
				
				if (root.data.equals("-"))
					return leftEval - rightEval;
				
				if (root.data.equals("*"))
					return leftEval*rightEval;
				
				return leftEval / rightEval;
			}
			public static void main(String[] args) {
				Node root = new Node("+");
				root.left = new Node("*");
				root.left.left = new Node("5");
				root.left.right = new Node("4");
				root.right = new Node("-");
				root.right.left = new Node ("100");
				root.right.right = new Node("20");
				System.out.println(evalTree(root));
				
				root = null;
			
				
			}
		

	}


