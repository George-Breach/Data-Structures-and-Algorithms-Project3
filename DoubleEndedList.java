package Implementations;

import Interfaces.DoubleEndedListInterface;

public class DoubleEndedList<T> implements DoubleEndedListInterface<T> {
	
	
	// code necessary for node functions
	private class Node{
		private T data;
		private Node next;
		
		private Node(T dataPortion) {
			this(dataPortion, null);
		}
		
		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}
		
		private T getData() {
			return data;
		}
		
		private void setData(T newData) {
			data = newData;
		}
		
		private Node getNextNode() {
			return next;
		}
		
		private void setNextNode(Node nextNode) {
			next = nextNode;
		}
	}

	private Node firstNode;
	private Node lastNode;
	private int numberOfEntries;
	
	private Node getNodeAt(int givenPosition) {
		assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
		Node currentNode = firstNode;
		for (int i = 1; i < givenPosition; i++) {
			currentNode = currentNode.getNextNode();
		}
		assert currentNode != null;
		return currentNode;
	}
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	// code needed to make list interface methods work
	public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else // Add to end of nonempty list
        {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode); // Make last node reference new node
        } // end if

        numberOfEntries++;
    } // end add

    public void add(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry);
            if (givenPosition == 1) // Case 1
            {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            } else // Case 2: List is not empty
            { // and givenPosition > 1
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            } // end if
            numberOfEntries++;
        } else {
             throw new IndexOutOfBoundsException("Illegal position given to add operation.");
        }
    } // end add

    public T remove(int givenPosition) {
        T result = null; // Return value
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            if (givenPosition == 1) // Case 1: remove first entry
            {
                result = firstNode.getData(); // Save entry to be removed
                firstNode = firstNode.getNextNode(); // Remove entry
            } else // Case 2: Not first entry
            {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData(); // Save entry to be removed
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);  // Remove entry
            } // end if
            numberOfEntries--;              // Update count
            return result;
        } 
        else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");

    } // end remove
    
    public void clear() {
        firstNode = null;
        numberOfEntries = 0;
    } // end clear

    public T replace(int givenPosition, T newEntry) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            Node desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        }
       else
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");

    } // end replace
    
    public T getEntry(int givenPosition) {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            return  getNodeAt(givenPosition).getData();
        } else 
             throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    } // end getEntry
    
    public T[] toArray() {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        } // end while
        return result;
    } // end toArray
    
    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.getData())) {
                found = true;
            } else {
                currentNode = currentNode.getNextNode();
            }
        } // end while
        return found;
    } // end contains
    
    public int getLength() {
        return numberOfEntries;
    }
    
    public boolean isEmpty() {
        boolean result;
        if (numberOfEntries == 0) // Or getLength() == 0
        {
            assert firstNode == null;
            result = true;
        } else {
            assert firstNode != null;
            result = false;
        } // end if
        return result;
    } // end isEmpty


	@Override
	public void addFirst(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newEntry);
		if (isEmpty()) {
			firstNode = newNode;
			lastNode = newNode;
		}
		else {
			newNode.setNextNode(firstNode);
			firstNode = newNode;
		}
		numberOfEntries++;
	}

	@Override
	public void addLast(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newEntry);
		if (isEmpty()) {
			firstNode = newNode;
			lastNode = newNode;
		}
		else {
			lastNode.setNextNode(newNode);
			lastNode = newNode;
		}
		numberOfEntries++;
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		T result = null;
		if (!isEmpty()) {
			result = firstNode.getData();
			firstNode = firstNode.getNextNode();
			if (numberOfEntries == 1) {
				lastNode = null;
			}
			numberOfEntries--;
		}
		return result;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		T result = null;
		if (!isEmpty()) {
			result = lastNode.getData();
			lastNode = getNodeAt(numberOfEntries - 1);
			numberOfEntries--;
		}
		return result;
	}

	@Override
	public T getFirst() {
		// TODO Auto-generated method stub
		T result = null;
		result = firstNode.getData();
		return result;
	}

	@Override
	public T getLast() {
		// TODO Auto-generated method stub
		T result = null;
		result = lastNode.getData();
		return result;
	}

	@Override
	public void moveToEnd() {
		// TODO Auto-generated method stub
		
		if (firstNode.getNextNode() != null) {
			Node endNode = firstNode;
			firstNode = firstNode.getNextNode();
			Node temp = firstNode;
			
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = endNode;
		}
		
	}
    


}
