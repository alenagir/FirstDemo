import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NumberReader {

    private String enteredNumber = new String();
    private Integer splitedNumber[];
    private String threeNum=new String();
    private String lastThreeNum;
    private String middleThreeNum=new String(" ");
    private String firstThreeNum=new String(" ");
    private String numberInWords;


    public NumberReader(String enteredNumber) {
        this.enteredNumber = enteredNumber;
        splitedNumber = new Integer[enteredNumber.length()+2];
    }

    private static final Map uniqueWords;
    static {
        Map map = new HashMap();
        map.put(0, " ");
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
        map.put(1000, "одна тысяча");
        map.put(2000, "две тысячи");
        map.put(3000, " тысячи");
        map.put(5000, " тысяч");
        map.put(1E6, " миллион");
        map.put(2E6, " миллионa");
        map.put(5E6, " миллионов");

        uniqueWords = Collections.unmodifiableMap(map);
    }

    public String getNumberInWords () {
        this.fillSplitedNumber();
        this.lastToWords();
        if (enteredNumber.length()>3)   this.middleToWords();
        if (enteredNumber.length()>6)   this.firstToWords();

        numberInWords=firstThreeNum.concat(" ").concat(middleThreeNum).concat(" ").concat(lastThreeNum).trim();
        return numberInWords;
    }

    private void fillSplitedNumber() {
        int in = Integer.parseInt(enteredNumber);
        for (int i = (enteredNumber.length() + 2) - 1; i >= 0; i--) {
            splitedNumber[i] = in % 10;
            in /= 10;
        }
    }

    private void toWords(int h, int t, int u) {

        if ( h < 5) {
            threeNum = (uniqueWords.get(h * 100).toString());
        }
        if (h >= 5) {
            threeNum = (uniqueWords.get(h).toString()).concat("ь").concat(uniqueWords.get(500).toString());
        }
        if (t == 2 || t == 3) {
            threeNum = String.join(" ",  threeNum,
                    (uniqueWords.get(t).toString()).concat(uniqueWords.get(20).toString()));
        }
        if (t == 4 || t == 9) {
            threeNum = String.join(" ",  threeNum, uniqueWords.get(t * 10).toString());
        }
        if (t>4 && t<9){
            threeNum = String.join(" ",  threeNum,
                    (uniqueWords.get(t).toString()).concat(uniqueWords.get(50).toString()));
        }
        if ((t==0 || t>1) && u!=0) {
            threeNum = String.join(" ",  threeNum, (uniqueWords.get(u).toString()));
            if (u == 4) {
                threeNum =  threeNum.concat("e");
            }
            if (u > 4) {
                threeNum =  threeNum.concat("ь");
            }
        }
        if (t == 1) {
            if (u != 0 && u != 2) {
                threeNum = String.join(" ", threeNum, (uniqueWords.get(u).toString()).concat(uniqueWords.get(11).toString()));
            }
            if (u == 2) {
                threeNum = String.join(" ", threeNum, (uniqueWords.get(12).toString()));
            }
            if (u == 0) {
                threeNum = String.join(" ",  threeNum, (uniqueWords.get(10).toString()));
            }
        }
    }


    private String lastToWords() {
        int h = splitedNumber[(enteredNumber.length()+2) - 3];
        int t = splitedNumber[(enteredNumber.length()+2) - 2];
        int u = splitedNumber[(enteredNumber.length()+2) - 1];
        if ( h==0 && t==0 && u==0) return lastThreeNum = "ноль";
        else this.toWords(h, t, u);
        return lastThreeNum=threeNum.trim();
    }

    private String middleToWords() {
        int h = splitedNumber[(enteredNumber.length()+2) - 6];
        int t = splitedNumber[(enteredNumber.length()+2) - 5];
        int u = splitedNumber[(enteredNumber.length()+2) - 4];
        this.toWords(h, t, u);
        StringBuilder tN = new StringBuilder(threeNum);
        if ( h==0 && t==0 && u==0) return middleThreeNum = "";
        if (threeNum.endsWith("один")) {
            tN.replace(threeNum.length()-4, threeNum.length(), (uniqueWords.get(1000).toString()));
            return middleThreeNum=tN.toString().trim();
        }
        if (threeNum.endsWith("два")) {
            tN.replace(threeNum.length()-3, threeNum.length(), (uniqueWords.get(2000).toString()));
           return middleThreeNum=tN.toString().trim();
        }
        if (threeNum.endsWith("три") || threeNum.endsWith("четыре") ) {
            tN.append(uniqueWords.get(3000).toString());
           return middleThreeNum=tN.toString().trim();
        }
            tN.append(uniqueWords.get(5000).toString());
           return middleThreeNum=tN.toString().trim();
    }

    private String firstToWords() {
        int h = splitedNumber[(enteredNumber.length()+2) - 9];
        int t = splitedNumber[(enteredNumber.length()+2) - 8];
        int u = splitedNumber[(enteredNumber.length()+2) - 7];
        this.toWords(h, t, u);
        StringBuilder tN = new StringBuilder(threeNum);
        if (threeNum.endsWith("один")) {
            tN.append(uniqueWords.get(1E6).toString());
            return firstThreeNum=tN.toString().trim();
        }
        if (threeNum.endsWith("два") || threeNum.endsWith("три") || threeNum.endsWith("четыре")) {
            tN.append(uniqueWords.get(2E6).toString());
            return firstThreeNum=tN.toString().trim();
        }
       tN.append(uniqueWords.get(5E6).toString());
        return firstThreeNum=tN.toString().trim();
    }


}


