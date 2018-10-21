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
        if(minSquare<0){
            throw new VariableEnterException("Minimal square must be > 0");
        }
        this.minSquare = minSquare;
    }

    public ArrayList getArray(){
        return this.array;
    }

    public ArrayList getSequence()  {
        array.clear(); //To clear arrayList after previous user cycle
        double first = 0;//First numeral in the sequence.

        first = Math.sqrt(minSquare);
        if (first%1!=0){
            first = Math.ceil(first);//Rounds up to the nearest bigger number
        }

        for(int i=(int) first, j=0; i<first+sequencelength; i++, j++) {
            array.add(j,i);
        }
        return array;
    }

    public void print(){
        for (Integer numeral:array ) {
            System.out.print(" "+numeral.toString());
        }
    }


}
