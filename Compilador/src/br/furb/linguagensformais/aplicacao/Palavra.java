/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.linguagensformais.aplicacao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gabriel Bernardi
 */
public class Palavra {
//    private static final String separador = "\\n";
    private String sequencia;
    private int linha;

    public Palavra(){}

    public String getSequencia() {
        return sequencia;
    }

    public void setSequencia(String sequencia) {
        this.sequencia = sequencia;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }
}
