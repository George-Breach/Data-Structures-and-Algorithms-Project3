package Interfaces;

public interface DoubleEndedInterface<T> {

	// methods needed for double ended interface
    public void addFirst(T newEntry);
   
    public void addLast(T newEntry);
    
    public T removeFirst();
    
    public T removeLast();

    public T getFirst();

    public T getLast();
    
    public void moveToEnd();
    
} // end DoubleEndedInterface
