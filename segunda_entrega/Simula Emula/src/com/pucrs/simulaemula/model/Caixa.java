/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pucrs.simulaemula.model;

/**
 *
 * @author Felipe
 */
public class Caixa {

    private Cliente clienteAtual;
    private int numeroAtendidos;
    private int etapa;
    private Cliente tempo;

    public Caixa() {
        clienteAtual = null;
        numeroAtendidos = 0;
        tempo = null;
        
    }

    public void atenderNovoCliente(Cliente c) {
        clienteAtual = c;
    }

    public Cliente dispensarClienteAtual() {
        Cliente c = clienteAtual;
        clienteAtual = null;
        numeroAtendidos++;
        return c;
    }

    public boolean estaVazio() {
        return (clienteAtual == null);
    }

    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    public int getNumeroAtendidos() {
        return numeroAtendidos;
    }

    public int getEtapa() {
        return this.etapa;
    }

    public void setEtapa(int value) {
        this.etapa = value;
    }
    
     /*Método criado para retornar tempo medio de atendimento por caixa*/
    public double getMediaAtendimento(){
        
        double media = tempo.getTempoAtendimento()/numeroAtendidos;
        return media;
    } 

}
