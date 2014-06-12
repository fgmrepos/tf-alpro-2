package model;

public class Caixa {
	
	private Cliente clienteAtual;
	private int numeroAtendidos;
	private int etapa;

	public Caixa() {
	    clienteAtual = null;
	    numeroAtendidos = 0;
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
	
}