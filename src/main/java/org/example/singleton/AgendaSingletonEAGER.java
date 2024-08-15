package org.example.singleton;

import java.util.HashMap;
import java.util.Map;

public class AgendaSingletonEAGER {

    /* A classe é estatica para ser instaciada uma unica vez na memoria, e final para nao ser modificada*/
    private static final AgendaSingletonEAGER INSTANCE = new AgendaSingletonEAGER();

    private Map<String, Boolean> diasDisponiveis = new HashMap<>();


    private AgendaSingletonEAGER(){
        diasDisponiveis.put("Domingo", true);
        diasDisponiveis.put("Segunda", true);
        diasDisponiveis.put("Terca", true);
        diasDisponiveis.put("Quarta", true);
        diasDisponiveis.put("Quinta", true);
        diasDisponiveis.put("Sexta", true);
        diasDisponiveis.put("Sabado", true);
    }

    public static AgendaSingletonEAGER getInstance(){
        return INSTANCE;
    }

    public Map<String, Boolean> getDiasDisponiveis() {
        return diasDisponiveis;
    }

    public void ocupa (String dia){
        diasDisponiveis.replace(dia,Boolean.FALSE);
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "diasDisponiveis=" + diasDisponiveis +
                '}';
    }
}

