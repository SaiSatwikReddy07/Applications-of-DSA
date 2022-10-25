package second_sem_term_project;

public class Question extends postfix_stack{
	
	Question(){super();}
	
	public static int precedance(char ch) {
		if(ch=='+'||ch=='-') {
			return 1;
		}
		else if(ch=='*'||ch=='/') {
			return 2;
		}
		return 0;
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "A*(B+C)";
		System.out.println("the infix expression is "+input);
		character obj1 = new character(input.length());
		postfix_stack obj2 = new postfix_stack(input.length());
		
		for(int i = 0;i<input.length();i++) {
			char ch = input.charAt(i);
			if(ch=='(') {obj1.push('(');}
			else if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')) {obj2.push_postfix(ch+" ");}
			else if(ch==')') {
				while(obj1.peek_op()!='(') {
					char op = obj1.pop();
					String first = obj2.pop_postfix();
					String second = obj2.pop_postfix();
					obj2.push_postfix(second+first+op);
				}
				obj1.pop();
			}
			else if(ch=='+'||ch=='-'||ch=='*'||ch=='/') {
				while(obj1.top!=-1&&obj1.peek_op() != '('&& precedance(ch)<=precedance(obj1.peek_op())) {
					char op = obj1.peek_op();
					String first = obj2.pop_postfix();
					String second = obj2.pop_postfix();
					
					String new_postfix = second+first+op;
					obj2.push_postfix(new_postfix);
				}
				obj1.push(ch);
			}
		}

		while(obj1.top !=-1) {
			char op = obj1.pop();
			String first = obj2.pop_postfix();
			String second = obj2.pop_postfix();
			
			String new_postfix = second+first+op;
			obj2.push_postfix(new_postfix);
		}
		System.out.println("the postfix expression is "+obj2.operands[obj2.top]);
	}

}
