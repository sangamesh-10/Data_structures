import java.util.Scanner;

public class queueAdt_linked {
	Node front=null;
	Node rear = null;
	int count = 0;
	public class Node{
		int data;
		Node next;
		Node(int val){
			data = val;
			next = null;
		}
	}
	public void enqueue(int elem) {
		Node t = new Node(elem);
		if(front==null){
			front=t;
			rear=t;
			count++;
			System.out.println("Element "+elem+" is inserted at first position.. ");
		}
		else{
			rear.next=t;
			rear = t;
			System.out.println("Element "+elem+" is inserted at Rear end..");
			count++;
		}
		
	}
	public int dequeue() {
		if(front == null){
			System.out.println("Queue is empty...cannot delete.");
			return-1;
		}
		int del = front.data;
		if(front==rear){
			front=null;
			rear=null;
			count--;
			System.out.println("Element "+del+" is deleted at Front end..");
			System.out.println("The Queue is now empty");
			return del;
		}
		front = front.next;
		count--;
		System.out.println("Element "+del+" is deleted at Front end..");
		return del;
	}
	public int front() {
		if(front==null){
			System.out.println("The list is empty..");
			return -1;
		}
		return front.data;
	}
	public int rear(){
		if(front==null){
			System.out.println("The list is empty..");
			return -1;
		}
		return rear.data;
	}
	public int size(){
		return count;
	}
	public void display() {
		Node itr = front;
		if(front==null){
		    System.out.println("Queue is empty...No elements to display.");
		    return;
		}
		System.out.print("\n Front-->{ ");
		while(itr!=null){
		    if(itr.next==null){
		        System.out.print(itr.data);
		        break;
		    }
		    System.out.print(itr.data + " , ");
		    itr = itr.next;
		}
		System.out.println(" }<--Rear");
		return;
	}
	public static void main(String[] args) {
		queueAdt_linked sq = new queueAdt_linked();
		Scanner sc = new Scanner(System.in);
		boolean temp=true;
		System.out.println("----------------- Select an option ------------------");
        System.out.println("1.Enqueue()");
        System.out.println("2.Dequeue()");
        System.out.println("3.Front()");
        System.out.println("4.Rear()");
        System.out.println("5.Size()");
        System.out.println("6.Display()");
        System.out.println("7.Exit()");
		while(temp){
			System.out.print("\nEnter the option---->");
			int ch =sc.nextInt();
			switch (ch) {
				case 1:
				System.out.print("\nEnter the Element-->");
				int val = sc.nextInt();
				sq.enqueue(val);
					break;
				case 2:
					sq.dequeue();
					break;
				case 3:
					System.out.println("\nThe front element is  "+sq.front());
					break;
				case 4:
					System.out.println("\nThe rear element is  "+sq.rear());
					break;
				case 5:
					System.out.println("\nThe length of the Queue is "+sq.size());
					break;
				case 6:
					sq.display();
					break;
				case 7:
					temp=false;
					System.out.println("process stopped!!");
					break;
			
				default:
				System.out.println("\nEnter the valid option");
					break;
			}
		}
		sc.close();
	}
}
