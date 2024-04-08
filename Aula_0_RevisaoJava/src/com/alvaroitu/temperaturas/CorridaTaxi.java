package com.alvaroitu.temperaturas;

public class CorridaTaxi {

    private double valorBandeirada1;
    private double valorBandeirada2;
    private double valorPorKm;

    public CorridaTaxi() {
    }

    public CorridaTaxi(double valorBandeirada1, double valorBandeirada2, double valorPorKm) {
        this.valorBandeirada1 = valorBandeirada1;
        this.valorBandeirada2 = valorBandeirada2;
        this.valorPorKm = valorPorKm;
    }

    public double getValorBandeirada1() {
        return valorBandeirada1;
    }

    public void setValorBandeirada1(double valorBandeirada1) {
        this.valorBandeirada1 = valorBandeirada1;
    }

    public double getValorBandeirada2() {
        return valorBandeirada2;
    }

    public void setValorBandeirada2(double valorBandeirada2) {
        this.valorBandeirada2 = valorBandeirada2;
    }

    public double getValorPorKm() {
        return valorPorKm;
    }

    public void setValorPorKm(double valorPorKm) {
        this.valorPorKm = valorPorKm;
    }

    public double corridaBandeira1(double kmRodado){

        return this.valorBandeirada1 + this.valorPorKm * kmRodado;

    }

    public double corridaBandeira2(double kmRodado){

        return this.valorBandeirada2 + this.valorPorKm * kmRodado;

    }
}
