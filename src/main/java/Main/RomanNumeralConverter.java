package Main;

import java.util.*;

public class RomanNumeralConverter {
    private HashMap<String, Integer> numeralIntMap = new HashMap<String, Integer>();
    private HashMap<Integer, String> intNumeralMap = new HashMap<Integer, String>();
    private String roman;
    private Integer arabic;
    private boolean isRomanToArabic = false;

    RomanNumeralConverter(String roman) {
        try {
            Double.parseDouble(roman);
            this.arabic = Integer.parseInt(roman);
            this.isRomanToArabic = false;
        } catch(NumberFormatException e) {
            this.roman = roman.toUpperCase();
            this.isRomanToArabic = true;
        }
        makeMap();
    }

    private void makeMap() {
        numeralIntMap.put("M", 1000);
        numeralIntMap.put("CM", 900);
        numeralIntMap.put("D", 500);
        numeralIntMap.put("CD", 400);
        numeralIntMap.put("C", 100);
        numeralIntMap.put("XC", 90);
        numeralIntMap.put("L", 50);
        numeralIntMap.put("XL", 40);
        numeralIntMap.put("X", 10);
        numeralIntMap.put("IX", 9);
        numeralIntMap.put("V", 5);
        numeralIntMap.put("IV", 4);
        numeralIntMap.put("I", 1);

        intNumeralMap.put(1, "I");
        intNumeralMap.put(4, "IV");
        intNumeralMap.put(5, "V");
        intNumeralMap.put(9, "IX");
        intNumeralMap.put(10, "X");
        intNumeralMap.put(40, "XL");
        intNumeralMap.put(50, "L");
        intNumeralMap.put(90, "XC");
        intNumeralMap.put(100, "C");
        intNumeralMap.put(400, "CD");
        intNumeralMap.put(500, "D");
        intNumeralMap.put(900, "CM");
        intNumeralMap.put(1000, "M");
    }

    ;

    public String toRoman(int n) {
        String result = "";
        int currentValue = 1000;
        int[] valueArray = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int valueIndex = 0;
        while (n > 0) {
            if (n >= currentValue) {
                result += intNumeralMap.get(currentValue);
                n -= currentValue;
            } else {
                valueIndex++;
                currentValue = valueArray[valueIndex];
            }
        }
        return result;
    }

    public String toRoman(){return toRoman(this.arabic);}

    public int fromRoman(String romanStr) {
        String roman = romanStr.toUpperCase();
        if (roman.length() == 0) {
            return 0;
        }

        if (roman.length() == 1) {
            return numeralIntMap.get(roman);
        }
        String[] letters = roman.split("");
        int total = 0;
        String last = letters[0];
        total += numeralIntMap.get(last);

        for (int i = 1; i < letters.length; i++) {
            if (compareRoman(last, letters[i]) || last.equals(letters[i])) {
                total += numeralIntMap.get(letters[i]);
            } else {
                total -= numeralIntMap.get(last);
                total += numeralIntMap.get((last + letters[i]));
            }
            last = letters[i];
        }
        return total;
    }

    public int fromRoman() {
        return fromRoman(this.roman);
    }

    private boolean compareRoman(String a, String b) {
        //Compares if a greater than b
        if (!numeralIntMap.containsKey(a) || !numeralIntMap.containsKey(b)) {
            return false;
        }
        return numeralIntMap.get(a) > numeralIntMap.get(b);
    }

    public boolean isRomanToArabic() {
        return isRomanToArabic;
    }
}

