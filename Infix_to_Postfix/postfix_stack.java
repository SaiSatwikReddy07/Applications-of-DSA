package second_sem_term_project;

public class postfix_stack extends character{
	int top;
	String operands[];
	postfix_stack(){}
	postfix_stack(int dim){
		super(dim);
		operands = new String[dim];
		top = -1;
	}
	void push_postfix(String expression) {
		if(top == operands.length-1) {
			System.out.println("the postfix stack is full");
			return;
		}
		top++;
		operands[top] = expression;
	}
	String pop_postfix() {
		if(top==-1) {
			System.out.println("the postfix stack is empty now. no use popping elements from it");
			System.exit(1);
		}
		String s = operands[top];
		top--;
		return s;
	}
	
	String peek_exp() {
		if(top==-1) {
			System.out.println("the postfix stack is empty");
			System.exit(1);
		}
		return operands[top];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		postfix_stack obj = new postfix_stack(5);
		character obj1 = new character(5);
		obj1.push('1');
		obj1.push('2');
		obj1.display();
		System.out.println();
		obj.push_postfix("3");
		obj.push_postfix("4");
		//obj.push('a');
		obj.display();
		obj1.display();
		//System.out.print(obj.top);
	}

}
