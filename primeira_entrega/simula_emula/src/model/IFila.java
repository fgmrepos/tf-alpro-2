package model;

public interface IFila<E>
{
    void enqueue(E element);
    E dequeue();
    int size();
    boolean isEmpty();
    void clear();
    E element();
}