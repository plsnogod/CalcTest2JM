package com.company;

public class CalcFormula{

  private String strFormula;
  private TypeOfNumbers typeOfNumbers;

  CalcFormula(String formula, TypeOfNumbers ton){
    strFormula = formula;
    typeOfNumbers = ton;
  }

  public String BeginCalc(){
    int a1 = 0, a2 = 0;
    
    String[] elements = strFormula.split(" ");
    int numberOfFirstElementInArray = 0;
    int numberOfOperatorInArray = 1;
    int numberOfSecondElementInArray = 2;
    
    ValidOperators oper = ValidOperators.GetOperatorBySting(elements[numberOfOperatorInArray]);

    if(typeOfNumbers == TypeOfNumbers.Roman){
      a1 = RomanianNumbers.GetValByStr(elements[numberOfFirstElementInArray]);
      a2 = RomanianNumbers.GetValByStr(elements[numberOfSecondElementInArray]);
      return RomanianNumbers.GetStrByInt(oper.Calculate(a1, a2));
    }
    if(typeOfNumbers == TypeOfNumbers.Arabic){
      a1 = Integer.parseInt(elements[numberOfFirstElementInArray]);
      a2 = Integer.parseInt(elements[numberOfSecondElementInArray]);
      return Integer.toString(oper.Calculate(a1, a2));
    }

    throw new NullPointerException("не опознан тип цифр");
  }
}