import java.util.*;
public class inf_to_pos {
	
	public static int inp_prec(char ns) {
		if(ns== '+' || ns == '-'){
			return 1;
		}
		else if(ns== '*' || ns == '/'){
			return 3;
		}
		else if(ns == '^'){
			return 6;
		}
		else if(ns== '('){
			return 9;
		}
		else if(ns == ')'){
			return 0;
		}
		else{
			return 7;
		}
	}
	public static int stk_prec(char ns) {
		if(ns== '+' || ns == '-'){
			return 2;
		}
		else if(ns== '*' || ns == '/'){
			return 4;
		}
		else if(ns == '^'){
			return 5;
		}
		else if(ns== '('){
			return 0;
		}
		else if(ns == ')'){
			return 0;
		}
		else{
			return 8;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the infix expression with adding a ')' and '#' at the end-->");
		String infix = sc.next();
		int n = infix.length();
		char postfix [] =new char[n];
		stack s = new stack(n);
		s.push('(');
		int i=0;
		char nextsym = infix.charAt(i);
		int j = 0;
		while(nextsym!='#'){
			while(inp_prec(nextsym)< stk_prec(s.arr[s.top])){
				char temp = s.pop();
				postfix[j] = temp;
				j++;
			}
			if(inp_prec(nextsym)>stk_prec(s.arr[s.top])){
				s.push(nextsym);
			}
			else{
				char k = s.pop();
			}
			i++;
			nextsym = infix.charAt(i);
		}
		String result = new String(postfix);
		if(s.isEmpty()){
			System.out.println(result);
		}
		else{
			System.out.println("invalid infix");
		}
	}
}
 class stack{
	int size=0;
	int top =-1;
	char arr[];
	stack(int val){
		size = val;
		arr= new char[size];
	}
	public boolean isEmpty() {
		if(top == -1){
			return true;
		}
		else{
			return false;
		}
	}
	public void push(char elem) {
		if(top == size-1){
			System.out.println("stack is full");
		}
		else{
			top+=1;
			arr[top]=elem;
		}
		
	}
	public char pop() {
		if(isEmpty()){
			System.out.println("stack is empty..");
			return '$';
		}
		else{
			char data = arr[top];
			top-=1;
			return data;
		}
	}
}