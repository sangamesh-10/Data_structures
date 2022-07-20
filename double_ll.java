import java.util.Scanner;

public class double_ll {
	Node head = null;
	Node tail = null;
	public class Node {
		int data;
        Node next;
		Node previous;
        Node(int value){
            data=value;
            next=null;
			previous=null;
        }
	}
	public void insertAtHead(int data) {
		Node t = new Node(data);
		if(head==null){
			head=t;
			tail=t;
		}
		else{
			head.previous=t;
			t.next = head;
			head=t;

		}
	}
	public void insertAtEnd(int data) {
	Node t = new Node(data);
	if(head==null){
		head=t;
	}
	else{
		tail.next=t;
		t.previous=tail;
		tail=t;
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
		t.next=itr;
		head.previous=t;
		head=t;
		return;
	}
	while(itr.next!=null  &&   itr.next.data!=position  ){
		itr=itr.next;
	}
	if(itr.next==null){
		System.out.println(" position element is not present.....");
		return;
	}
	itr.next.previous = t;
	t.next=itr.next;
	t.previous=itr;
	itr.next=t;
	}
	public void insertAfter(int data,int postion) {
	if(head==null){
		System.out.println("linkedlist is empty...choose option 1");
		return;
	}
	Node t = new Node(data);
	Node itr=head;
	while(itr!=null && itr.data!=postion){
		itr=itr.next;
	}
	if(itr==null){
		System.out.println(" position element is not present.....");
		return;
	}
	itr.next.previous=t;
	t.next=itr.next;
	t.previous=itr;
	itr.next=t;
	}
	public void delete(int elem) {
		if(head==null){
			System.out.println("The list is empty...cannot delete an element");
			return;
		}
		
	if(head.data==elem){
		if(head==tail){
			head=tail=null;
			System.out.println("Note: The list is now empty...");
			return;
		}
		head.next.previous=null;
		head=head.next;
		return;
	}
	Node itr =head;
	while(itr.next.data!=elem && itr!=null){
		itr=itr.next;
		}
	if(itr==null){
		System.out.print("\n Element not found...");
		return;
	}		
	if(itr.next==tail){
		itr.next=null;
		tail=itr;
		return;
	}
	itr.next.next.previous=itr;
	itr.next = itr.next.next;

	}

	public void printlist() {
	if(head==null){
		System.out.println("Oops!!..linkedlist is empty...");
		return;
	}
	Node itr =head;
	while(itr!=null){
		if(itr.next==null){
			System.out.println(itr.data);
			return;
		}
		System.out.print(itr.data+"<->");
		itr=itr.next;
		
	}
	}
	public static void main(String[] args) {
        double_ll ll = new double_ll();
        Scanner sc = new Scanner(System.in);
        boolean temp=true;
		System.out.println("-----------------Select an option to insert the element at a position------------------");
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
                ll.insertAtHead(d1);
                
                break;
            case 2:
                System.out.print("\nenter the element to be inserted-->");
                int d2 = sc.nextInt();
                System.out.print("\nenter the  position element-->");
                int position = sc.nextInt();
                ll.insertBefore(d2, position);
                break;
            case 3:
                System.out.print("\n enter the element to be inserted-->");
                int d3 = sc.nextInt();
                 System.out.print("\n enter the position element--> ");
                int pos = sc.nextInt();
                ll.insertAfter(d3, pos);
                break;
            case 4:
                System.out.print("\nenter the element to be inserted-->");
                int d4 = sc.nextInt();
                ll.insertAtEnd(d4);
                break;
            case 5:
                ll.printlist();
                break;
            case 6:
				System.out.print("\nenter the element to delete-->");
				int ele=sc.nextInt();
                ll.delete(ele);
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

	

