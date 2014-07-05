/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pucrs.simulaemula.model;

import java.util.Random;

/**
 *
 * @author Felipe
 */
public class Cliente {

    private int numero;
    private int instanteChegada;
    private int tempoAtendimento;
    private static final Random gerador = new Random();
    public int etapa;

    public Cliente(int n, int c, int e, int tempoMin, int tempoMax) {
        etapa = 1;
        numero = n;
        instanteChegada = c;
        etapa = e;
    }

    public int getNumero() {
        return numero;
    }

    public int getInstanteChegada() {
        return instanteChegada;
    }

    public void decrementarTempoAtendimento() {
        tempoAtendimento--;
    }

    public int getTempoAtendimento() {
        return tempoAtendimento;
    }
    
    public void setTempoAtendimento(int tempoMin, int tempoMax) {
        tempoAtendimento = gerador.nextInt(tempoMax - tempoMin + 1) + tempoMin;
    }
    
    public void trocaEtapa() {
        this.etapa++;
    }

}
