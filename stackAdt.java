import java.util.Scanner;

public class stackAdt {
    int max_size=100;
    int stack[]=new int[max_size];
    int top=-1;
    public void push(int elem) {
        if(top==max_size){
            System.out.println("Stack overflow...");
            return;
        }
        top+=1;
        stack[top]=elem;
        return;
    }
    public boolean isEmpty(){
        if(top==-1){
            return true;
        }
        else{
            return false;
        }
    }
    public int peek(){
        if(top==-1){
            System.out.println("The stack isempty............");
            return -1;
        }
        return stack[top];
    }
    public int pop(){
        if(top==-1){
            System.out.println("Stack Underflow......");
            return -1;
        }
        int del =stack[top];
       top--;
       return del;
    }
    public void print() {
        for(int i=top;i>=0;i--){
            System.out.println("At index("+i+")-->"+stack[i]);
        }
    }
    public static void main(String[] args) {
        stackAdt st = new stackAdt();
        System.out.println("-----------------Select an option-----------------" );
        System.out.println("1.Insert an element into stack.");        
        System.out.println("2.Check if stack is empty");        
        System.out.println("3.See the top element");        
        System.out.println("4.Delete an element.");        
        System.out.println("5.print the stack elements with index");
        System.out.println("6.End the process."); 
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
                    System.out.println(st.isEmpty());
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
                    end=true;
                    break;
            
                default:
                System.out.println("Enter a valid option.....");
                    break;
            }
        }
        sc.close();
    } 
}
