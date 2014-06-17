/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pucrs.simulaemula.util;

import com.pucrs.simulaemula.model.Caixa;

/**
 *
 * @author Felipe
 */
public class AppConfig {

    public static AppConfig config = new AppConfig();
    public static CategoriaCliente categoria_cliente;
    public static int duracao_simulacao = 0;
    public static double probabilidade_chegada;
    public static int num_filas = 0;
    public static int num_pilhas = 0;
    public static int num_etapas = 0;
    public static int num_caixas = 0;
    public static int[] num_caixas_por_etapa;
    public static int[] tempo_min_atendimento_por_etapa;
    public static int[] tempo_max_atendimento_por_etapa;
    public static Caixa[] caixas;
    public static Fila[] filas;
    public static Pilha[] pilhas;
    public static boolean trace;

    private AppConfig() {
        
    }

    
    
}
