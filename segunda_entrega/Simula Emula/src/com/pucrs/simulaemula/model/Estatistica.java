/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pucrs.simulaemula.model;

import java.util.Arrays;

/**
 *
 * @author Lucinara
 */
public class Estatistica {
    private Cliente client;
    private Caixa caixa;
    
        
    private int totalClientes = 0;

    public Estatistica(){
        client = null;
        caixa = null;
    }
    public int numeroDeAtendimentos(){
        return caixa.getNumeroAtendidos();
    }
    public double mediaAtendimento(){
        double media = client.getTempoAtendimento() / caixa.getNumeroAtendidos();
        return media;
    }
    public double mediana(){
        int meio = (caixa.getNumeroAtendidos())/2;
        if(meio % 2 == 1){
            return (caixa.getNumeroAtendidos()+1)/2;
        } else{
            return (meio-1 + meio) / 2.0;
        }
    }
  public int maximo(){
        int numeroMaximo = 0;
        numeroMaximo = Math.max(numeroMaximo, caixa.getNumeroAtendidos());
        return numeroMaximo;
    }
    public int minimo(){
        int numeroMinimo = 0;
        numeroMinimo = Math.min(numeroMinimo, caixa.getNumeroAtendidos());
        return numeroMinimo;
    }  
}
