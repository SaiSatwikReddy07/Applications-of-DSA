
//Java code to recursively insert a node and recursively print the list.

// Create class Recursion_Using_Linked_List 
public class Recursion_Using_Linked_List {

	// We create a static class Node
	static class Node
	{
		// For data
		int data;
		
		// For the next node
		Node next;
	};

	//We create a static Node newNode with input as data
	// It allocates a new node with given data
	static Node newNode(int data)
	{
		// Creating a new node
		Node new_node = new Node();
		// Giving the data for the new node
		new_node.data = data;
		// Pointing the next of the new node to null
		new_node.next = null;
		
		// We return the new node created
		return new_node;
	}

	//We create a static Node insertEnd with input as head of the node and the data
	//Function to insert a new node at the end of linked list using recursion.
	static Node insertEnd(Node head, int data)
	{
		// If linked list is empty, we create a new node ie; newNode() allocates a new node with given data.
		if (head == null)
			return newNode(data);

		// Else, when we have not reached end, keep traversing recursively.
		else
			// The head will point to the next node by calling the insertEnd function by giving head.next and the data as the inputs
			head.next = insertEnd(head.next, data);
		
		//We return head
		return head;
	}

	//We create a static void traverse with input as head of the node
	static void traverse(Node head)
	{
		// If linked list is empty, we return
		if (head == null) {
		return;
		}
		else {
		
		// Else, when the head is not null, print current node and recur for remaining list ie; we call the traverse function recursively with input as head.next
		System.out.print( head.data + " --> ");

		traverse(head.next);
		}
		
	}

	//Main code
	public static void main(String args[])
	{
		// We initialize head to null
		Node head = null;
		
		//  We call insertEnd Function with input as the head and the data.
		head = insertEnd(head, 1);
		head = insertEnd(head, 2);
		head = insertEnd(head, 3);
		head = insertEnd(head, 4);
		head = insertEnd(head, 5);
		head = insertEnd(head, 6);
		head = insertEnd(head, 7);
		head = insertEnd(head, 8);
		head = insertEnd(head, 9);
		head = insertEnd(head, 10);
		
		// We call the traverse function with head as the input argument
		traverse(head);
		
		// Print the final NULL node.
		System.out.print("NULL");
	}

}
