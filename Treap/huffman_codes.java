import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

class TreapNode {
    char data;
    int priority;
    TreapNode left, right;
    public TreapNode(char data, int priority) {
        this.data = data;
        this.priority = priority;
        this.left = null;
        this.right = null;
}

}

class HuffmanTreap {
    TreapNode root;
// Function to build the Huffman tree
    public TreapNode buildHuffmanTree(Map<Character, Integer> frequencyMap) {
        PriorityQueue<TreapNode> priorityQueue = new PriorityQueue<>((l, r) -> l.priority - r.priority);

    // Insert all the characters into the priority queue
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.offer(new TreapNode(entry.getKey(), entry.getValue()));
        }

    // Build the Huffman tree
        while (priorityQueue.size() > 1) {
            TreapNode left = priorityQueue.poll();
            TreapNode right = priorityQueue.poll();
            
            int priority = left.priority + right.priority;
            TreapNode parent = new TreapNode('\0', priority);
            parent.left = left;
            parent.right = right;
            
            priorityQueue.offer(parent);
    }
    
    return priorityQueue.poll();
}

// Function to print the Huffman codes
    public void printHuffmanCodes(TreapNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            System.out.println(root.data + ": " + sb);
            
            return;
    }

    sb.append("0");
    printHuffmanCodes(root.left, sb);
    sb.deleteCharAt(sb.length() - 1);

    sb.append("1");
    printHuffmanCodes(root.right, sb);
    sb.deleteCharAt(sb.length() - 1);
}

}

public class huffman_codes {
public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter the string input to be inserted in the Treap: ");
    String input = scan.nextLine();
    // String input = "Sachin sir";
    // Count the frequency of each character in the input string
    Map<Character, Integer> frequencyMap = new HashMap<>();
    for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
    }

    HuffmanTreap huffmanTreap = new HuffmanTreap();
    TreapNode root = huffmanTreap.buildHuffmanTree(frequencyMap);

    System.out.println("Huffman codes for the input string: ");
    huffmanTreap.printHuffmanCodes(root, new StringBuilder());
}
}
