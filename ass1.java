/***********************************************/
/***   Go to the folder where DQueue.java is ***/
/***   Compile with: C:\> javac DQueue.java  ***/
/***   Execute with: C:\> java  DQueue       ***/
/***********************************************/

import java.util.Random;

class DQueue {
	private Object[] dqArray; // An array holding the contents of the DQueue
	private int front;	  // Pointing to the front of the DQueue
	private int back;	  // Pointing to the back of the DQueue
	private int nbItems;      // Number of items currently in the DQueue

	// Initializes the private class members
	public DQueue(int maxSize) {
		dqArray = new Object[maxSize];
		nbItems = 0;
		back = maxSize-1;
		front = 0;
	}

	// Returns the number of items currently in the Dqueue
	public int size() { return(nbItems); }

	// Returns true if the DQueue is full, false otherwise.
	public boolean isFull() { return(nbItems == dqArray.length); }

	// Returns true if the DQueue is empty, false otherwise.
	public boolean isEmpty() { return(nbItems == 0); }

	// Returns a reference to the object at
	// the front of the DQueue, if it is not empty.
	// Otherwise, it returns null.
	public Object peekFront() {
		if (!isEmpty()) return(dqArray[front]);
		return(null);
	}

	// Returns a reference to  the object at
	// the back of the Dqueue, if it is not empty.
	// Otherwise, it returns null.
	public Object peekBack() {
		if (!isEmpty()) return(dqArray[back]);
		return(null);
	}

	
	// Diplays the contents of the DQueue object
	public void display() {
		int i = 0, index = front;

		while (i < nbItems) {
			System.out.print(" " + dqArray[index].toString());
			i++; index = (index + 1)%dqArray.length;
		}

		System.out.println("");
	}

	// If the DQueue is full, it returns false.
	// Otherwise, it inserts obj in the back
	// of the DQueue and returns true.
	public boolean pushBack(Object obj) {
		if(!isFull()){ // insertion if the array is not full
			if(!isEmpty()){ //if its not empty it adds the obj in the back 
				dqArray[++back]=obj;
		    } else { //if it is empty it makes the back be equal to the front 
				back=front-1;
				dqArray[++back]=obj;
			}
			return(true); //returns true and adds the obj in the DQueue
		}else{
			return(false); // No insertion
		} 
	}

	// If the DQueue is empty, it returns null.
	// Otherwise, it removes an item from the 
	// back of the DQueue and returns it.
	public Object popBack() {
		if (!isEmpty()){
			temp=dqArray[back];
			dqArray[back--]=null;
			return(temp);
		}else{
			return(null); // No item returned
		}
	}

	// If the DQueue is full, it returns false.
	// Otherwise, it inserts obj in the front
	// of theQueue and returns true.
	public boolean pushFront(Object obj) {
		if(!isFull()){ // insertion if the array is not full
			if(!isEmpty()){ //if its not empty it adds the obj in the back 
				dqArray[--front]=obj;
		    } else { //if it is empty it makes the back be equal to the front 
				front=back+1;
				dqArray[++front]=obj;
			}
			return(true); //returns true and adds the obj in the DQueue
		}else{
			return(false); // No insertion
		} 
	}

	// If the DQueue is empty, it returns null.
	// Otherwise, it removes an item from the 
	// front of the DQueue and returns it.
	public Object popFront() {
		if (!isEmpty()){
			temp=dqArray[front];
			dqArray[front++]=null;
			return(temp);
		}else{
			return(null); // No item returned
		}
	}

	public static void main(String[] args) {
		int maxSize = 12;
		DQueue dq = new DQueue(maxSize);
		Random rnd_gen = new Random();

		System.out.println("testDQ() > Testing pushFront(obj).");
		System.out.print("testDQ() > + DQueue pushed (front): ");

		for(long i = 0; i < maxSize; i++) {
			int a = rnd_gen.nextInt(10*maxSize);
			boolean result = dq.pushFront(new Integer(a));
			if (!result) {
				System.out.println(" - Failed to push " + i + "-th item on a DQueue of maxSize = " + maxSize + ": DQueue says it's full!");
				break;
			}
			System.out.print(a + " ");
		}
		System.out.println("");

		System.out.print("testDQ() > - DQueue display():     ");
		dq.display();

		System.out.println("testDQ() > Testing popBack().");
		System.out.print("testDQ() > + DQueue popped (back):  ");
		while(!dq.isEmpty()) System.out.print(dq.popBack() + " ");
		System.out.println("");

		System.out.println("testDQ() > Testing pushBack(obj).");
		System.out.print("testDQ() > + DQueue pushed (back):  ");

		for(long i = 0; i < maxSize; i++) {
			int a = rnd_gen.nextInt(10*maxSize);
			boolean result = dq.pushBack(new Integer(a));
			if (!result) {
				System.out.println(" + Failed to push " + i + "-th item on a DQueue of maxSize = " + maxSize + ": DQueue says it's full!");
				break;
			}
			System.out.print(a + " ");
		}
		System.out.println("");

		System.out.print("testDQ() > - DQueue display():     ");
		dq.display();

		System.out.println("testDQ() > Testing popFront().");
		System.out.print("testDQ() > + DQueue popped (front): ");
		while(!dq.isEmpty()) System.out.print(dq.popFront() + " ");
		System.out.println("");

		System.out.println("testDQ() > Successfully completed!");
	}
}

