/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.furb.linguagensformais.aplicacao.enums;

/**
 *
 * @author Gabriel Bernardi
 */
public enum EnumResultado {
    
    PALAVRA_VALIDA("Palavra Válida"),
    PALAVRA_INVALIDA("Erro: Palavra Inválida"),
    SIMBOLO_INVALIDO("Erro: Símbolo(s) Inválido(s)"),
    SIMBOLO_ESPECIAL("Símbolo Especial");
    
    private String valor;

    EnumResultado(String valor) {
        this.valor = valor;
    }
    
    public String getValor(){
        return this.valor;
    }
}
