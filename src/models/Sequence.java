package models;

import myExceptions.VariableEnterException;

import java.util.ArrayList;

public class Sequence {
    private int sequencelength;
    private int minSquare;
    private ArrayList<Integer> array;

    public Sequence (){
        array=new ArrayList<>();
    }


    public void setSequencelength(int sequencelength) throws VariableEnterException {
        if(sequencelength<1){
            throw new VariableEnterException("Sequence length must be > 1");
        }
        this.sequencelength = sequencelength;
    }

    public void setMinSquare(int minSquare) throws VariableEnterException {
        if(minSquare<1){
            throw new VariableEnterException("Minimal square must be > 1");
        }
        this.minSquare = minSquare;
    }

    public ArrayList getSequence()  {

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
            System.out.print(" "+numeral.toString());
        }
    }


}
