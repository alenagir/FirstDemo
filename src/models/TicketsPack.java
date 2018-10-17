package models;

import myExceptions.VariableEnterException;

public class TicketsPack {
    private static final int MAX_NUMBER = 999999;
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
        if (minNumber < 0) {
            throw new VariableEnterException("The number cannot be negative");
        }
        this.minNumber = minNumber;
    }


    public void setMaxNumber(int maxNumber) throws VariableEnterException {
        if (maxNumber > MAX_NUMBER) {
            throw new VariableEnterException("Max value has more then 6 numerals");
        }
        this.maxNumber = maxNumber;
    }

    @Override
    public String toString() {
        return  "minNumber=" + minNumber + ", maxNumber=" + maxNumber;
    }
}
