package br.com.renan.ex010.model;

import androidx.annotation.NonNull;


/*
* @author: renan santos carvalho
*/
public class ProfessorTitular extends Professor{
    private int anoInstituicao;
    private double salario;

    public ProfessorTitular(String matricula, String nome, int idade, int anoInstituicao, double salario) {
        super(matricula, nome, idade);
        setAnoInstituicao(anoInstituicao);
        setSalario(salario);
    }

    @Override
    public double calcularSalario() {
        return salario + (salario * (0.05 * anoInstituicao));
    }

    public int getAnoInstituicao() {
        return anoInstituicao;
    }

    public void setAnoInstituicao(int anoInstituicao) {
        this.anoInstituicao = anoInstituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @NonNull
    @Override
    public String toString() {
        String sup = super.toString();
        return sup +    "\nAnos:\t " + getAnoInstituicao() +
                        "\nSal. Base:\t " + getSalario() +
                        "\nSalario:\t " + calcularSalario();
    }
}
