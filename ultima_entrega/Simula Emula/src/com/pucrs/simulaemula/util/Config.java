/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pucrs.simulaemula.util;

import com.pucrs.simulaemula.model.Caixa;
import com.pucrs.simulaemula.model.Cliente;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author felipe
 */
public class Config {

    public static Config config = new Config();
    public CategoriaCliente categoria_cliente;
    public int duracao_simulacao = 0;
    public double probabilidade_chegada;
    public int num_filas = 0;
    public int num_pilhas = 0;
    public int num_etapas = 0;
    public int[] tipos_etapas;
    public int num_caixas = 0;
    public int[] num_caixas_por_etapa;
    public int[] tempo_min_atendimento_por_etapa;
    public int[] tempo_max_atendimento_por_etapa;
    public Caixa[] caixas;
    public Queue[] filas;
    public Stack[] pilhas;
    public boolean trace;

    public Config() {
        Properties properties = new Properties();
        try {
            // Objeto Properties
            properties.load(Config.class.getResourceAsStream("/com/pucrs/simulaemula/config/app.properties"));

            // Duração da simulação
            duracao_simulacao = Integer.parseInt(properties.getProperty("duracao_simulacao"));

            // Probabilidade de chegada de novos clientes
            probabilidade_chegada = Double.parseDouble(properties.getProperty("probabilidade_chegada"));

            // Número de etapas
            num_etapas = Integer.parseInt(properties.getProperty("num_etapas"));

            // Número de caixas
            num_caixas = Integer.parseInt(properties.getProperty("num_caixas"));

            // Número de caixas por etapa e tipos das etapas
            num_caixas_por_etapa = new int[num_etapas];
            tipos_etapas = new int[num_etapas];
            for (int i = 0; i < num_etapas; i++) {
                num_caixas_por_etapa[i] = Integer.parseInt(properties.getProperty("num_caixas_etapa_" + (i + 1)));
                tipos_etapas[i] = Integer.parseInt(properties.getProperty("tipo_etapa_" + (i + 1)));
            }

            // Número de filas e pilhas por etapa
            for (int i = 0; i < num_etapas; i++) {
                if (Integer.parseInt(properties.getProperty("tipo_etapa_" + (i + 1))) == 0) {
                    num_filas++;
                } else {
                    num_pilhas++;
                }
            }
            int etapa = 1;
            if (num_filas > 0 && num_pilhas == 0) {
                filas = new Queue[num_filas];
                for (int i = 0; i < num_filas; i++) {
                    Queue<Cliente> fila = new Queue<Cliente>();
                    fila.etapa = etapa;
                    filas[i] = fila;
                    etapa++;
                }
                etapa = 1;
            } else if (num_filas == 0 && num_pilhas > 0) {
                pilhas = new Stack[num_pilhas];
                for (int i = 0; i < num_filas; i++) {
                    Stack<Cliente> pilha = new Stack<Cliente>();
                    pilha.etapa = etapa;
                    pilhas[i] = pilha;
                    etapa++;
                }
                etapa = 1;
            } else {
                if (num_filas > 0) {
                    filas = new Queue[num_filas];
                    for (int i = 0; i < num_filas; i++) {
                        Queue<Cliente> fila = new Queue<Cliente>();
                        fila.etapa = etapa;
                        filas[i] = fila;
                        etapa++;
                    }
                }
                if (num_pilhas > 0) {
                    pilhas = new Stack[num_pilhas];
                    for (int i = 0; i < num_filas; i++) {
                        Stack<Cliente> pilha = new Stack<Cliente>();
                        pilha.etapa = etapa;
                        pilhas[i] = pilha;
                    }
                }
            }

            // Lista de caixas
            caixas = new Caixa[num_caixas];
            int j = 0;
            int acum = 0;
            for (int i = 0; i < num_caixas; i++) {
                if (num_caixas_por_etapa[j] <= i - acum) {
                    acum += num_caixas_por_etapa[j];
                    j++;
                }
                Caixa caixa = new Caixa();
                caixa.setEtapa(j + 1);
                caixas[i] = caixa;
            }

            // Tempo mínimo de atendimento por etapa
            tempo_min_atendimento_por_etapa = new int[num_etapas];
            for (int i = 0; i < num_etapas; i++) {
                tempo_min_atendimento_por_etapa[i] = Integer.parseInt(properties.getProperty("tempo_min_etapa_" + (i + 1)));
            }

            // Tempo máximo de atendimento por etapa
            tempo_max_atendimento_por_etapa = new int[num_etapas];
            for (int i = 0; i < num_etapas; i++) {
                tempo_max_atendimento_por_etapa[i] = Integer.parseInt(properties.getProperty("tempo_max_etapa_" + (i + 1)));
            }

            // Exibe passo a passo a simulação
            trace = Boolean.parseBoolean(properties.getProperty("trace"));

        } catch (IOException IOE) {
            System.out.println("Erro ao ler arquivo de configurações. " + IOE.getMessage());
        }
    }
    
    public static Config getInstance(CategoriaCliente categoriaCliente) {
        config.categoria_cliente = categoriaCliente;
        return config;
    }

}
