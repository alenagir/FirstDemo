package models;

import service.Scanned;

import java.util.ArrayList;

public class Sequence {
    private int sequencelength;
    private int minSquare;
    private ArrayList<Integer> array;

    public Sequence (){
        array=new ArrayList<>();
    }

    public ArrayList getSequence(){
        try {
            System.out.println("Enter a sequence length: ");
            sequencelength = Scanned.scanToInteger();
            System.out.println("Enter a minimal square: ");
            minSquare = Scanned.scanToInteger();
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
        double first = 0;//First numeral in the sequence.
        first = Math.sqrt(minSquare);
        while (first%1!=0){
            minSquare=minSquare+1;
            first = Math.sqrt(minSquare);
        };

        for(int i=(int) first; i<first+sequencelength; i++)
            array.add(i);
        return array;
    }

    public void print(){
        for (Integer numeral:array ) {
            System.out.println(numeral.toString());
        }
    }



}
