package com.company;

public enum RomanianNumbers {
    I(1),
    IV(4),
    V(5),
    IX(9),
    X(10),
    XL(40),
    L(50),
    XC(90),
    C(100),
    CD(400),
    D(500);

    int val;

    RomanianNumbers(int v) {
        val = v;
    }

    public int GetVal() {
        return val;
    }
/*
  public static RomanianNumbers GetName(int val){
    for(RomanianNumbers rn : RomanianNumbers.values())
    {
      if(rn.GetVal()==val){
        return rn;
      }
    }
    throw new NullPointerException("некорректное число");
  }*/

    public static String GetStrByInt(int val) {
        RomanianNumbers rn = FindMaxval(val);
        if (rn.GetVal() == val) {
            return rn.name();
        } else {
            return rn.name() + GetStrByInt(val - rn.GetVal());
        }
    }

    private static RomanianNumbers FindMaxval(int val) {
        RomanianNumbers[] rnvals = RomanianNumbers.values();
        int lenVals = rnvals.length;
        for (int i = lenVals - 1; i >= 0; i--) {
            if (rnvals[i].GetVal() <= val) {
                return rnvals[i];
            }
        }
        throw new NullPointerException("что-то пошло не так при формировании римского числа");
    }

    public static int GetValByStr(String str) {
        int value = 0;
        RomanianNumbers[] rnvals = RomanianNumbers.values();
        int lenVals = rnvals.length;
        int i = lenVals - 1;
        while (i >= 0) {
            if (str.startsWith(rnvals[i].name())) {
                value += rnvals[i].GetVal();
                str = str.substring(rnvals[i].name().length());
            } else {
                i--;
            }
        }
        if (str.isEmpty()) {
            return value;
        } else {
            throw new NullPointerException("Римское число введено некорректно");
        }
    }
}