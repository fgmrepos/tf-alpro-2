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

    private Node<E> header;
    // Referência para o sentinela de fim da lista encadeada.
    private Node<E> trailer;
    // Contador do número de elementos da lista.
    private int count;
    public int etapa;

    @Override
    public void clean() {
        header.next = null;
        trailer.prev = null;
        count = 0;
    }

    private class Node<T> {

        public T element;
        public Node<T> next;
        public Node<T> prev;

        public Node(T e) {
            element = e;
            next = null;
            prev = null;
        }
    }
    /*Construtor*/

    public Stack() {
        header = new Node<>(null);
        trailer = new Node<>(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }
    /*Adiciona um elemento na pilha, sempre na primeira posíção*/

    @Override
    public void push(E element) {
        Node<E> n = new Node<>(element);

        /* if(size()==0){
         header.next = n;
         trailer.prev = n;
         n.prev = header;
         n.next = trailer;
         }*/
        n.next = header.next.prev;
        header.next.prev = n;
        header.next = n;
        n.prev = header;

        count++;

    }

    //Eliminando arquivos
    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty() == true) {
            throw new EmptyStackException();
        }
        Node<E> aux = header.next;

        E elem = header.next.element;

        header.next = aux.next;
        aux.next.prev = header;
        count--;

        return elem;
    }
    /*Retorna o primeiro elemento da pilha, porém não o remove*/

    @Override
    public E top() throws EmptyStackException {
        if (isEmpty() == true) {
            throw new EmptyStackException();
        }
        Node<E> aux = header.next;

        E elem = aux.element;

        return elem;

    }

    /*Retorna o seu tamanho*/
    @Override
    public int size() {
        return count;
    }
    /*Retorna se a pilha está vazia*/

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

}
