/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pucrs.simulaemula.model;

import com.pucrs.simulaemula.util.Config;
import java.util.ArrayList;

/**
 *
 * @author Carolina
 */
public class Estatistica {

    private double valor;
    private int contador;

    private ArrayList fila;

    private int totalClientes = 0;

    public Estatistica() {
        contador = 0;
        valor = 0;
        fila = new ArrayList();
    }

    public double getValor() { /*Valor */ // elementos
        return (valor);
    }

    public int getContagem() { /*Contador*/ //contador para valor total de elementos.
        return contador;
    }

    public void adicionar(double n) {//* Adiciona elementos no valor e soma o contador *//
        fila.add(n);
        contador++;
    }

    public void adicionar(int n) { /*mesma coisa do de cima*/
        fila.add(n);
        contador++;
    }

    public double numeroDeAtendimentos(Caixa num) {
        return (num.getNumeroAtendidos());
    }

    public double tempoMedioAtendimento(Cliente tempo, Caixa num) {
        return (double) ((tempo.getTempoAtendimento() / num.getNumeroAtendidos()));
    }

    public double mediana(Caixa num) {
        int meio = (num.getNumeroAtendidos()) / 2;
        if (meio % 2 == 1) {
            return (num.getNumeroAtendidos() + 1) / 2;
        } else {
            return (meio - 1 + meio) / 2.0;
        }
    }

    public double getMedia() {
        if (getContagem() != 0) {
            return getValor() / getContagem();
        } else {
            return 0;
        }
    }

    public double atendimentoSemEspera(Cliente tempo) {
        int cont = 0;
        if (tempo.getInstanteChegada() != 0) {
            return 0;
        } else {
            while (tempo.getInstanteChegada() == 0) {
                cont++;
            }
            return cont;
        }
    }

    public double filaVazia(Caixa tempo) {
        int temp = 0;
        while (fila.isEmpty() == true) {
            temp++;
        }
        return temp;
    }

    public double medianaFila() {
        int meio = (int) ((valor) / 2);
        if (meio % 2 == 1) {
            return (valor + 1) / 2;
        } else {
            return (meio - 1 + meio) / 2.0;
        }
    }

    public int maximoFila() {
        int numeroMaximo = 0;
        for (int i = 0; i < fila.size(); i++) {
            numeroMaximo = Math.max(numeroMaximo, i);
        }
        return numeroMaximo;
    }

    public int maximoAtendente(Caixa cx) {
        int numeroMaximo = 0;
        for (int i = 0; i < cx.size(); i++) {
            numeroMaximo = Math.max(numeroMaximo, i);
        }
        return numeroMaximo;
    }

    public int minimoAtendente(Caixa numMin) {
        int numeroMinimo = 0;
        for (int i = 0; i < numMin.size(); i++) {
            numeroMinimo = Math.min(numeroMinimo, i);
        }
        return numeroMinimo;
    }
    
    /*public double variancia() {
     double x1 = 1 / (double) caixa.getClientesAtendidos().size() - 1;
     double x2 = caixa.getSomaNumerosAtendidosAoQuadrado() - (Math.pow(caixa.getNumeroAtendidos(), 2) / Double.valueOf(caixa.getClientesAtendidos().size()));
     return x1 * x2;
     }
    
     public double desvioPadrao() {
     return Math.sqrt(variancia());
     }
     */
}
