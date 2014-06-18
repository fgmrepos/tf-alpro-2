/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pucrs.simulaemula.util;

import com.pucrs.simulaemula.interfaces.IQueue;
import com.pucrs.simulaemula.exceptions.EmptyQueueException;

/**
 *
 * @author Felipe
 */
public class Queue<E> implements IQueue<E> {

    private static final class Node<E> {

        public E element;
        public Node<E> next;

        public Node(E e) {
            element = e;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int count;

    public Queue() {
        head = null;
        tail = null;
        count = 0;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public E element() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return head.element;
    }

    public void enqueue(E element) {
        Node<E> n = new Node<E>(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }

    public E dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Node<E> target = head;
        E item = target.element;
        head = target.next;
        target.element = null;
        target.next = null;
        if (head == null) {
            tail = null;
        }
        count--;
        return item;
    }

}
