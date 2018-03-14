package com.app_tarek.logicdesign.numericalSystem;


import java.util.ArrayList;

public class conversionFromDecimal {
    private long num;
    private String editText;

    ArrayList<Integer>arrayList=new ArrayList<Integer>();
    public conversionFromDecimal(long num, String editText) {
        this.num = num;
        this.editText = editText;
    }

    public String toBinary(){
        String setVal = "";
        while (num > 0) {
            if (num % 2 == 0) {
                arrayList.add(0);
            } else {
                arrayList.add(1);
            }
            num /= 2;

        }
        for (int i = arrayList.size() - 1; i >= 0; i--) {
            setVal += arrayList.get(i);

        }


        return setVal;
    }

    public String toOctal(){
        String setVal = "";
        int r, p;
        double d, x;
        d = num / 8.0;
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
    public String toHex(){

        String setVal ="";

        int r, p;
        double d, x;
        d = num / 16.0;
        r = (int) d;
        x = (d - r) * 16.0;
        p = (int) x;
        arrayList.add(p);
        for (int i = 0; i < editText.length() - 1; i++) {
            d = r;
            d /= 16.0;
            r = (int) d;
            x = (d - r) * 16.0;
            p = (int) x;
            arrayList.add(p);

        }
        for (int i = arrayList.size() - 1; i >= 0; i--) {
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
        return setVal;
    }

}
