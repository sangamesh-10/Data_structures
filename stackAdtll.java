import java.util.Scanner;

public class stackAdtll {
	Node top =null;
	Node stack = null;
	public class Node{
		int data;
		Node next;
		Node(int elem){
			data = elem;
			next= null;
		}
	}
	public void push(int elem) {
		Node t = new Node(elem);
		if(top==null){
			top=t;
			stack=t;
		}
		else{
			t.next = top;
			top=t;
		}
	}
	public int peek() {
		if(top==null){
			System.out.println("The stack is empty...");
			return 404;
		}
		return top.data;
	}
	public int  pop() {
		if(top == null){
			System.out.println("stack underflow..");
			return -1;

		}
		int del = top.data;
		top=top.next;
		return del;
	}
	public boolean isEmpty() {
		if(top==null)return true;
		else return false;
	}
	public void print() {
		if(top==null){
			System.out.println("the stack is empty...");
			return;
		}
		Node itr = top;
		while(itr!=null){
			System.out.println(itr.data);
			itr = itr.next;
		}
		
	}
	public int len() {
		if(top==null){		
			return 0;
		}
		Node itr = top;
		int count =0;
		while(itr!=null){
			count++;
			itr = itr.next;
		}
		return count;
	}
	public static void main(String[] args) {
        stackAdtll st = new stackAdtll();
        System.out.println("-----------------Select an option-----------------" );
        System.out.println("1.Insert an element into stack.");        
        System.out.println("2.Check if stack is empty");        
        System.out.println("3.See the top element");        
        System.out.println("4.Delete an element.");        
        System.out.println("5.print the stack elements with index");
        System.out.println("6.Size of the stack(ie..no of elements in stack");; 
        System.out.println("7.End the process."); 
        Scanner sc = new Scanner(System.in);
       
        boolean end= false;
        while(!end){
            System.out.print("Enter your option--->");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                System.out.println("\nEnter the element to insert--->");
                int val=sc.nextInt();
                    st.push(val);
                    break;
                case 2:
                    if(!st.isEmpty()){
						System.out.println("the Stack is not empty..");
					}
					else{
						System.out.println("the Stack is  empty..");
					}
                    break;
                case 3:
                    System.out.println(st.peek()+" is the top element");
                    break;
                case 4:
                    System.out.println(st.pop()+" is deleted.");
                    break;
                case 5:
                    st.print();
                    break;
                case 6:
				System.out.println("stack has "+st.len()+" elements");
                    break;
                case 7:
                    end=true;
					System.out.println("the has been stopped...");
                    break;
            
                default:
                System.out.println("Enter a valid option.....");
                    break;
            }
        }
        sc.close();
    } 
}

