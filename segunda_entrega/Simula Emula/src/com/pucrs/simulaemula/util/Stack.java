/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pucrs.simulaemula.util;

import com.pucrs.simulaemula.interfaces.IStack;
import java.util.EmptyStackException;

/**
 *
 * @author Ingrid Manfrim
 */
public class Stack<E> implements IStack<E> {

   
    private static final class Node<E> {

        public E element;
        public Stack.Node<E> next;

        public Node(E e) {
            element = e;
            next = null;
        }
    }

    private Stack.Node<E> head;
    private Stack.Node<E> tail;
    private int count;

    @Override
    public void push(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public E pop() throws EmptyStackException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public E top() throws EmptyStackException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int size() {
       return count;
    }
    
    @Override
    public boolean isEmpty() {
        if(count==0){
            return true;
        }
        return false;
    }
    
    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
