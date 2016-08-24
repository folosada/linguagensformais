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
public class ExceptionSequenciaInvalida extends Exception{
    
    public ExceptionSequenciaInvalida(String messageError) {
        super("Erro: " + messageError);
    }
}
