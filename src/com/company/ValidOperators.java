package com.company;

public enum ValidOperators {
    Add("+"),
    Sub("-"),
    Mult("*"),
    Div("/");

    String val;

    ValidOperators(String v) {
        val = v;
    }

    public String GetVal() {
        return val;
    }

    public static ValidOperators GetOperatorBySting(String str) {
        for (ValidOperators vop : ValidOperators.values()) {
            if (str.equals(vop.val)) {
                return vop;
            }
        }
        throw new NullPointerException("неожиданный символ оператора");
    }

    public int Calculate(int a1, int a2) {
        if (val.equals("+")) {
            return a1 + a2;
        }
        if (val.equals("-")) {
            return a1 - a2;
        }
        if (val.equals("*")) {
            return a1 * a2;
        }
        if (val.equals("/")) {
            if (a2 == 0) {
                throw new NullPointerException("делить на 0 нельзя!");
            }
            return a1 / a2;
        }
        throw new NullPointerException("неожиданный символ оператора");
    }
}