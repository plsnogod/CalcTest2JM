package com.company;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("������� ������ � ������� a % b;\n" +
                "��� a � b - ����� �� 1 �� 10 (I - X), � % - ���� �������������� ��������.\n" +
                "������� �����������.");
        String strCalc;
        Scanner in = new Scanner(System.in);
        do {
            strCalc = in.nextLine().trim().replaceAll("[\\s]{2,}", " ");

            CheckStr cs = new CheckStr(strCalc);
            try {
                if (cs.IsStrValid()) {
                    CalcFormula calc = new CalcFormula(strCalc, cs.GetTypeOfNumbers());

                    System.out.println("�����: " + calc.BeginCalc());
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        while (!strCalc.isEmpty());
    }
}