package org.example;

public class Main {
    public static void main(String[] args) {
        org.example.Calculator calc = org.example.Calculator.instance.get();
        int a = calc.plus.apply(1, 3);
        int b = calc.minus.apply(4, 2);
        int c = calc.devide.apply(a, b);// ошибка деления на 0
        calc.println.accept(c);
    }
}