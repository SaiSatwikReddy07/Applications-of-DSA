import java.util.Scanner;

class TreapNode {
    String data;
    int priority;
    TreapNode left, right;
    TreapNode(String data, int priority) {
        this.data = data;
        this.priority = priority;
        left = right = null;
    }
}

class Treap {
    TreapNode root;
    Treap() {
        root = null;
    }
    
    public void insert(String data) {
        root = insertRec(root, data);
    }
    
    public TreapNode insertRec(TreapNode root, String data) {
        if (root == null) {
            return new TreapNode(data, (int) (Math.random() * 100));
        }
    
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
            if (root.left.priority > root.priority) {
                root = rightRotate(root);
            }
        } else {
            root.right = insertRec(root.right, data);
            if (root.right.priority > root.priority) {
                root = leftRotate(root);
            }
        }
    
        return root;
    }
    // left child & root node
    public TreapNode rightRotate(TreapNode root) {
        TreapNode newRoot = root.left;
        root.left = newRoot.right;
        newRoot.right = root;
        return newRoot;
    }
    // right child & root node
    public TreapNode leftRotate(TreapNode root) {
        TreapNode newRoot = root.right;
        root.right = newRoot.left;
        newRoot.left = root;
        return newRoot;
    }
    
    public boolean search(String data) {
        return searchRec(root, data);
    }
    
    public boolean searchRec(TreapNode root, String data) {
        if (root == null) {
            return false;
        }
    
        if (root.data.equals(data)) {
            return true;
        }
    
        if (data.compareTo(root.data) < 0) {
            return searchRec(root.left, data);
        } else {
            return searchRec(root.right, data);
        }
    }
}

public class text_search_algo{
    public static void main(String[] args) {
        Treap treap = new Treap();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the text to be inserted in the Treap: ");
        String text = scan.nextLine();
        String[] words = text.split(" ");
        
        for (String word : words) {
            treap.insert(word);
        }
        System.out.println("Enter the word to be searched in the Treap: ");
        String searchWord = scan.nextLine();
        
        if (treap.search(searchWord)) {
            System.out.println("The word '" + searchWord + "' is present in the Treap.");
        } 
        else {
            System.out.println("The word '" + searchWord + "' is not present in the Treap.");
        }
    }
}
    

