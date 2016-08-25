/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.linguagensformais.aplicacao;

/**
 *
 * @author gsbernardi
 */
public class Automato {
    private StringBuilder reconhecimento;
    private String resultado;
    
    public Automato(){
        this.reconhecimento = new StringBuilder();
        this.resultado = "";
    }
    
    public void q0(String seq, int index){
        this.reconhecimento.append(EnumRotuloReconhecimento.Q0.getRotulo());
        char caracter = seq.charAt(index);
        if (caracter == 'a'){
            this.q1q5(seq, index);
        } else if (caracter == 'b' || caracter == 'c'){
            this.q7(seq, index);
        } else {
            this.sequenciaInvalida(caracter);
        }
    }

    private void q1q5(String seq, int index) {
        this.reconhecimento.append(", ").append(EnumRotuloReconhecimento.Q1_Q5.getRotulo());
        index = index + 1;
        if (!this.fimSequencia(seq, index)){
            char caracter = seq.charAt(index);
            if (caracter == 'a'){
                this.q1q6(seq, index);
            } else if (caracter == 'b'){
                this.q2(seq, index);
            } else {
                this.sequenciaInvalida(caracter);
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_VALIDA.getValor();
        }
    }
    
    private void q7(String seq, int index) {
        this.reconhecimento.append(", ").append(EnumRotuloReconhecimento.Q7.getRotulo());
        index = index + 1;
        if (!this.fimSequencia(seq, index)){
            char caracter = seq.charAt(index);
            if (caracter == 'b' || caracter == 'c'){
                this.q8(seq, index);
            } else {
                this.sequenciaInvalida(caracter);
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_VALIDA.getValor();
        }
    }
    
    private void q1q6(String seq, int index) {
        this.reconhecimento.append(", ").append(EnumRotuloReconhecimento.Q1_Q6.getRotulo());
        index = index + 1;
        if (!this.fimSequencia(seq, index)){
            char caracter = seq.charAt(index);
            if (caracter == 'a'){
                this.q1q5(seq, index);
            } else if (caracter == 'b'){
                this.q2q7(seq, index);
            } else if (caracter == 'c'){
               this.q7(seq, index); 
            } else {
                this.sequenciaInvalida(caracter);
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_VALIDA.getValor();
        }
    }
    
    private void q2(String seq, int index) {
        this.reconhecimento.append(", ").append(EnumRotuloReconhecimento.Q2.getRotulo());
        index = index + 1;
        if (!this.fimSequencia(seq, index)){
            char caracter = seq.charAt(index);
            if (caracter == 'a'){
                this.q3(seq, index);
            } else {
                this.sequenciaInvalida(caracter);
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_INVALIDA.getValor();
        }
    }
    
    private void q8(String seq, int index) {
        this.reconhecimento.append(", ").append(EnumRotuloReconhecimento.Q8.getRotulo());
        index = index + 1;
        if (!this.fimSequencia(seq, index)){
            char caracter = seq.charAt(index);
            if (caracter == 'b' || caracter == 'c'){
                this.q7(seq, index);
            } else {
                this.sequenciaInvalida(caracter);
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_INVALIDA.getValor();
        }
    }
    
    private void q2q7(String seq, int index) {
        this.reconhecimento.append(", ").append(EnumRotuloReconhecimento.Q2_Q7.getRotulo());
        index = index + 1;
        if (!this.fimSequencia(seq, index)){
            char caracter = seq.charAt(index);
            if (caracter == 'a'){
                this.q3(seq, index);
            } else if (caracter == 'b' || caracter == 'c'){
                this.q8(seq, index);
            } else {
                this.sequenciaInvalida(caracter);
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_VALIDA.getValor();
        }
    }
    
    private void q3(String seq, int index) {
        this.reconhecimento.append(", ").append(EnumRotuloReconhecimento.Q3.getRotulo());
        index = index + 1;
        if (!this.fimSequencia(seq, index)){
            char caracter = seq.charAt(index);
            if (caracter == 'a'){
                this.q4(seq, index);
            } else if (caracter == 'b'){
                this.q2(seq, index);
            } else {
                this.sequenciaInvalida(caracter);
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_VALIDA.getValor();
        }
    }
    
    private void q4(String seq, int index) {
        this.reconhecimento.append(", ").append(EnumRotuloReconhecimento.Q4.getRotulo());
        index = index + 1;
        if (!this.fimSequencia(seq, index)){
            char caracter = seq.charAt(index);
            if (caracter == 'a'){
                this.q3(seq, index);
            } else {
                this.sequenciaInvalida(caracter);
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_INVALIDA.getValor();
        }
    }
    
    //MÉTODOS AUXILIARES
    private boolean fimSequencia(String seq, int index){
        return seq.length() == index;
    }
    
    private void sequenciaInvalida(char caracter) {
        if (this.isCaracterEspecifico(caracter)){
            this.resultado = EnumResultado.SIMBOLO_INVALIDO.getValor();
        } else {
            this.resultado = EnumResultado.PALAVRA_INVALIDA.getValor();
        }
        this.reconhecimento.append(", ").append(EnumRotuloReconhecimento.Q_ERRO.getRotulo());
    }
    
    private boolean isCaracterValido(char caracter) {
        return caracter == 'a' || caracter == 'b' || caracter == 'c';
    }
    
    private boolean isCaracterEspecifico(char caracter){
        return !Character.isLetter(caracter) 
                && !Character.isDigit(caracter);
    }
    
    //GETTERS E SETTERS
    public StringBuilder getReconhecimento() {
        return reconhecimento;
    }

    public String getResultado() {
        return resultado;
    }
}
