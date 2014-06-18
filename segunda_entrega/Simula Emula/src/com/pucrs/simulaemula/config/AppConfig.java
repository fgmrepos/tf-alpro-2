/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pucrs.simulaemula.config;

import com.pucrs.simulaemula.model.Caixa;
import com.pucrs.simulaemula.model.Cliente;
import com.pucrs.simulaemula.util.CategoriaCliente;
import com.pucrs.simulaemula.util.Queue;
import com.pucrs.simulaemula.util.Stack;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Felipe
 */
public class AppConfig {

    public static AppConfig config = new AppConfig();
    public CategoriaCliente categoria_cliente;
    public int duracao_simulacao = 0;
    public double probabilidade_chegada;
    public int num_filas = 0;
    public int num_pilhas = 0;
    public int num_etapas = 0;
    public int num_caixas = 0;
    public int[] num_caixas_por_etapa;
    public int[] tempo_min_atendimento_por_etapa;
    public int[] tempo_max_atendimento_por_etapa;
    public Caixa[] caixas;
    public Queue[] filas;
    public Stack[] pilhas;
    public boolean trace;

    private AppConfig() {
        Properties properties = new Properties();
        try {
            // Objeto Properties
            properties.load(AppConfig.class.getResourceAsStream("/config/simulador.properties"));

            // Duração da simulação
            duracao_simulacao = Integer.parseInt(properties.getProperty("duracao_simulacao"));

            // Probabilidade de chegada de novos clientes
            probabilidade_chegada = Double.parseDouble(properties.getProperty("probabilidade_chegada"));

            // Número de etapas
            num_etapas = Integer.parseInt(properties.getProperty("num_etapas"));

            // Número de caixas
            num_caixas = Integer.parseInt(properties.getProperty("num_caixas"));

            // Número de caixas por etapa
            num_caixas_por_etapa = new int[num_etapas];
            for (int i = 0; i < num_etapas; i++) {
                num_caixas_por_etapa[i] = Integer.parseInt(properties.getProperty("num_caixas_etapa_" + (i + 1)));
            }

            // Número de filas e pilhas por etapa
            for (int i = 0; i < num_etapas; i++) {
                if (Integer.parseInt(properties.getProperty("tipo_etapa_" + (i + 1))) == 0) {
                    num_filas++;
                } else {
                    num_pilhas++;
                }
            }

            // Lista de filas
            filas = new Queue[num_filas];
            for (int i = 0; i < num_filas; i++) {
                Queue<Cliente> fila = new Queue<Cliente>();
                filas[i] = fila;
            }

            // Lista de pilhas
            pilhas = new Stack[num_pilhas];
            for (int i = 0; i < num_filas; i++) {
                Stack<Cliente> pilha = new Stack<Cliente>();
                pilhas[i] = pilha;
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

    public static AppConfig getInstance(CategoriaCliente categoriaCliente) {
        config.categoria_cliente = categoriaCliente;
        return config;
    }

}
