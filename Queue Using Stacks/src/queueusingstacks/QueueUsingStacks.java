package queueusingstacks;
import java.util.*;
public class QueueUsingStacks {

	static Stack<Integer> stack_1 = new Stack<Integer>();
	static Stack<Integer> stack_2 = new Stack<Integer>();

	public void enqueue(int i) {//if stack 1 is empty push element to stack 1
		if(stack_1.isEmpty()) {
			stack_1.push(i);
		}
		else {
			while(!stack_1.empty()) {// if stack 1 is not empty pop and push all elements from stack 1 to 2.
				stack_2.push(stack_1.pop());
			}
			stack_1.push(i);//then push the recent element to stack 1
			while(!stack_2.isEmpty()) {// now pop and push all elements from stack 2 to stack 1.
				stack_1.push(stack_2.pop());
			}
		}
		
	}
	public int dequeue() {
		if(stack_1.isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		}
		else {
			return stack_1.pop();
		}
	}

	public static void main(String[] args) {
		QueueUsingStacks obj = new QueueUsingStacks();

		obj.enqueue(12);
		obj.enqueue(35);
		obj.enqueue(60);

		System.out.println("1st element deleted = " + obj.dequeue());//should print the 1st element inserted. and so on.
		System.out.println("2nd element deleted = " + obj.dequeue());
		System.out.println("3rd element deleted = " + obj.dequeue());

	}

}
