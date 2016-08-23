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
 * @author gsbernardi
 */
public class AutomotoTeste {
    private static AutomotoTeste uniqueInstance;
    private List<String> rotulo = new ArrayList<>(9);
    StringBuilder caminho = new StringBuilder();
    private int index;
    
    private AutomotoTeste(){}
    
    public static AutomotoTeste getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new AutomotoTeste();
            uniqueInstance.criarRotulos();
        }
        return uniqueInstance;
    }
    
    private void criarRotulos(){
        rotulo.add(0, "q0");
        rotulo.add(1, "q1q5");
        rotulo.add(2, "q7");
        rotulo.add(3, "q1q6");
        rotulo.add(4, "q2");
        rotulo.add(5, "q8");
        rotulo.add(6, "q2q7");
        rotulo.add(7, "q3");
        rotulo.add(8, "q4");
    }
    
    public boolean q0(String seq, int index){
        this.index = 0;
        switch (seq.charAt(index)){
            case 'a': 
                caminho.append(rotulo.get(0));
                this.q1q5(seq.charAt(index++));
                break;
            case 'b':
            case 'c': 
                caminho.append(rotulo.get(2));
                this.q7(seq.charAt(index++));
                break;
        }
        return false;
    }

    private void q1q5(char seq) {
    }

    private void q7(char charAt) {
    }
}
