import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Stack {

	public static void main(String[] args) {
//		ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
		Deque<Integer> stack      = new ArrayDeque<Integer>();
		
//		LinkedList<Integer> stack = new LinkedList<Integer>();
//		Deque<Integer> stack      = new LinkedList<Integer>();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.peek()); //Top ������ Ȯ��: ��� = 3
		
		stack.push(4);
		stack.push(5);
		System.out.println(stack.peek()); //Top ������ Ȯ��: ��� = 5
		
		System.out.println(stack.pop()); // Top ������ Ȯ�� �� ������(����) : 5
		System.out.println(stack.peek()); //Top ������ Ȯ��: ��� = 4
		
		System.out.println("-----");
		
		//stack ���� ��� �����͸� �����ϸ� ���
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}//main
}//Stack
