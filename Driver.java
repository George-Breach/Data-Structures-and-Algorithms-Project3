/**
   A driver that demonstrates the class DoubleEndedList.
   We will test only the additional methods, since the methods
   in ListInterface are unchanged and have been tested already.

   @author Frank M. Carrano
   @version 5.0
 */
package LListApp;
import Interfaces.DoubleEndedListInterface;
import Interfaces.ListInterface;
import Implementations.DoubleEndedList;
public class Driver 
{
	public static void main(String[] args) 
	{
		System.out.println("Create an empty list.");
		DoubleEndedListInterface<String> myList = new DoubleEndedList<>();
		System.out.println("List should be empty; isEmpty() returns " + myList.isEmpty() + ".");

		System.out.println("\nTesting addFirst:");
		myList.addFirst("15");
		myList.addFirst("25");
		myList.addFirst("35");
		myList.addFirst("45");
		System.out.println("List should contain 45 35 25 15.");		
		displayList(myList);		

		myList.clear();
		System.out.println("Testing addLast with the following list:");
		myList.addLast("15");
		myList.addLast("25");
		myList.addLast("35");
		myList.addLast("45");
		myList.addLast("55");
		myList.addLast("65");
		System.out.println("List should contain 15 25 35 45 55 65.");		
		displayList(myList);		

		System.out.println("\nTesting removeFirst with previous list:");
		System.out.println("removeFirst(): " + myList.removeFirst());
		System.out.println("removeFirst(): " + myList.removeFirst());
		System.out.println("removeFirst(): " + myList.removeFirst());
		System.out.println("\nList should contain\n45 55 65");
		displayList(myList);
		System.out.println("removeFirst(): " + myList.removeFirst());
		System.out.println("removeFirst(): " + myList.removeFirst());
		System.out.println("removeFirst(): " + myList.removeFirst());
		System.out.println("removeFirst(): " + myList.removeFirst());
		System.out.println("List should be empty; isEmpty() returns " + myList.isEmpty() + ".");

		System.out.println("\nTesting removeLast with the following list:");
		myList.clear();
		myList.addLast("15");
		myList.addLast("25");
		myList.addLast("35");
		myList.addLast("45");
		myList.addLast("55");
		myList.addLast("65");
		System.out.println("List should contain 15 25 35 45 55 65.");		
		displayList(myList);	

		System.out.println("removeLast(): " + myList.removeLast());
		System.out.println("removeLast(): " + myList.removeLast());
		System.out.println("removeLast(): " + myList.removeLast());
		System.out.println("removeLast(): " + myList.removeLast());
		System.out.println("removeLast(): " + myList.removeLast());
		System.out.println("\nList should contain\n15");
		displayList(myList);
		System.out.println("removeLast(): " + myList.removeLast());
		System.out.println("removeLast(): " + myList.removeLast());
		System.out.println("List should be empty; isEmpty() returns " + myList.isEmpty() + ".");

		System.out.println("\nTesting getFirst and getLast with the following list:");
		myList.clear();
		myList.addLast("15");
		myList.addLast("25");
		myList.addLast("35");
		myList.addLast("45");
		myList.addLast("55");
		myList.addLast("65");
		displayList(myList);	
		System.out.println("Retrieving the first entry : returns " + myList.getFirst());
		System.out.println("Retrieving the last entry : returns " + myList.getLast());

		System.out.println("\nTesting moveToEnd with the following list:");
		displayList(myList);

		myList.moveToEnd();
		System.out.println("After moveToEnd, the list is:");
		displayList(myList);		

		myList.moveToEnd();
		System.out.println("After moveToEnd, the list is:");
		displayList(myList);		

		myList.moveToEnd();
		System.out.println("After moveToEnd, the list is:");
		displayList(myList);		


		System.out.println("\n\nDone.");
	}  // end main

	public static void displayList(ListInterface<String> aList)
	{
		System.out.println("The list contains " + aList.getLength() +
				" string(s), as follows:");		
		Object[] listArray = aList.toArray();
		for (int index = 0; index < listArray.length; index++)
		{
			System.out.print(listArray[index] + " ");
		} // end for

		System.out.println();

		for (int position = 1; position <= listArray.length; position++)
		{
			if (position < 10)
				System.out.print(" " + position);
			else
				System.out.print(position);

			System.out.print(" ");
		}  // end for

		System.out.println();
	}  // end displayList
}  // end Driver

/* 
 Create an empty list.
 List should be empty; isEmpty() returns true.
 
 Testing addFirst:
 List should contain 45 35 25 15.
 The list contains 4 string(s), as follows:
 45 35 25 15
 1  2  3  4
 Testing addLast with the following list:
 List should contain 15 25 35 45 55 65.
 The list contains 6 string(s), as follows:
 15 25 35 45 55 65
 1  2  3  4  5  6
 
 Testing removeFirst with previous list:
 removeFirst(): 15
 removeFirst(): 25
 removeFirst(): 35
 
 List should contain
 45 55 65
 The list contains 3 string(s), as follows:
 45 55 65
 1  2  3
 removeFirst(): 45
 removeFirst(): 55
 removeFirst(): 65
 removeFirst(): null
 List should be empty; isEmpty() returns true.
 
 Testing removeLast with the following list:
 List should contain 15 25 35 45 55 65.
 The list contains 6 string(s), as follows:
 15 25 35 45 55 65
 1  2  3  4  5  6
 removeLast(): 65
 removeLast(): 55
 removeLast(): 45
 removeLast(): 35
 removeLast(): 25
 
 List should contain
 15
 The list contains 1 string(s), as follows:
 15
 1
 removeLast(): 15
 removeLast(): null
 List should be empty; isEmpty() returns true.
 
 Testing getFirst and getLast with the following list:
 The list contains 6 string(s), as follows:
 15 25 35 45 55 65
 1  2  3  4  5  6
 Retrieving the first entry : returns 15
 Retrieving the last entry : returns 65
 
 Testing moveToEnd with the following list:
 The list contains 6 string(s), as follows:
 15 25 35 45 55 65
 1  2  3  4  5  6
 After moveToEnd, the list is:
 The list contains 6 string(s), as follows:
 25 35 45 55 65 15
 1  2  3  4  5  6
 After moveToEnd, the list is:
 The list contains 6 string(s), as follows:
 35 45 55 65 15 25
 1  2  3  4  5  6
 After moveToEnd, the list is:
 The list contains 6 string(s), as follows:
 45 55 65 15 25 35
 1  2  3  4  5  6
 
 
 Done.
 */
