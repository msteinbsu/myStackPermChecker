import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

class myStackPermChecker {
 private static Scanner reader; 
	public static void main(String[] args) {
		// prompt user for a number for queue length
			try {
				reader = new Scanner(System.in);
				System.out.println("Enter a number for the queue length: ");
				int numLength = reader.nextInt();
			
									// create input and output queues 
				Queue<Integer> inputQ = new LinkedList<>();
				Queue<Integer> outputQ = new LinkedList<>();
					
					// enqueue 1 to number of queue length into the input queue
				for(int i=1; i<=numLength; i++ ) {
					inputQ.add(i);
				}
					
					// creates stack 
				Stack stackPile = new Stack();
					
					// prompt user for the number sequence and enqueue into output queue
				System.out.println("Enter each number in the sequence: ");
				for(int i=1; i<=numLength; i++) {
					outputQ.add(reader.nextInt());			
				}
					
					// The stack permutation check algorithm
				while(!inputQ.isEmpty()) {
					int inputFirst = inputQ.remove();
					if(inputFirst == outputQ.peek()) {
						outputQ.remove();
						while(!stackPile.empty()) {
							if(stackPile.peek() == outputQ.peek()) {
								stackPile.pop();
									outputQ.remove();
							}
							else
								break;
						}
					}
					else
						stackPile.push(inputFirst);
				}
				if(inputQ.isEmpty() && stackPile.empty() && outputQ.isEmpty()) {
					System.out.println("The input sequence is a stack permutation! ");
				}
				else 
					System.out.println("The input sequence is not a stack permutation! ");
				} catch(Exception e) {
					System.out.println("You entered something wrong! Restart the program! ");
				}	
		

	}

}
