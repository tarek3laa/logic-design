package com.app_tarek.logicdesign.numericalSystem;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class conversionFromOctal {

    private String editText;
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public conversionFromOctal(String editText) {
        this.editText = editText;
    }

    public String toDecimal() {
        String setVal = "";
        int n = 0, A = 0;
        int a;
        String s = editText;
        for (int i = editText.length() - 1; i >= 0; i--) {

            a = parseInt(String.valueOf(s.charAt(i)));
            n += (int) (pow(8, A) * a);
            A++;
        }
        setVal += n;

        return setVal;
    }

    public String toBinary() {
        String setVal = "";
        String q = toDecimal();
        int n = parseInt(q);

        while (n > 0) {
            if (n % 2 == 0) {
                arrayList.add(0);
            } else {
                arrayList.add(1);
            }
            n /= 2;

        }
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            setVal += arrayList.get(i);

        }
        return setVal;
    }

    public String toHex() {
        String setVal = "";
        String q = toDecimal();
        int n = parseInt(q);

        Boolean b = false;
        int r, p;
        double d, x;
        d = n / 16.0;
        r = (int) d;
        x = (d - r) * 16.0;
        p = (int) x;
        arrayList.add(p);
        for (int i = 1; i < editText.length() - 1; i++) {
            d = r;
            d /= 16.0;
            r = (int) d;
            x = (d - r) * 16.0;
            p = (int) x;
            arrayList.add(p);

        }
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) > 0)
                b = true;
            if (b) {
                if (arrayList.get(i) == 10)
                    setVal += "A";
                else if (arrayList.get(i) == 11)
                    setVal += "B";
                else if (arrayList.get(i) == 12)
                    setVal += "C";
                else if (arrayList.get(i) == 13)
                    setVal += "D";
                else if (arrayList.get(i) == 14)
                    setVal += "E";
                else if (arrayList.get(i) == 15)
                    setVal += "F";
                else
                    setVal += arrayList.get(i);
            }

        }

        return setVal;
    }
}