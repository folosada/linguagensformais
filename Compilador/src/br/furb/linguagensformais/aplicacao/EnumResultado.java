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
public enum EnumResultado {
    
    PALAVRA_VALIDA("Palavra Válida"),
    PALAVRA_INVALIDA("Erro: Palavra Inválida"),
    SIMBOLO_INVALIDA("Erro: Símbolo Inválida"),
    SIMBOLO_ESPECIAL("Símbolo Especial");
    
    private String resultado;

    EnumResultado(String resultado) {
        this.resultado = resultado;
    }
    
    public String getResultado(){
        return this.resultado;
    }
}
