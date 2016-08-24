/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.linguagensformais.aplicacao;

/**
 *
 * @author Gabriel Bernardi
 */
public enum EnumRotuloReconhecimento {
    Q0("q0"),
    Q2("q2"),
    Q3("q3"),
    Q4("q4"),
    Q7("q7"),
    Q8("q8"),
    Q1_Q5("q1q5"),
    Q1_Q6("q1q6"),
    Q2_Q7("q2q7"),
    Q_ERRO("qerro");
    
    private String rotulo;

    EnumRotuloReconhecimento(String rotulo) {
        this.rotulo = rotulo;
    }
    
    public String getRotulo(){
        return this.rotulo;
    }
}
