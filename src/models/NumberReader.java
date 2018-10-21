package models;

import myExceptions.VariableEnterException;
import service.Scanned;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NumberReader implements Scanned {

    private int enteredNumber;
    private int BILLION=9;// Currently the program processes up to 999 999 999
    private int splitedNumber[]=new int[BILLION]; // Array of numerals from enteredNumber
    private int numeralsCount; //Number of digits in the entredNumber
    //Digit order D in the enteredNumber and its position  in the splitedNumber[]
    int D_1=8;
    int D_2=7;
    int D_3=6;
    int D_4=5;
    int D_5=4;
    int D_6=3;
    int D_7=2;
    int D_8=1;
    int D_9=0;

    private String threeNum=new String(); // Repetitive sequence of words in each group of three numerals, i.e.
                                           // hundred, thousand, million
    private String hundredThreeNum=new String("");//sequence of words of Digits D_1, D_2, D_3
    private String thousandThreeNum=new String("");//sequence of words of Digits D_4, D_5, D_6
    private String millionThreeNum=new String("");//sequence of words of Digits D_7, D_8, D_9
    private String numberInWords; // Result to display

    // Numerals in the sequence of three to transform into words:
    int hundreds;
    int tens;
    int unities;

    public NumberReader(){}

    public NumberReader(int enteredNumber) {
        this.enteredNumber = enteredNumber;
        numeralsCount = (int) Math.ceil(Math.log10(enteredNumber + 0.5));
    }

    public void setEnteredNumber(int enteredNumber) {
       this.enteredNumber = enteredNumber;
        numeralsCount = (int) Math.ceil(Math.log10(enteredNumber + 0.5));
        //(int) Math.ceil(Math.log10(enteredNumber + 0.5))  counts numerals in the entered number
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
        map.put(2E6, " миллиона ");
        map.put(5E6, " миллионов ");

        uniqueWords = Collections.unmodifiableMap(map);
    }

    // The method to be invoked
    public String getNumberInWords () {
        if (enteredNumber==0) return "ноль";

        this.fillSplitedNumber();

        this.hundredToWords();

        if (numeralsCount>3) {
            this.thousandToWords();
        }
        if (numeralsCount>6) {
            this.millionToWords();
        }

//        if ( thousandThreeNum.equals("") && thousandThreeNum.equals("") && hundredThreeNum.equals("")) {
//            hundredThreeNum.equals("ноль");
//        }
        numberInWords=millionThreeNum.concat(thousandThreeNum).concat(hundredThreeNum).trim();
        return numberInWords;
    }

    private void fillSplitedNumber() {
        for (int i = BILLION - 1; i >= 0; i--) {
            splitedNumber[i] = enteredNumber % 10;
            enteredNumber /= 10;
        }
    }

    private String repetitiveSequenceToWords(int hundreds, int tens, int unities) {

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
        if (tens!=1 && unities!=0) {
            threeNum = String.join(" ",  threeNum, (uniqueWords.get(unities).toString()));
            if (unities == 4) {
                threeNum =  threeNum.concat("е");
            }
            if (unities > 4) {
                threeNum =  threeNum.concat("ь");
            }
        }
        if (tens == 1) {
            if (unities == 2) {
                return threeNum = String.join(" ", threeNum, (uniqueWords.get(12).toString())).trim();
            }
            if (unities == 0) {
               return threeNum = String.join(" ",  threeNum, (uniqueWords.get(10).toString())).trim();
            }
            threeNum = String.join(" ", threeNum, (uniqueWords.get(unities).toString()).
                    concat(uniqueWords.get(11).toString()));
        }
        return threeNum=threeNum.trim();
    }


    private String hundredToWords() {
        int hundreds = splitedNumber[D_3];
        int tens = splitedNumber[D_2];
        int unities = splitedNumber[D_1];
        if ( hundreds==0 && tens==0 && unities==0) return hundredThreeNum = "";
        this.repetitiveSequenceToWords(hundreds, tens, unities);
        return hundredThreeNum=threeNum;
    }

    private String thousandToWords() {
        int hundreds = splitedNumber[D_6];
        int tens = splitedNumber[D_5];
        int unities = splitedNumber[D_4];
        if ( hundreds==0 && tens==0 && unities==0) return thousandThreeNum = "";
        this.repetitiveSequenceToWords(hundreds, tens, unities);

        StringBuilder tN = new StringBuilder(threeNum);

        if (threeNum.endsWith("один")) {
            tN.replace(threeNum.length()-4, threeNum.length(), (uniqueWords.get(1000).toString()));
            return thousandThreeNum=tN.toString();
        }
        if (threeNum.endsWith("два")) {
            tN.replace(threeNum.length()-3, threeNum.length(), (uniqueWords.get(2000).toString()));
           return thousandThreeNum=tN.toString();
        }
        if (threeNum.endsWith("три") || threeNum.endsWith("четыре")) {
            tN.append(uniqueWords.get(3000).toString());
           return thousandThreeNum=tN.toString();
        }
            tN.append(uniqueWords.get(5000).toString());
           return thousandThreeNum=tN.toString();
    }

    private String millionToWords() {
        int hundreds = splitedNumber[D_9];
        int tens = splitedNumber[D_8];
        int unities = splitedNumber[D_7];
        if ( hundreds==0 && tens==0 && unities==0) return millionThreeNum = "";
        this.repetitiveSequenceToWords(hundreds, tens, unities);

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


