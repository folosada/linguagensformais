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
    private StringBuilder caminho;
    
    public Automato(){
        caminho = new StringBuilder();
    }
    
    public void q0(String seq, int index) throws ExceptionSequenciaInvalida{
        this.caminho.append(EnumRotuloReconhecimento.Q0.getRotulo());
        char caracter = seq.charAt(index);
        if (caracter == 'a'){
            this.q1q5(seq, index++);
        } else if (caracter == 'b' || caracter == 'c'){
            this.q7(seq, index++);
        }
    }

    private void q1q5(String seq, int index) {
        this.caminho.append(", ").append(EnumRotuloReconhecimento.Q1_Q5.getRotulo());
        if (this.fimSequencia(seq, index)){
            char caracter = seq.charAt(index);
            if (caracter == 'a'){
                this.q1q6(seq, index++);
            } else if (caracter == 'b'){
                this.q2(seq, index++);
            } else {
            }
        }
    }

    private void q7(String seq, int i) {
        
    }
    
    private void q1q6(String seq, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void q2(String seq, int index) {
        
    }
    
    private boolean fimSequencia(String seq, int index){
        return seq.length() == index;
    }
}
