import java.util.ArrayList;
import java.util.Random;

public class interval_scheduling {
    public static class Node {
        int start; // start time of task
        int end; // end time of task
        int priority; // end time as priority
        Node left;
        Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.priority = end;
        }
    }

    public static Node create(ArrayList<Node> tasks) {
        Random rand = new Random();
        return create(tasks, 0, tasks.size() - 1, rand);
    }

    private static Node create(ArrayList<Node> tasks, int l, int r, Random rand) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        Node curr = tasks.get(mid);
        curr.left = create(tasks, l, mid - 1, rand);
        curr.right = create(tasks, mid + 1, r, rand);
        curr.priority = rand.nextInt(); // set random priority
        return curr;
    }

    public static void schedule(Node root) {
        if (root == null) return;
        schedule(root.left);
        System.out.println("Task: " + root.start + "-" + root.end + ", Priority: " + root.priority);
        schedule(root.right);
    }

    public static void main(String[] args) {
        ArrayList<Node> tasks = new ArrayList<>();
        tasks.add(new Node(1, 2));
        tasks.add(new Node(3, 4));
        tasks.add(new Node(0, 6));
        tasks.add(new Node(5, 7));
        tasks.add(new Node(8, 9));

        Node root = create(tasks);
        schedule(root);
    }
}
