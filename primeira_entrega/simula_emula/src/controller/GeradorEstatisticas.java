package controller;

import model.Estatisticas;

public class GeradorEstatisticas {

	/* Atendentes */
	private int numeroAtendimentos;
	private double tempoMedioAtendimento;
	private double medianaAtendimentos;
	private double desvioPadraoAtendimentos;
		
	/* FILA */
	private int tempoEsperaFila;
	private int tamanhoMaximoFila;
	private int tempoMaximoEspera;
	private double tempoMedioEspera;
	private int atendimentosSemEspera;
	private int tempoFilaVazia;
	private double medianaFila;
	private double desvioPadraoFila;
	
	public int getNumeroAtendimentos() {
		return 0;
	}
	
	public double getTempoMedioAtendimento() {
		return 1.0;
	}
	
	public double getMedianaAtendimento() {
		return 1.0;
	}
	
	public double getDesvioPadraoAtendimentos() {
		return 1.0;
	}
	
	public int getTempoEsperaFila() {
		return 0;
	}
	
	public int getTamanhoMaximoFila() {
		return 0;
	}
	
	public int getTempoMaximoEspera() {
		return 0;
	}
	
	public double getTempoMedioEspera() {
		return 0;
	}
	
	public int getAtendimentosSemEspera() {
		return 0;
	}
	
	public int getTempoFilaVazia() {
		return 0;
	}

	public double getMedianaFila() {
		return 1.0;
	}
	
	public double getDesvioPadraoFila() {
		return 1.0;
	}
	
	
}
