package com.alvaroitu.temperaturas;

public class Pessoa {

    private String nome;
    public String sobreNome;

    public Pessoa(){

    }

    public Pessoa(String nome, String sobreNome) {
        this.nome = nome;
        this.sobreNome = sobreNome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }
}
