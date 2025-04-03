import java.util.*;

class LinkedListPalindrom
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
		System.out.print("null\n");
	}

	static Node middleElement(Node head)
	{
		Node slow = head;
		Node fast = head;
		while(fast.next != null && fast.next.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow.next;
	}

	static Node reverseLL(Node head)
	{
		Node prev = null;
		Node cur = head;
		Node next = null;
		while(cur != null)
		{
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	static boolean checkPlaindrom(Node head1, Node head2)
	{
		Node cur1 = head1;
		Node cur2 = head2;
		while(cur2.next != null)
		{
			if(cur1.data != cur2.data) return false;
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return true;
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

		Node nhead = reverseLL(middleElement(head));
		
		displayLL(nhead);

		System.out.println(checkPlaindrom(head,nhead));
	}


}
