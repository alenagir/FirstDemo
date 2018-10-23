package test;

import models.FileParser;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileParserTest {
    static FileParser fileParser;

    @BeforeAll
    static void openFile() throws IOException {
        fileParser = new FileParser("D://JavaTasks//First_Demo//FileSource//text.txt");
    }
    @AfterAll
    static void closeFile() throws IOException {
        fileParser.stringOverWrite("book","cook");
        fileParser.close();
    }


    @DisplayName("Tests stringCount('cook').Count 'cook' returns 12.")
    @Test
    void stringCount_cook() throws IOException {
         Integer actualCount_cook=fileParser.stringCounter("cook");
         Integer expectedCount_cook=12;
         assertEquals(expectedCount_cook,actualCount_cook);
    }


    @DisplayName("Tests stringCount('cook'). Count 'book' returns 0")
    @Test
    void stringCount_book() throws IOException {
        Integer actualCount_book=fileParser.stringCounter("book");
        Integer expectedCount_book=0;
        assertEquals(expectedCount_book,actualCount_book);
    }

    @DisplayName("Tests stringOverWrite('cook','book').Count 'cook' returns 0. Count 'book' returns 12")
    @Test
    void stringOverWrite_cook_on_book() throws IOException {
        fileParser.stringOverWrite("cook","book");

        fileParser.close();
        fileParser = new FileParser("D://JavaTasks//First_Demo//FileSource//text.txt");

        Integer actualCount_book=fileParser.stringCounter("book");

        Integer expectedCount_book=12;
        assertEquals(expectedCount_book,actualCount_book);
    }

}