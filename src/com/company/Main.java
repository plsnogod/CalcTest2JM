package com.company;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("Введите строку в формате a % b;\n" +
                "где a и b - числа от 1 до 10 (I - X), а % - знак математической операции.\n" +
                "Пробелы обязательны.");
        String strCalc;
        Scanner in = new Scanner(System.in);
        do {
            strCalc = in.nextLine().trim().replaceAll("[\\s]{2,}", " ");

            CheckStr cs = new CheckStr(strCalc);
            try {
                if (cs.IsStrValid()) {
                    CalcFormula calc = new CalcFormula(strCalc, cs.GetTypeOfNumbers());

                    System.out.println("Ответ: " + calc.BeginCalc());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        while (!strCalc.isEmpty());
    }
}