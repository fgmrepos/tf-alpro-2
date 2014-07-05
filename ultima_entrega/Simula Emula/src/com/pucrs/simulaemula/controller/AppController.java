/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pucrs.simulaemula.controller;

import com.pucrs.simulaemula.model.Cliente;
import com.pucrs.simulaemula.model.Estatistica;
import com.pucrs.simulaemula.util.CategoriaCliente;
import com.pucrs.simulaemula.util.Config;
import com.pucrs.simulaemula.util.GeradorClientes;

/**
 *
 * @author felipe
 */
public class AppController {

    public Config config;
    private GeradorClientes gerador;
    private Cliente cliente;
    private StringBuilder retorno;

    public AppController(CategoriaCliente categoria) {
        config = Config.getInstance(categoria);
        gerador = new GeradorClientes(config.probabilidade_chegada);
        this.retorno = new StringBuilder();
        this.retorno.append("Cliente: " + categoria.toString() + "\n\n");
    }

    public String Simular() {
        Estatistica estatisticas = new Estatistica();
        for (int tempo = 0; tempo < config.duracao_simulacao; tempo++) {
            this.GerarCliente(tempo);
            this.VerificarCaixas(tempo);
        }
        this.retorno.append("\nEstatísticas:\n");
        for (int i = 0; i < config.num_caixas; i++) {
            this.retorno.append("Total de Atendidos Caixa " + (i + 1) + ": " + config.caixas[i].getNumeroAtendidos() + "\n");
        }
        this.retorno.append("\nComprimento da Fila: " + estatisticas.getMedia());
        return this.retorno.toString();
    }

    public void GerarCliente(int tempo) {
        // Gerador de clientes
        // Gera clientes com base em uma probabilidade de chegada e adiciona
        // a primeira etapa do atendimento
        if (gerador.gerar()) {
            // Foi gerado um cliente, adiciona o mesmo na primeira etapa
            // O cliente gerado sempre entra na primeira etapa, logo foi setado o index da fila ou pilha para 0 (primeira)
            this.cliente = new Cliente(gerador.getQuantidadeGerada(), tempo, 1, config.tempo_min_atendimento_por_etapa[0], config.tempo_max_atendimento_por_etapa[0]);
            if (config.tipos_etapas[0] == 0) {
                config.filas[0].enqueue(this.cliente);
            } else {
                config.pilhas[0].push(this.cliente);
            }
            if (config.trace) {
                this.retorno.append(
                        "Tempo: " + tempo
                        + "| Nº cliente: "
                        + this.cliente.getNumero()
                        + "| Tempo de atendimento: "
                        + this.cliente.getTempoAtendimento()
                        + " min" + "| Etapa: "
                        + config.filas[0].etapa
                        + "| Total clientes na fila: "
                        + config.filas[0].size()
                        + "| O cliente "
                        + this.cliente.getNumero()
                        + " entra na fila\n");
                
            }
        }
    }

    public void VerificarCaixas(int tempo) {
        // Percorre os caixas para verificar se há um disponível
        for (int i = 0; i < config.num_caixas; i++) {
            if (config.caixas[i].estaVazio()) {
                // Havendo algum disponível, percorre as etapas de atendimento
                for (int j = 0; j < config.num_etapas; j++) {
                    // Verifica o tipo de estrutura de dados utilizada na etapa atual
                    if (config.tipos_etapas[j] == 0) {
                        // Fila
                        // Verifica se há algum cliente esperando pelo atendimento
                        if (!config.filas[j].isEmpty()) {
                            // Atende um cliente se o mesmo for da etapa correta
                            if (config.caixas[i].getEtapa() == config.filas[j].etapa) {
                                config.caixas[i].atenderNovoCliente((Cliente) config.filas[j].dequeue());
                            }
                            if (config.trace) {
                                this.retorno.append(
                                        "Tempo: " + tempo
                                        + "| Nº cliente: " + this.cliente.getNumero()
                                        + "| Tempo de atendimento: " + this.cliente.getTempoAtendimento() + " min"
                                        + "| Etapa: " + this.cliente.etapa
                                        + "| Total clientes na fila: " + config.filas[j].size()
                                        + "| O cliente " + this.cliente.getNumero() + " vai para o caixa " + (i + 1) + "\n"
                                );
                            }
                        }
                    } else {
                        // Pilha
                    }
                }
            } else {
                // Decrementa o tempo do cliente
                if (config.caixas[i].getClienteAtual().getTempoAtendimento() == 0) {
                    // Libera o cliente
                    if (config.caixas[i].getClienteAtual().etapa < config.num_etapas) {
                        // Incrementa a etapa
                        this.cliente = config.caixas[i].dispensarClienteAtual();
                        this.cliente.trocaEtapa();
                        this.cliente.setTempoAtendimento(config.tempo_min_atendimento_por_etapa[this.cliente.etapa - 1], config.tempo_max_atendimento_por_etapa[this.cliente.etapa - 1]);
                        config.filas[this.cliente.etapa - 1].enqueue(this.cliente);
                        if (config.trace) {
                            this.retorno.append(
                                    "Tempo: " + tempo
                                    + "| Nº cliente: " + this.cliente.getNumero()
                                    + "| Tempo de atendimento: " + this.cliente.getTempoAtendimento() + " min"
                                    + "| Etapa: " + config.filas[this.cliente.etapa - 1].etapa
                                    + "| Total clientes na fila: " + config.filas[this.cliente.etapa - 1].size()
                                    + "| O cliente " + this.cliente.getNumero() + " passou para a próxima etapa\n"
                            );
                        }
                    } else {
                        Cliente c = config.caixas[i].dispensarClienteAtual();
                        // O cliente concluiu o atendimento
                        if (config.trace) {

                            this.retorno.append(
                                    "Tempo: " + tempo
                                    + "| Nº cliente: " + c.getNumero()
                                    + "| Tempo de atendimento: " + c.getTempoAtendimento() + " min"
                                    + "| O cliente " + c.getNumero() + " concluiu o atendimento\n"
                            );
                        }
                    }
                } else {
                    config.caixas[i].getClienteAtual().decrementarTempoAtendimento();
                    if (config.trace) {
                        this.retorno.append(
                                "Tempo: " + tempo
                                + "| Nº cliente: " + this.cliente.getNumero()
                                + "| Tempo de atendimento: " + this.cliente.getTempoAtendimento() + " min"
                                + "| Etapa: " + config.caixas[i].getEtapa()
                                + "| Total clientes na fila: " + config.filas[config.caixas[i].getEtapa() - 1].size()
                                + "| Decrementado o tempo do cliente " + this.cliente.getNumero() + "\n"
                        );
                    }
                }
            }
        }
    }

}
