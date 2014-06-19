/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pucrs.simulaemula.util;

import java.util.Random;

/**
 *
 * @author Felipe
 */
public class GeradorClientes {
    private double probabilidade;
    private int quantidadeGerada;
    private static final Random gerador = new Random();
    
    public GeradorClientes (double p){
        probabilidade = p;
        quantidadeGerada = 0;
    }
    public boolean gerar() {
        boolean gerado = false;
        if(gerador.nextDouble() < probabilidade){
            quantidadeGerada++;
            gerado = true;
        }
        return gerado;
    }
    public int getQuantidadeGerada(){
        return quantidadeGerada;
    }
}
