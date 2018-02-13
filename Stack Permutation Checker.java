// Author: Matthew Stein
import net.datastructures.*; //importing for access to ArrayQueue and ArrayStack 
import java.util.Scanner; // import for input scanner

public class main {
	public static void main(String[] args) {
		// prompt user for a number for queue length
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number for the queue length: ");
		int numLength = reader.nextInt();
		
		// create input and output queues 
		ArrayQueue<Integer> inputQ = new ArrayQueue<>(numLength);
		ArrayQueue<Integer> outputQ = new ArrayQueue<>(numLength);
		
		// enqueue 1 to n(numLength) into the input queue
		for(int i=1; i<=numLength; i++ ) {
			inputQ.enqueue(i);
		}
		
		// create stack 
		ArrayStack<Integer> stackPile = new ArrayStack<>();
		
		// prompt user for the number sequence and enqueue into output queue
		System.out.println("Enter each number in the sequence: ");
		for(int i=1; i<=numLength; i++) {
			outputQ.enqueue(reader.nextInt());
		}
		
		// The stack permutation check algorithm
		while(!inputQ.isEmpty()) {
			int inputFirst = inputQ.dequeue();
			if(inputFirst == outputQ.first()) {
				outputQ.dequeue();
				while(!stackPile.isEmpty()) {
					if(stackPile.top() == outputQ.first()) {
						stackPile.pop();
						outputQ.dequeue();
					}
					else
						break;
				}
			}
			else
				stackPile.push(inputFirst);
		}
		if(inputQ.isEmpty() && stackPile.isEmpty()) {
			System.out.println("The input sequence is a stack permutation!");
		}
		else 
			System.out.println("The input sequence is not a stack permutation");
	}
}
