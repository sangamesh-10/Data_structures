import java.util.Scanner;

public class queueAdt_seq {
	int front;
	int rear;
	int capacity;
	int queue[];
	int count=0;
	queueAdt_seq(int size){
		capacity = size;
		front=-1;
		rear=-1;
		queue = new int[capacity];
	}
	public void enqueue(int elem) {
		if(rear==capacity-1){
			System.out.println("\nthe queue is full..");
			count=capacity;
			return;
		}
		if(front==-1){
			front++;
			queue[front]=elem;
			rear++;
			count++;
			System.out.println("\nElement "+elem+" is inserted at first position.");
		}
		else{
			rear++;
			queue[rear]=elem;
			count++;
			System.out.println("\nElement "+elem+" is inserted at Rear end.");
		}
	}
	public int dequeue() {
		if(front==-1){
			System.out.println("\nQueue is empty...");
			return -1;
		}
		if(front==rear){
			front=rear=-1;
			System.out.println("\nQueue is now empty...");
			count--;
			return -1;
		}
		else{
			int del = queue[front];
			for(int i=0;i<rear;i++){
				queue[i]=queue[i+1];
			}
			System.out.println(del+" is removed from the queue..");
			rear--;
			count--;
			return del;
		}
	}
	public int front() {
		if(front==-1){
			System.out.println("\n the queue is empty");
			return -1;
		}
		return queue[front];
	}
	public int rear(){
		if(front==-1){
			System.out.println("\n the queue is empty");
			return -1;
		}
		return queue[rear];
	}
	public int size(){
		return count;
	}
	public void display() {
		System.out.print("Front-->{");
		int itr;
		for(itr=0;itr<=rear;itr++){
			if(itr==rear){
				System.out.print(queue[itr]);
				break;
			}
			System.out.print(queue[itr]+",");
		}
		System.out.print("}<--Rear\n");
	}
	public static void main(String[] args) {
		queueAdt_seq sq = new queueAdt_seq(10);
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
			System.out.print("Enter the option---->");
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
					System.out.println("\nThe front element is "+sq.front());
					break;
				case 4:
					System.out.println("\nThe rear element is "+sq.rear());
					break;
				case 5:
					System.out.println("\nThe length of the Queue is "+sq.size());
					break;
				case 6:
					sq.display();
					break;
				case 7:
					temp=false;
					break;
			
				default:
				System.out.println("\nEnter the valid option");
					break;
			}
		}
		sc.close();
	}
}
