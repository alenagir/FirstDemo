package models;

import myExceptions.VariableEnterException;

public class TicketsPack {
    public static final int MAX_NUMBER = 999999;
    private int minNumber;
    private int maxNumber;

    public TicketsPack(){}

    public int getMinNumber() {
        return minNumber;
    }
    public int getMaxNumber() {
        return maxNumber;
    }


    public void setMinNumber(int minNumber) throws VariableEnterException {
        if (minNumber < 0 || minNumber>MAX_NUMBER) {
            throw new VariableEnterException("The number cannot be negative");
        }
        this.minNumber = minNumber;
    }


    public void setMaxNumber(int maxNumber) throws VariableEnterException {
        if (maxNumber > MAX_NUMBER || maxNumber < 0) {
            throw new VariableEnterException("is the Max ticket number", MAX_NUMBER);
        }
        this.maxNumber = maxNumber;
    }

    @Override
    public String toString() {
        return  "minNumber=" + minNumber + ", maxNumber=" + maxNumber;
    }
}
