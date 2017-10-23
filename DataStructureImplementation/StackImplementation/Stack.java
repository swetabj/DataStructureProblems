
public class Stack {

		int top = -1;
		int [] a = null;
		int size;
			
	public Stack() {
		top = -1;
		size = 50;
		a = new int [50];
	}
	
	public Stack(int size) {
		top = -1;
		this.size = size;
		a = new int [this.size];
	}
	
	
	public void push(int item) {
		if(top == a.length-1) {
			System.out.println("Grow array");
			growArray();
			a[++top] = item;
		}
		else {
			a[++top] = item;
		}
	}
	
	public void growArray() {
		int [] tempArr = a;
		this.size = a.length*2;
		
		a = null;

		a = new int[this.size];
		
		for(int i=0;i<=top;i++) {
			a[i] = tempArr[i];
		}
		System.out.println("New Array Size is: " + a.length);
	}
	
	public void pop(){
		if(isEmpty()) {
			System.out.println("Stack is empty");
		}
		else {
			System.out.println("Poped element is: " + a[top]);
			top--;
		}
	}
	
	public Boolean isEmpty() {
		if(top == -1)
			return true;
		else 
			return false;
	}
	
	public void topElement() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
		}
		else {
			System.out.println("top element of the Stack is : " + a[top]); 
		}
	}
	
	public void displayStack() {
		if(isEmpty()) {
			System.out.println("Stack is Empty");
		}
		else {
			System.out.println("Elements of the array are:");
			for(int i=0;i<=top;i++) {
				System.out.println(a[i]);
			}
		}
	}
}
