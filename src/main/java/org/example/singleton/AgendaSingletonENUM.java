package org.example.singleton;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public enum AgendaSingletonENUM {


   INSTANCE ;

    private Map<String, Boolean> diasDisponiveis = new HashMap<>();


    private AgendaSingletonENUM(){
        diasDisponiveis.put("Domingo", true);
        diasDisponiveis.put("Segunda", true);
        diasDisponiveis.put("Terca", true);
        diasDisponiveis.put("Quarta", true);
        diasDisponiveis.put("Quinta", true);
        diasDisponiveis.put("Sexta", true);
        diasDisponiveis.put("Sabado", true);
    }

    public static AgendaSingletonENUM getInstance(){

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

