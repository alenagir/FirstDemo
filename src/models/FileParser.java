package models;

import service.Scanned;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser implements AutoCloseable{
    private static String filePATH;
    private String stringToFind;
    private int stringCount;
    private String stringToOverWrite;
    public BufferedReader fileRead;
    public BufferedWriter fileWrite;

    public FileParser(){}

    public FileParser( String filePATH) throws IOException{
        fileRead = new BufferedReader(new FileReader(this.filePATH = filePATH));
    }

    public  void setParameters (String stringToFind, String stringToOverWrite){
        this.stringToFind=stringToFind;
        this.stringToOverWrite=stringToOverWrite;
    }

    public String getStringToFind() {
        return stringToFind;
    }

    public String getStringToOverWrite() {
        return stringToOverWrite;
    }

    //Method invoked from Main to count the same strings
    public int stringCounter (String stringToFind) throws IOException{
        if (stringToFind.equals("")){
            return stringCount=-1;
        }
        Pattern pattern = Pattern.compile(stringToFind);
        Matcher matcher;
        String line;
        fileRead.mark(2000000);
        while ((line=fileRead.readLine())!= null){
            matcher = pattern.matcher(line.toLowerCase());
            int c=0;
            while(matcher.find()) {
                c++;
            }
            stringCount=stringCount+c;
        }
        fileRead.reset();
        return stringCount;
    }

    //Method invoked from Main to overwrite stringToFind with stringToOverWrite
    public void stringOverWrite (String stringToFind, String stringToOverWrite) throws IOException{
        if (stringToOverWrite==null || stringToOverWrite==""){
            return;
        }
        StringBuilder text = new StringBuilder();
        String line;
        while ((line=fileRead.readLine())!= null){
            text.append(line.replace(stringToFind, stringToOverWrite)).append("\r\n");
        }
            fileWrite = new BufferedWriter(new FileWriter(filePATH));

            fileWrite.write(text.toString());
            fileWrite.flush();
    }



    @Override
    public void close() throws IOException {
            try{
                if(fileRead !=null)
                    fileRead.close();
            }catch (IOException ex){
            System.out.println(ex.getMessage());
            }
            finally{
                fileRead.close();
            }
    }

}

