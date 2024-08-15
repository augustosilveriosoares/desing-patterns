package org.example.builder;

import java.util.Date;

public class PessoaBuilder {

    private String nome;
    private String email;
    private Date dataNascimento;

    public PessoaBuilder nome(String nome) {
        this.nome = nome;
        return this;
    }

    public PessoaBuilder email(String email) {
        this.email = email;
        return this;
    }

    public PessoaBuilder dataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public Pessoa criaPessoa(){
        return null;
    }
}
