package model;

import java.util.EmptyStackException;

public interface IPilha<E> {

	public void push(E element);
	public E pop() throws EmptyStackException;
	public E top() throws EmptyStackException;
	public int size();
	public boolean isEmpty();
	public void clean();
	
}
