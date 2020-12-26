package com.company;


public class CheckStr {
    private String strFormula;
    private TypeOfNumbers typeOfNumbers;

    CheckStr(String str) {
        strFormula = str;
    }

    public TypeOfNumbers GetTypeOfNumbers() {
        if (typeOfNumbers == null) {
            throw new NullPointerException("тип цифр ещё не определён");
        } else {
            return typeOfNumbers;
        }
    }

    public boolean IsStrValid() {
        String[] elements = strFormula.split(" ");
        if (!CheckCountOfElements(elements)) {
            throw new NullPointerException("некорректная формула: неожиданное количество элементов");
        }
        int numberOfOperatorInArray = 1;
        if (!CheckOperator(elements[numberOfOperatorInArray])) {
            throw new NullPointerException("некорректная формула: некорректный оператор");
        }
        int numberOfFirstElementInArray = 0;
        int numberOfSecondElementInArray = 2;
        typeOfNumbers = CheckElements(elements[numberOfFirstElementInArray], elements[numberOfSecondElementInArray]);

        return true;
    }

    private boolean ContainsRomanianNumbers(String str) {
        return str.matches(".*[IVXLCDM].*");
    }

    private boolean ContainsLitersNotValidSymbols(String str) {
        return str.matches(".*[^IVXLCDM\\d\\s].*");
    }

    private boolean ContainsArabicNumbers(String str) {
        return str.matches(".*\\d.*");
    }

    ///этот метод можно будет выкинуть при усложнении формул
    private boolean CheckCountOfElements(String[] elements) {
        int validCountOfElements = 3; //2 elements + 1 operator
        return elements.length == validCountOfElements;
    }

    private boolean CheckOperator(String operator) {
        for (ValidOperators validOperator : ValidOperators.values()) {
            if (operator.equals(validOperator.GetVal())) {
                return true;
            }
        }
        return false;
    }

    public TypeOfNumbers CheckTypeOfNumbers(String str) {
        if (ContainsLitersNotValidSymbols(str)) {
            throw new NullPointerException("некорректная формула: элемент содержит неожиданные символы");
        }
        if (ContainsRomanianNumbers(str)) {
            if (ContainsArabicNumbers(str)) {
                throw new NullPointerException("некорректная формула: эелемент содержит одновременно арабские и римские цифры");
            } else {
                return TypeOfNumbers.Roman;
            }
        }
        if (ContainsArabicNumbers(str)) {
            return TypeOfNumbers.Arabic;
        } else {
            throw new NullPointerException("некорректная формула: эелемент не содержит ни арабские ни римские цифры");
        }
    }

    private TypeOfNumbers CheckElements(String a1, String a2) {
        TypeOfNumbers t1 = CheckElementValue(a1);
        TypeOfNumbers t2 = CheckElementValue(a2);
        if (t1 == t2) {
            return t1;
        } else {
            throw new NullPointerException("некорректная формула: введены элементы разных типов");
        }
    }

    private TypeOfNumbers CheckElementValue(String element) {
        TypeOfNumbers ton = CheckTypeOfNumbers(element);
        if (ton == TypeOfNumbers.Roman) {
            if (RomanianNumbers.GetValByStr(element) > 10) {
                throw new NullPointerException("слишком большое число");
            }
        }
        if (ton == TypeOfNumbers.Arabic) {
            if (Integer.parseInt(element) > 10) {
                throw new NullPointerException("слишком большое число");
            }
        }

        return ton;
    }

    private TypeOfNumbers CheckElements(String[] elements) {
        int elementsCount = elements.length;
        if (elementsCount < 1) {
            throw new NullPointerException("некорректная формула: мало элементов");
        }
        int firstElNumber = 0;
        TypeOfNumbers typeFirst = CheckTypeOfNumbers(elements[firstElNumber]);
        int secondElNumber = 1;
        for (int i = secondElNumber; i < elementsCount; i++) {
            TypeOfNumbers typeCurrent = CheckTypeOfNumbers(elements[i]);
            if (typeFirst != typeCurrent) {
                throw new NullPointerException("некорректная формула: введены элементы разных типов");
            }
        }
        return typeFirst;
    }
}