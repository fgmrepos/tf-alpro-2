/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pucrs.simulaemula.interfaces;

/**
 *
 * @author Felipe
 */
public interface IQueue<E> {

    void enqueue(E element);

    E dequeue();

    int size();

    boolean isEmpty();

    void clear();

    E element();
}
