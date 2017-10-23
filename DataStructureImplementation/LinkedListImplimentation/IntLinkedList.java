
public class IntLinkedList {

	Node head = null;
	Node tail = null;
	
	class Node {
		int data;
		Node next;
		
		Node (int item){
			data = item;
			next = null;
		}
	}
	
	public void printItemList() {
		Node temp = head;

		if (head == null) {
			System.out.print("\nNo elements in the LL");
			return;
		}

		System.out.print("\nItems of the list are " + temp.data + "\t");
		int count=1;
		while(temp.next!=null){
			temp = temp.next;
			count++;
			System.out.print(+ temp.data + "\t");

		}
		tail = temp;
		System.out.println("\nHead is:" + head.data + "\nTail is:" + temp.data);
		System.out.print("\n Total number of elements in ll are \t" + count);

	}
	
	public void insertAtFront(int item){
		Node newNode = new Node(item);
		if(head == null) {
			head = newNode;
			System.out.print("\nAt head item inserted  = " + head.data);
			return;
		}
		
		newNode.next = head;
		head = newNode;
		System.out.print("\nitem inserted = " + newNode.data);

	}

	public void insertAtEnd(int item) {
		Node newNode = new Node(item);
		if(head == null) {
			head = newNode;
			//System.out.print("\nAt head item inserted  = " + head.data);
			return;
		}
		
		Node temp = head; 
		while(temp.next != null) {
			temp = temp.next;
		}
		
		temp.next = newNode;
	}
	
	public void insertAtPosition(int item, int position) {
		Node newNode = new Node(item);

		if(position == 1) {
			insertAtFront(item);
			return;
		}
		
		int count = 1;
		Node temp = head;
		Node prev = head;
		
		while(temp.next != null && position!=count) {
			count++;
			prev = temp;
			temp = temp.next;
		}
		
		if(position==count) {
			prev.next = newNode;
			newNode.next = temp;
		}
		else {
			System.out.print("Please enter valid position");
		}
	}
	
	public void deleteAtFront() {
		if (head == null) {
			System.out.print("No elements in the list");
			return;
		}
		
		if (head.next == null) {
			head = null;
			return;
		}
		
		Node temp = head;
		temp = temp.next;
		head = temp;
			
	}
	
	public void deleteAtEnd() {
		if (head == null) {
			System.out.print("No elements in the list");
			return;
		}
		if (head.next == null) {
			head = null;
			return;
		}
		Node temp = head;
		Node prev = head;
		while(temp.next!= null) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = null;
	}
	
	public void deleteAtPosition(int position) {
		if (head == null) {
			System.out.print("\nNo elements in the list\n");
			return;
		}
		
		int count = 1;
		Node temp = head;
		Node prev = head;
		while(temp.next!=null && position!=count) {
			prev = temp;
			temp = temp.next;
			count++;
		}
		
		if(count == position) {
			prev.next = temp.next;
		}
	}
	
	public boolean searchItem(int item) {
		if(head == null) {
			System.out.print("\nLinked list is empty\n");
			return false;
		}
		
		Node temp = head;
		int found = 0;
		while (temp.next !=null) {
			if(temp.data == item) {
				found = 1;
				break;
			}
			temp = temp.next;
		}
		
		if(found == 1) {
			System.out.print("\nItem found\n");
			return true;
		}
		else {
			System.out.print("\nItem not found\n");
			return false;
		}
	}
	
	public void swapNodesOfPosition(){
		
	}
	
	public void partitionLLwithValue(int x){
		boolean found = false;
		Node cur = head;
		Node prev = null;
		Node temp = null;
		
		Node tempTail = tail;
				
		while (cur!=null||cur==tempTail) {
			if(cur.data == x){
				found = true;
				prev = cur;
				cur = cur.next;
			}
			else if(found && cur.data<x) {

				temp = cur;
				
				if(cur==tail) {
					prev.next = null;
					tail=prev;
					cur = null;
				}
				else {
					prev.next = cur.next;
					cur = prev.next;
				}
				temp.next = head;
				head = temp;
			}
			else if(cur.data>x && prev == null) {
				temp = cur;
				head = cur.next;
				cur = head;
				tail.next = temp;
				temp.next = null;
				tail = temp;
			}
			else if(cur.data>x && !found){
				temp = cur;
				prev.next = cur.next;
				tail.next = temp;
				temp.next = null;
				tail = temp;
				cur = prev.next;
			}
			else {
				prev = cur;
				cur = cur.next;
			}

		}
		
		if(!found) {
			System.out.println("The partition element is not found in the list");
		}
		else {
			System.out.println("List is altered");
		}
	}
}
