package com.alvaroitu.temperaturas;

public class ConversaoTemperaturas {

    public double convertoCelsius( double fahrenheit){
        return (fahrenheit - 32) / 1.8;
    }

    public double convertoFahrenheit( double celsius){
        return (celsius * 1.8) + 32;
    }
}