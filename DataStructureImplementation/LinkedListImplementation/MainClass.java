
public class MainClass {
	public static void main(String [] args){
		IntLinkedList ll = new IntLinkedList();
		
		ll.insertAtEnd(8);
		ll.insertAtEnd(3);
		ll.insertAtEnd(30);

		ll.insertAtEnd(15);
		ll.insertAtEnd(4);
		ll.insertAtEnd(40);
		ll.insertAtEnd(20);
		
		ll.printItemList();
		
		
//		ll.insertAtEnd(15);
//		ll.printItemList();
//
//		ll.insertAtPosition(20, 1);
//		ll.insertAtPosition(25, 3);
//		ll.insertAtPosition(30, 10);
//		ll.printItemList();
//
//		ll.deleteAtFront();
//		ll.printItemList();
//		ll.deleteAtPosition(2);
//		ll.printItemList();
//		ll.deleteAtEnd();
//		ll.printItemList();		
		
		ll.partitionLLwithValue(15);
		
		ll.printItemList();

	}
}
