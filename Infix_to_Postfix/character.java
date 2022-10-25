package second_sem_term_project;

public class character {
	int top;
	char[] operators;
	character(int dim){
		operators = new char[dim];
		top = -1;
	}
	character(){
		
	}
	void push(char ch) {
		if(top==operators.length-1) {
			System.out.println("stack is full");
			return;
		}
		top++;
		operators[top]=ch;
	}
	char pop() {
		if(top==-1) {
			System.out.println("the character stack is empty now. No use popping");
			System.exit(1);
		}
		char popped = operators[top];
		top--;
		return popped;
	}
	char peek_op() {
		if(top==-1) {
			System.out.println("the operator stack is empty");
			System.exit(1);
		}
		return operators[top];
	}
	void display() {
		for(int i = 0;i <= top;i++) {
			System.out.print(operators[i]+"-");
		}
		System.out.println("display() constructor being called");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
