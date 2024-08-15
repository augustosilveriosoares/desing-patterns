package org.example.builder;

import java.util.Date;

public class Pessoa {

    private String nome;
    private String email;
    private Date dataNascimento;

    private Pessoa(String nome, String email, Date dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    public static class PessoaBuilder {

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

        public Pessoa build() {
            return new Pessoa(nome, email, dataNascimento);
        }
    }
}
