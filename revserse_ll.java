public class revserse_ll {
	Node head = null;
	public class Node{
		int data;
		Node next;
		Node(int value){
			data = value;
			next = null;
		}
	}
	public void insert(int elem){
		Node t = new Node(elem);
		if(head ==null){
			head=t;
			return;
		}
		Node itr = head;
		while (itr.next!=null) {
			itr=itr.next;
		}
		itr.next = t;
	}
	public void reverse() {
		 Node prev = null;
		 Node current = head;
		 Node Next =current.next;
		 while(Next!= null){
			current.next = prev;
			prev = current;
			current=Next;
			Next =Next.next; 
		 }
		 if(Next == null){
			current.next=prev;
			head = current;
		 }
	}
	public void print() {
		Node itr = head;
		while(itr!=null){
			if(itr.next==null){
				System.out.print(itr.data );
				break;
			}
			System.out.print(itr.data + "->");
			itr = itr.next;
		}
		System.out.println(" ");
	}
	public static void main(String[] args) {
		revserse_ll rl = new revserse_ll();
		rl.insert(10);
		rl.insert(20);
		rl.insert(30);
		rl.insert(40);
		rl.insert(50);
		System.out.print("List before reversing--> ");
		rl.print();	
		rl.reverse();
		System.out.print("List after reversing--> ");
		rl.print();		
	}
}