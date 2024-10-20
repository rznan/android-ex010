package br.com.renan.ex010.model;

import androidx.annotation.NonNull;


/*
* @author: renan santos carvalho
*/
public abstract class Professor implements Salario {
    private String matricula;
    private String nome;
    private int idade;

    @Override
    public abstract double calcularSalario();

    protected Professor(String matricula, String nome, int idade) {
        setMatricula(matricula);
        setNome(nome);
        setIdade(idade);
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    protected void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected void setIdade(int idade) {
        this.idade = idade;
    }

    @NonNull
    @Override
    public String toString() {
        return    "Prof° " + getMatricula() +
                "\nMatricula:\t " + getNome() +
                "\nIdade:\t " + getIdade();
    }

}
