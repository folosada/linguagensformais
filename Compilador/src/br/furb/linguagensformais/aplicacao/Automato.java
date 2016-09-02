/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.linguagensformais.aplicacao;

import br.furb.linguagensformais.aplicacao.enums.EnumRotulo;
import br.furb.linguagensformais.aplicacao.enums.EnumResultado;

/**
 *
 * @author gsbernardi
 */
public class Automato {
    private StringBuilder reconhecimento;
    private String resultado;
    private static int index; 
    
    public Automato(){
        this.reconhecimento = new StringBuilder();
        this.resultado = "";
        this.index = 0;
    }
    
    public void q0(String seq){
        this.reconhecimento.append(EnumRotulo.Q0.getRotulo());
        
        char caracter = seq.charAt(this.index);
        if (!this.isSimboloEspecial(caracter) && !this.fimSequencia(seq)){
            if (caracter == 'a'){
                this.q1q5(seq);
            } else if (caracter == 'b' || caracter == 'c'){
                this.q7(seq);
            } else {
                this.sequenciaInvalida();
            }
        } else {
            this.reconhecimento.append(", ").append(EnumRotulo.Q10.getRotulo());
            this.resultado = EnumResultado.SIMBOLO_ESPECIAL.getValor();
        }
    }

    private void q1q5(String seq) {
        this.reconhecimento.append(", ").append(EnumRotulo.Q1_Q5.getRotulo());
        this.iterarIndex();
        
        if (!this.fimSequencia(seq)){
            char caracter = seq.charAt(this.index);
            if (caracter == 'a'){
                this.q1q6(seq);
            } else if (caracter == 'b'){
                this.q2(seq);
            } else {
                this.sequenciaInvalida();
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_VALIDA.getValor();
        }
    }
    
    private void q7(String seq) {
        this.reconhecimento.append(", ").append(EnumRotulo.Q7.getRotulo());
        this.iterarIndex();
        
        if (!this.fimSequencia(seq)){
            char caracter = seq.charAt(this.index);
            if (caracter == 'b' || caracter == 'c'){
                this.q8(seq);
            } else {
                this.sequenciaInvalida();
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_VALIDA.getValor();
        }
    }
    
    private void q1q6(String seq) {
        this.reconhecimento.append(", ").append(EnumRotulo.Q1_Q6.getRotulo());
        this.iterarIndex();
        
        if (!this.fimSequencia(seq)){
            char caracter = seq.charAt(this.index);
            if (caracter == 'a'){
                this.q1q5(seq);
            } else if (caracter == 'b'){
                this.q2q7(seq);
            } else if (caracter == 'c'){
               this.q7(seq); 
            } else {
                this.sequenciaInvalida();
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_VALIDA.getValor();
        }
    }
    
    private void q2(String seq) {
        this.reconhecimento.append(", ").append(EnumRotulo.Q2.getRotulo());
        this.iterarIndex();
        
        if (!this.fimSequencia(seq)){
            char caracter = seq.charAt(this.index);
            if (caracter == 'a'){
                this.q3(seq);
            } else {
                this.sequenciaInvalida();
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_INVALIDA.getValor();
        }
    }
    
    private void q8(String seq) {
        this.reconhecimento.append(", ").append(EnumRotulo.Q8.getRotulo());
        this.iterarIndex();
        
        if (!this.fimSequencia(seq)){
            char caracter = seq.charAt(this.index);
            if (caracter == 'b' || caracter == 'c'){
                this.q7(seq);
            } else {
                this.sequenciaInvalida();
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_INVALIDA.getValor();
        }
    }
    
    private void q2q7(String seq) {
        this.reconhecimento.append(", ").append(EnumRotulo.Q2_Q7.getRotulo());
        this.iterarIndex();
        
        if (!this.fimSequencia(seq)){
            char caracter = seq.charAt(this.index);
            if (caracter == 'a'){
                this.q3(seq);
            } else if (caracter == 'b' || caracter == 'c'){
                this.q8(seq);
            } else {
                this.sequenciaInvalida();
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_VALIDA.getValor();
        }
    }
    
    private void q3(String seq) {
        this.reconhecimento.append(", ").append(EnumRotulo.Q3.getRotulo());
        this.iterarIndex();
        
        if (!this.fimSequencia(seq)){
            char caracter = seq.charAt(this.index);
            if (caracter == 'a'){
                this.q4(seq);
            } else if (caracter == 'b'){
                this.q2(seq);
            } else {
                this.sequenciaInvalida();
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_VALIDA.getValor();
        }
    }
    
    private void q4(String seq) {
        this.reconhecimento.append(", ").append(EnumRotulo.Q4.getRotulo());
        this.iterarIndex();
        
        if (!this.fimSequencia(seq)){
            char caracter = seq.charAt(this.index);
            if (caracter == 'a'){
                this.q3(seq);
            } else {
                this.sequenciaInvalida();
            }
        } else {
            this.resultado = EnumResultado.PALAVRA_INVALIDA.getValor();
        }
    }
    
    //MÉTODOS AUXILIARES
    private boolean fimSequencia(String seq){
        return seq.length() == this.index;
    }
    
    private void sequenciaInvalida() {
        if (this.index == 0){
            this.resultado = EnumResultado.SIMBOLO_INVALIDO.getValor();
        } else {
            this.resultado = EnumResultado.PALAVRA_INVALIDA.getValor();
        }
        this.reconhecimento.append(", ").append(EnumRotulo.Q_ERRO.getRotulo());
    }
    
    public boolean isSimboloEspecial(char caracter){
        return caracter == ';' || caracter == ',' || caracter == '.'; 
    }
    
    private void iterarIndex() {
        this.index++;
    }
    
    //GETTERS
    public StringBuilder getReconhecimento() {
        return reconhecimento;
    }

    public String getResultado() {
        return resultado;
    }
}
