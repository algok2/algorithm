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
		System.out.println(stack.peek()); //Top 데이터 확인: 결과 = 3
		
		stack.push(4);
		stack.push(5);
		System.out.println(stack.peek()); //Top 데이터 확인: 결과 = 5
		
		System.out.println(stack.pop()); // Top 데이터 확인 후 꺼낸다(제거) : 5
		System.out.println(stack.peek()); //Top 데이터 확인: 결과 = 4
		
		System.out.println("-----");
		
		//stack 안의 모든 데이터를 제거하며 출력
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}//main
}//Stack
