package models;

import service.Scanned;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NumberReader implements Scanned {

    private Integer enteredNumber;
    private Integer splitedNumber[]; // Array of numerals from enteredNumber
    private int numeralsCount;
    private String threeNum=new String(); // Repetitive sequence of words in each group of three numerals, i.e.
                                           // hundred, thousand, million
    private String hundredThreeNum;
    private String thousandThreeNum=new String("");
    private String millionThreeNum=new String("");
    private String numberInWords; // Result to display
    // To avoid NullPointerException in case the user entered less than three needed numerals:
    int TWO_MORE=2;
    // Numerals in the sequence to transform into words:
    int hundreds;
    int tens;
    int unities;



    public NumberReader() {
        System.out.print("Enter a number from 0 to 999 999 999: ");
        this.enteredNumber = Scanned.scanToInteger();
        //(int) Math.ceil(Math.log10(enteredNumber + 0.5))  counts numerals in the entered number
        numeralsCount = (int) Math.ceil(Math.log10(enteredNumber + 0.5));
        splitedNumber = new Integer[numeralsCount + TWO_MORE];
    }

    private static final Map uniqueWords;
    static {
        Map map = new HashMap();
        map.put(0, "");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыр");
        map.put(5, "пят");
        map.put(6, "шест");
        map.put(7, "сем");
        map.put(8, "восем");
        map.put(9, "девят");
        map.put(10, "десять");
        map.put(11, "надцать");
        map.put(12, "двенадцать");
        map.put(20, "дцать");
        map.put(40, "сорок");
        map.put(50, "ьдесят");
        map.put(90, "девяносто");
        map.put(100, "сто");
        map.put(200, "двести");
        map.put(300, "триста");
        map.put(400, "четыреста");
        map.put(500, "сот");
        map.put(1000, "одна тысяча ");
        map.put(2000, "две тысячи ");
        map.put(3000, " тысячи ");
        map.put(5000, " тысяч ");
        map.put(1E6, " миллион ");
        map.put(2E6, " миллионa ");
        map.put(5E6, " миллионов ");

        uniqueWords = Collections.unmodifiableMap(map);
    }

    public String getNumberInWords () {
        this.fillSplitedNumber();
        this.hundredToWords();
        if (numeralsCount>3) {
            this.thousandToWords();
        }
        if (numeralsCount>6) {
            this.millionToWords();
        }
        if (numeralsCount>3 && thousandThreeNum != "" && hundredThreeNum.equals("ноль")) {
            hundredThreeNum="";
        }
        numberInWords=millionThreeNum.concat(thousandThreeNum).concat(hundredThreeNum).trim();
        return numberInWords;
    }

    private void fillSplitedNumber() {
        for (int i = (numeralsCount + TWO_MORE) - 1; i >= 0; i--) {
            splitedNumber[i] = enteredNumber % 10;
            enteredNumber /= 10;
        }
    }

    private void toWords(int hundreds, int tens, int unities) {

        if ( hundreds < 5) {
            threeNum = (uniqueWords.get(hundreds * 100).toString());
        }
        if (hundreds >= 5) {
            threeNum = (uniqueWords.get(hundreds).toString()).concat("ь").concat(uniqueWords.get(500).toString());
        }
        if (tens == 2 || tens == 3) {
            threeNum = String.join(" ",  threeNum,
                    (uniqueWords.get(tens).toString()).concat(uniqueWords.get(20).toString()));
        }
        if (tens == 4 || tens == 9) {
            threeNum = String.join(" ",  threeNum, uniqueWords.get(tens * 10).toString());
        }
        if (tens>4 && tens<9){
            threeNum = String.join(" ",  threeNum,
                    (uniqueWords.get(tens).toString()).concat(uniqueWords.get(50).toString()));
        }
        if ((tens==0 || tens>1) && unities!=0) {
            threeNum = String.join(" ",  threeNum, (uniqueWords.get(unities).toString()));
            if (unities == 4) {
                threeNum =  threeNum.concat("e");
            }
            if (unities > 4) {
                threeNum =  threeNum.concat("ь");
            }
        }
        if (tens == 1) {
            if (unities != 0 && unities != 2) {
                threeNum = String.join(" ", threeNum, (uniqueWords.get(unities).toString()).
                        concat(uniqueWords.get(11).toString()));
            }
            if (unities == 2) {
                threeNum = String.join(" ", threeNum, (uniqueWords.get(12).toString()));
            }
            if (unities == 0) {
                threeNum = String.join(" ",  threeNum, (uniqueWords.get(10).toString()));
            }
        }
    }


    private String hundredToWords() {
        int hundreds = splitedNumber[(numeralsCount+TWO_MORE) - 3];
        int tens = splitedNumber[(numeralsCount+TWO_MORE) - 2];
        int unities = splitedNumber[(numeralsCount+TWO_MORE) - 1];
        if ( hundreds==0 && tens==0 && unities==0) return hundredThreeNum = "ноль";
        this.toWords(hundreds, tens, unities);
        return hundredThreeNum=threeNum.trim();
    }

    private String thousandToWords() {
        int hundreds = splitedNumber[(numeralsCount+TWO_MORE) - 6];
        int tens = splitedNumber[(numeralsCount+TWO_MORE) - 5];
        int unities = splitedNumber[(numeralsCount+TWO_MORE) - 4];
        this.toWords(hundreds, tens, unities);
        StringBuilder tN = new StringBuilder(threeNum);
        if ( hundreds==0 && tens==0 && unities==0) return thousandThreeNum = "";
        if (threeNum.endsWith("один")) {
            tN.replace(threeNum.length()-4, threeNum.length(), (uniqueWords.get(1000).toString()));
            return thousandThreeNum=tN.toString();
        }
        if (threeNum.endsWith("два")) {
            tN.replace(threeNum.length()-3, threeNum.length(), (uniqueWords.get(2000).toString()));
           return thousandThreeNum=tN.toString();
        }
        if (threeNum.endsWith("три") || threeNum.endsWith("четыре") ) {
            tN.append(uniqueWords.get(3000).toString());
           return thousandThreeNum=tN.toString();
        }
            tN.append(uniqueWords.get(5000).toString());
           return thousandThreeNum=tN.toString();
    }

    private String millionToWords() {
        int hundreds = splitedNumber[(numeralsCount+2) - 9];
        int tens = splitedNumber[(numeralsCount+2) - 8];
        int unities = splitedNumber[(numeralsCount+2) - 7];
        this.toWords(hundreds, tens, unities);
        StringBuilder tN = new StringBuilder(threeNum);
        if (threeNum.endsWith("один")) {
            tN.append(uniqueWords.get(1E6).toString());
            return millionThreeNum=tN.toString();
        }
        if (threeNum.endsWith("два") || threeNum.endsWith("три") || threeNum.endsWith("четыре")) {
            tN.append(uniqueWords.get(2E6).toString());
            return millionThreeNum=tN.toString();
        }
       tN.append(uniqueWords.get(5E6).toString());
        return millionThreeNum=tN.toString();
    }


}


