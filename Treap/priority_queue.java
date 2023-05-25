import java.util.Random;

class Task {
    int priority;
    String name;

    Task(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }
}

class PriorityQueue {
    Node root;

    class Node {
        Task task;
        int priority;
        Node left, right;

        Node(Task task) {
            this.task = task;
            this.priority = new Random().nextInt();
        }
    }

    void addTask(Task task) {
        root = addTask(root, task);
    }

    Node addTask(Node node, Task task) {
        if (node == null) {
            return new Node(task);
        }

        if (task.name.compareTo(node.task.name) < 0) {
            node.left = addTask(node.left, task);
            if (node.left.priority > node.priority) {
                node = rightRotate(node);
            }
        } else {
            node.right = addTask(node.right, task);
            if (node.right.priority > node.priority) {
                node = leftRotate(node);
            }
        }

        return node;
    }

    Node leftRotate(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        return newRoot;
    }

    Node rightRotate(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        return newRoot;
    }

    void printQueue() {
        inorder(root);
    }

    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.task.name + " - Priority: " + node.task.priority);
            inorder(node.right);
        }
    }
}

public class priority_queue {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();
        queue.addTask(new Task(1, "Write report"));
        queue.addTask(new Task(3, "Attend meeting"));
        queue.addTask(new Task(2, "Complete project"));
        queue.addTask(new Task(4, "Prepare presentation"));
        System.out.println("Task List:");
        queue.printQueue();
    }
}

