package myExceptions;

public class VariableEnterException extends Exception{

    private int number;
    private String string="";

    public VariableEnterException(String message){
        super(message);
    }


    public VariableEnterException(String message, int number){

        super(message);
        this.number=number;
    }

    public VariableEnterException(String message, String string){

        super(message);
        this.string=string;
    }

    public int getNumber(){return number;}
    public String getString(){return string;}
}
