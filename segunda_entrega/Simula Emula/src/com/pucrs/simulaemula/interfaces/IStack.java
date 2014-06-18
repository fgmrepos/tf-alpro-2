/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pucrs.simulaemula.interfaces;

import java.util.EmptyStackException;

/**
 *
 * @author Felipe
 */
public interface IStack<E> {

    public void push(E element);

    public E pop() throws EmptyStackException;

    public E top() throws EmptyStackException;

    public int size();

    public boolean isEmpty();

    public void clean();
}
