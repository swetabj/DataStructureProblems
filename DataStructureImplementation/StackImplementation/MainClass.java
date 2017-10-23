
import java.util.Scanner;

public class MainClass {
	public static void main(String args[]){

		int size;
		int choice = 1;
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter the size of the array");
		size = s.nextInt();
		
		Stack myStack = new Stack(size);

		String str = "Y";
		int pushElement;
		
		while(true) {
			
			System.out.println("Enter choice:\n 1:Push\n 2:Pop\n 3:CheckTop");
			choice = s.nextInt();
			
			switch (choice) {
		
			case 1:
				System.out.println("Enter the element to be pushed:");
				pushElement = s.nextInt();
				myStack.push(pushElement);
				myStack.displayStack();
				break;
			case 2:
				myStack.pop();
				myStack.displayStack();
				break;
			
			case 3:
				myStack.topElement();
				myStack.displayStack();
				break;
			
			default:
				System.out.println("Invalid choice\n");
				break;
		
			}
		
			System.out.println("Do you want to continue Y/N");
			str = s.next();
			if(str.equals("N")) {
				break;
			}
		}
		System.out.println("End of program");
		s.close();
		
	}
}