package com.app_tarek.logicdesign.numericalSystem;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class conversionFromBinary {
    private String editText;

    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    public conversionFromBinary(String editText) {
        this.editText = editText;
    }

    public String toDecimal() {

        String setVal = "";

        int n = 0, A = 0;
        String s = editText;

        for (int i = editText.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0')
                n += (int) (pow(2, A) * 0);
            else if (s.charAt(i) == '1')
                n += (int) (pow(2, A) * 1);
            A++;
        }
        setVal += n;

        return setVal;
    }

    public String toOctal() {
        String setVal = "";
        String q = toDecimal();
        int n = parseInt(q);
        Boolean b = false;
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
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            if (arrayList.get(i) > 0)
                b = true;
            if (b)
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

