import java.util.*;

class LinkedListImplementation
{
	static class Node
	{
		int data;
		Node next;
		Node(int d)
		{
			this.data = d;
			this.next = null;
		}
	}

	static Node head;

	static void insertAtEnd(int d)
	{
		Node newn = new Node(d);

		if(head == null)
		{
			head = newn;
		}
		else
		{
			Node cur = head;
			while(cur.next != null)
			{
				cur = cur.next;
			}
			cur.next = newn;
		}
	}

	static void displayLL(Node head)
	{
		Node cur = head;
		while(cur != null)
		{
			System.out.print(cur.data + " --> ");
			cur = cur.next;
		}
		System.out.print("null");
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i ++)
		{
			insertAtEnd(sc.nextInt());
		}
		displayLL(head);
	}
}
