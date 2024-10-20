package br.com.renan.ex010.model;

import androidx.annotation.NonNull;


/*
* @author: renan santos carvalho
*/
public class ProfessorHorista extends Professor{
    private int horasAula;
    private double valorHoraAula;

    public ProfessorHorista(String matricula, String nome, int idade, int horasAula, double valorHoraAula) {
        super(matricula, nome, idade);
        setHorasAula(horasAula);
        setValorHoraAula(valorHoraAula);
    }

    @Override
    public double calcularSalario() {
        return horasAula * valorHoraAula;
    }

    public int getHorasAula() {
        return horasAula;
    }

    public void setHorasAula(int horasAula) {
        this.horasAula = horasAula;
    }

    public double getValorHoraAula() {
        return valorHoraAula;
    }

    public void setValorHoraAula(double valorHoraAula) {
        this.valorHoraAula = valorHoraAula;
    }

    @NonNull
    @Override
    public String toString() {
        String sup = super.toString();
        return sup +    "\nHoras:\t " + getHorasAula() +
                        "\nValor hr:\t " + getValorHoraAula() +
                        "\nSalario:\t " + calcularSalario();
    }
}
