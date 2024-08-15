package org.example;

import org.example.builder.Pessoa;
import org.example.builder.PessoaLombok;
import org.example.factory.Produto;
import org.example.factory.ProdutoFactory;
import org.example.factory.TipoProdutoEnum;
import org.example.singleton.AgendaSingletonEAGER;
import org.example.singleton.AgendaSingletonENUM;
import org.example.singleton.AgendaSingletonLAZY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {




        /** Builder
         * Com metodologia de escrita builder
         * Fluencia de metodo, permite chamar os metodos em sequencia,
         * pois eles retornam o objeto, logo os metodos podem ser chamados novamente.
         */
        Pessoa pessoaBuilder = new Pessoa.PessoaBuilder()
                .nome("João Silva")
                .email("email.@email.com")
                .dataNascimento(new Date())
                .build();

        /**Pode-se Usar Lombok para diminuir a verbosidade dentro da classe pessoa.*/
        PessoaLombok.builder()
                .nome("João")
                .email("email@gmail.com")
                .dataNascimento(new Date())
                .build();

        /**
         * Factory Method
         * Utilizado para criar objetos complexos que exigem logica condicional, ,
         * aqui no exemplo, utilizamos um Produto que pode ou nao ter dimensões fisicas, sendo esta responsabilidade, atruibuida
         * e isolada no factory (getInstance).
         * A responsabilidade de saber se o produto possui dimensoes não é mais do cliente (programador) e sim da factory.
         * Aqui aplica o polimorfismo pois o resultado da criacao do factory está Referenciado a
         * super classe produto, porem trata-se de um produto fisico ou digital
         */

        Produto produtoFisico =  ProdutoFactory.getInstance(TipoProdutoEnum.FISICO);
        Produto produtoDigital =  ProdutoFactory.getInstance(TipoProdutoEnum.DIGITAL);

        /**
         * Singleton
         * Metodo criacional para garantir que exista apenas uma instancia de um objeto.
         * no exemplo, temos uma agenda e queremos marcar dias como ocupados, sem o padrao Singleton, a cada chamada de agenda
         * um novo objeto agenda seria instanciado na memoria, o Singleton retorna a unica instancia já criada e estatica.
         *
         * Método EAGER -> A instancia é criada no momento que a classe é Inicializada
         */


        AgendaSingletonEAGER agendaEager = AgendaSingletonEAGER.getInstance();
        agendaEager.ocupa("Domingo");
        agendaEager.ocupa("Segunda");
        System.out.println(agendaEager);

        /**
         * Método LAZY -> A instancia é criada quando necessario apenas pela primeira vez.
         * Dentro da classe é possivel verificar que a INSTANCE já não é mais estatica, e o metodo getInstance
         * verifica se a instancia já existe, caso contrário, cria-se uma nova. ou seja sera instanciado somente na chamada
         * do metodo getInstance, esse metodo é util para otimizar uso de memoria pois não existiria uma instancia ocupando
         * memoria se nao for necessario (chamada do metodo getInstance). Os contrutores devem ser privados
         *
         */

        AgendaSingletonLAZY agendaLazy = AgendaSingletonLAZY.getInstance();
        agendaLazy.ocupa("Domingo");
        agendaLazy.ocupa("Terca");
        System.out.println(agendaLazy);

        /**
         * Método ENUM -> Utilizado para previnir quebra de construtores e metodos com Reflections
         * a boa pratica da comunidade recomenda usar ENUM em singleton, pois as
         * enumerações são instanciadas uma vez durante a inicialização da JVM e são garantidas como sendo instâncias únicas.
         * A classe agenda, agora é um ENUM com metodos e atributos.
         *
         */

        AgendaSingletonENUM agendaEnum = AgendaSingletonENUM.getInstance();
        agendaLazy.ocupa("Terca");
        agendaLazy.ocupa("Quarta");
        System.out.println(agendaEnum);

    }
}
