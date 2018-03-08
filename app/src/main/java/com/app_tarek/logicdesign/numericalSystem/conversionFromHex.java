package com.app_tarek.logicdesign.numericalSystem;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class conversionFromHex {
    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    private String editText;

    public conversionFromHex(String editText) {
        this.editText = editText;
    }

    public String toDecimal() {
        int n = 0, A = 0;
        int a;
        String s = editText;
        String setVal = "";

        for (int i = editText.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'a')
                a = 10;
            else if (s.charAt(i) == 'B' || s.charAt(i) == 'b')
                a = 11;
            else if (s.charAt(i) == 'C' || s.charAt(i) == 'c')
                a = 12;
            else if (s.charAt(i) == 'D' || s.charAt(i) == 'd')
                a = 13;
            else if (s.charAt(i) == 'E' || s.charAt(i) == 'e')
                a = 14;
            else if (s.charAt(i) == 'F' || s.charAt(i) == 'f')
                a = 15;
            else
                a = parseInt(String.valueOf(s.charAt(i)));
            n += (int) (pow(16, A) * a);
            A++;
        }
        setVal += n;

        return setVal;
    }

    public String toBinary() {

        String q = toDecimal();
        int n = parseInt(q);
        String setVal = "";

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

    public String toOctal() {
        String q = toDecimal();
        int n = parseInt(q);
        String setVal = "";

        int r, p;
        double d, x;
        d = n / 8.0;
        r = (int) d;
        x = (d - r) * 8.0;
        p = (int) x;
        arrayList.add(p);
        for (int i = 1; i < editText.length(); i++) {
            d = r;
            d /= 8.0;
            r = (int) d;
            x = (d - r) * 8.0;
            p = (int) x;
            arrayList.add(p);


        }
        for (int i = arrayList.size() - 1; i >= 0; i--)
            setVal += arrayList.get(i);

        return setVal;
    }


}
