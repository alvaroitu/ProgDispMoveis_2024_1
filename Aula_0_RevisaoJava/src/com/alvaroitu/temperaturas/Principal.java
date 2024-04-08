package com.alvaroitu.temperaturas;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Pessoa p1 = new Pessoa();

        p1.setNome("Alvaro");
        p1.setSobreNome("Pereira");

        System.out.println("Nome: " + p1.getNome() + ", Sobrenome: " + p1.getSobreNome());










//        ConversaoTemperaturas conversaoTemperaturas = new ConversaoTemperaturas();
//
//        Scanner scanner = new Scanner(System.in);

//        System.out.println("Entre com a temperatura em Fahrenheit: ");
//        double tempFahrenheitRecebida = scanner.nextDouble();
//        double tempCelsiusCalculada = conversaoTemperaturas.convertoCelsius(tempFahrenheitRecebida);
//        System.out.println("A temperatura em Fahrenheit: " + tempFahrenheitRecebida + " graus, equivale a " + tempCelsiusCalculada + " graus Celsius." );
//
//        System.out.println();
//
//        System.out.println("Entre com a temperatura em Celsius: ");
//        double tempCelsiusRecebida = scanner.nextDouble();
//        double tempFahrenheitCalculada = conversaoTemperaturas.convertoFahrenheit(tempCelsiusRecebida);
//        System.out.println("A temperatura em Celsius: " + tempCelsiusRecebida + " graus, equivale a " + tempFahrenheitCalculada + " graus Fahrenheit." );

//        System.out.println();
//
//        Combustivel combustivel = new Combustivel();
//
//        System.out.println("Qual a autonomia do seu veiculo? ");
//        double autonomia = scanner.nextDouble();
//        System.out.println("Qual a distancia que vai percorrer na viagem? ");
//        double distanciaPercorrida = scanner.nextDouble();
//        double consumoCombustivel = combustivel.consumoCombustivel(distanciaPercorrida, autonomia);
//        System.out.println("Se meu carro tem autonomina de : " + autonomia +
//                " km por litro. Em uma viagem de " + distanciaPercorrida +
//                " km percorridos. Eu vou precisar  de " + consumoCombustivel + " litros de combustível.");

//        System.out.println();
//
//        CorridaTaxi corridaTaxi1 = new CorridaTaxi();
//        CorridaTaxi corridaTaxi2 = new CorridaTaxi(4.5, 7.5, 2.8);

        //NÃO PRECISA FAZER - DAQUI
//        System.out.println("1 " + corridaTaxi1.getValorBandeirada1());
//
//        corridaTaxi1.setValorBandeirada1(3);
//        corridaTaxi1.setValorPorKm(2.8);
//
//        System.out.println("2 " + corridaTaxi1.getValorBandeirada1());
//
//        System.out.println("3 " + corridaTaxi2.getValorBandeirada1());
        // ATÉ AQUI

//        System.out.println("Digite a distancia percorrida pelo taxi: ");
//        double kmRodado = scanner.nextDouble();
//        double valorCorrida1 = corridaTaxi1.corridaBandeira1(kmRodado);
//        double valorCorrida2 = corridaTaxi2.corridaBandeira1(kmRodado);
//
//        System.out.println("Valor da corrida 1 : " + valorCorrida1);
//        System.out.println("Valor da corrida 2 : " + valorCorrida2);
    }
}
