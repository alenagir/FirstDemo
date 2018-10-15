package models;

import service.Scanned;

import java.io.*;
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

    public void stringOverWrite (String stringToFind, String stringToOverWrite) throws IOException{
        if (stringToOverWrite==null){
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


    public  void enterStrings (){
        System.out.println("Enter the substring to be counted: ");
        this.stringToFind=Scanned.scanToString();
        System.out.println("Enter the substring to overwrite: ");
        this.stringToOverWrite=Scanned.scanToString();
    }

    public static String getFilePATH() {
        return filePATH;
    }

    public String getStringToFind() {
        return stringToFind;
    }

    public String getStringToOverWrite() {
        return stringToOverWrite;
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

