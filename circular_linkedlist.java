import java.util.Scanner;

public class circular_linkedlist {
	Node head;
	public class Node{
		int data;
		Node next;
		Node(int value){
			data = value;
			next=null;
		}
	}
	public void insertAtHead(int data) {
		Node t = new Node(data);
		if(head==null){
			head=t;
			t.next=head;
		}
		else{
			Node itr = head;
			while(itr.next!=head){
				itr = itr.next;
			}
			itr.next =t;
			t.next = head;
			head=t;

		}
	}
public void insertAtEnd(int data) {
	Node t = new Node(data);
	if(head==null){
		head=t;
		t.next=head;
	}
	else{
		Node itr = head;
			while(itr.next!=head){
				itr = itr.next;
			}
		itr.next=t;
		t.next=head;
	}
}
public void insertBefore(int data,int position) {
	Node t = new Node(data);
	if(head==null){
		System.out.println("linkedlist is empty...choose option 1");
		return;
	}
	Node itr=head;
	if(itr.data==position){
			while(itr.next!=head){
				itr = itr.next;
			}
			itr.next =t;
			t.next = head;
			head=t;
			return;
	}
	while(itr.next!=head  &&   itr.next.data!=position  ){
		itr=itr.next;
	}
	if(itr.next==head){
		System.out.println(" position element is not present.....");
		return;
	}
	t.next=itr.next;
	itr.next=t;
}
public void insertAfter(int data,int postion) {
	if(head==null){
		System.out.println("linkedlist is empty...choose option 1");
		return;
	}
	Node t = new Node(data);
	Node itr=head;
	do{
		itr=itr.next;
	}while(itr!=head && itr.data!=postion);
	if(itr==head){
		System.out.println(" position element is not present.....");
		return;
	}
	t.next=itr.next;
	itr.next=t;
}
public void delete(int elem) {
	Node itr =head;
	if(head==null){
		System.out.println("The list is empty...cannot delete an element");
		return;
	}
	if(head.data==elem){
		if(head.next==head){
			head=null;
			System.out.println("Note: The list is now empty...");
			return;
		}
		while(itr.next!=head){
			itr = itr.next;
		}
		itr.next = head.next;
		head =head.next; 
		return;
	}
	itr=head;
	do{
		itr=itr.next;
		}while(itr!=head && itr.next.data!=elem);
	if(itr.next==head){
		System.out.print("\n Element not found...");
		return;
	}		
	
	itr.next = itr.next.next;

}

public void printlist() {
	if(head==null){
		System.out.println("Oops!!..linkedlist is empty...");
		return;
	}
	Node itr =head;
	do{
		if(itr.next==head){
			System.out.println(itr.data+"->Head");
			return;
		}
		System.out.print(itr.data+"->");
		itr=itr.next;
		
	}while(itr!=head);
}

public static void main(String[] args) {
	circular_linkedlist cl = new circular_linkedlist();
	Scanner sc = new Scanner(System.in);
	boolean temp=true;
	System.out.println("-----------------Select an option ------------------");
	System.out.println("1.Insert at starting node");
	System.out.println("2.Insert before a particular node");
	System.out.println("3.Insert after a particular node");
	System.out.println("4.Insert after last node");
	System.out.println("5.print the complete list");
	System.out.println("6.Delete an element");
	System.out.println("7.stop the process");
	while(temp){
   
	
	System.out.print("\nenter the option and press enter<-/  :");
	
	int i = sc.nextInt();
	

	
	switch (i) {
		case 1:
			System.out.print("\nenter the element to be inserted-->");
			int d1 = sc.nextInt();
			cl.insertAtHead(d1);
			
			break;
		case 2:
			System.out.print("\nenter the element to be inserted-->");
			int d2 = sc.nextInt();
			System.out.print("\nenter the  position element-->");
			int position = sc.nextInt();
			cl.insertBefore(d2, position);
			break;
		case 3:
			System.out.print("\n enter the element to be inserted-->");
			int d3 = sc.nextInt();
			 System.out.print("\n enter the position element--> ");
			int pos = sc.nextInt();
			cl.insertAfter(d3, pos);
			break;
		case 4:
			System.out.print("\nenter the element to be inserted-->");
			int d4 = sc.nextInt();
			cl.insertAtEnd(d4);
			break;
		case 5:
			cl.printlist();
			break;
		case 6:
			System.out.print("\nenter the element to delete-->");
			int ele=sc.nextInt();
			cl.delete(ele);
			break;
		case 7:
			temp=false;
			break;
	
		default:
			System.out.println("enter the correct value..");
			break;
	}
}
	sc.close();
}
}
