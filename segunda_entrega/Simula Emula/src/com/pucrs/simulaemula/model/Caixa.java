/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pucrs.simulaemula.model;

import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class Caixa {

    private Cliente clienteAtual;
    private int etapa;
    private Cliente tempo;
    private ArrayList<Cliente> clientesAtendidos;
    
    public Caixa() {
        clienteAtual = null;
        tempo = null;
        ArrayList<Cliente> clientesAtendidos = new ArrayList<Cliente>(); 
        
    }
    
    public void atenderNovoCliente(Cliente c) {
        clienteAtual = c;
    }

    public Cliente dispensarClienteAtual() {
        Cliente c = clienteAtual;
        clienteAtual = null;
        clientesAtendidos.add(c);
        return c;
    }

    public boolean estaVazio() {
        return (clienteAtual == null);
    }

    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    public int getNumeroAtendidos() {
        return clientesAtendidos.size();
    }
    
    public double getSomaNumerosAtendidosAoQuadrado(){
      double total = 0;
      for(int i = 0; i < clientesAtendidos.size(); i++){
          total += Math.pow(clientesAtendidos.size(), 2);
      }
      return total;
    }
    public int getEtapa() {
        return this.etapa;
    }

    public void setEtapa(int value) {
        this.etapa = value;
    }
    
     /*Método criado para retornar tempo medio de atendimento por caixa*/
    public double getMediaAtendimento(){
        
        double media = tempo.getTempoAtendimento()/clientesAtendidos.size();
        return media;
    } 
    
    public ArrayList<Cliente> getClientesAtendidos(){
        return clientesAtendidos;
    }
}


