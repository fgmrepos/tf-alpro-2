package controller;

import java.util.Random;

public class GeradorClientes {

	private double probabilidade;
    private int quantidadeGerada;
    private static final Random gerador = new Random();
    
    public GeradorClientes(double p)
    {
        probabilidade = p;
        quantidadeGerada = 0;
    }
    
    public boolean gerar()
    {
        boolean gerado = false;
        if(gerador.nextDouble() < probabilidade)
        {
            quantidadeGerada++;
            gerado = true;
        }
        return gerado;
    }
    
    public int getQuantidadeGerada()
    {
        return quantidadeGerada;
    }

}
