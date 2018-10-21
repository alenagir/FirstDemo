package test;

import models.NumberReader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberReaderTest {

    NumberReader numberReader=new NumberReader();

    @DisplayName("Tests all 'if' in the base method repetitiveSequenceToWords ")
    @ParameterizedTest
    @CsvSource({"сто, 100",
            "пятьсот, 500",
            "двести двадцать, 220",
            "шестьсот тридцать, 630",
            "триста сорок, 340",
            "семьсот девяносто, 790",
            "четыреста пятьдесят, 450",
            "двести двадцать один, 221",
            "шестьсот тридцать один, 631",
            "триста сорок пять, 345",
            "пятьсот двенадцать, 512",
            "сто десять, 110",
            "сто одиннадцать, 111"})

    void getNumberInWordsBase(String expected, Integer ints) {
        numberReader.setEnteredNumber(ints);
        String actual=numberReader.getNumberInWords();
        assertEquals(expected, actual);
    }

    @DisplayName("Tests all 'if' in the method thousandToWords and millionToWords")
    @ParameterizedTest
    @CsvSource({"одна тысяча, 1000",
            "две тысячи, 2000",
            "три тысячи, 3000",
            "четыре тысячи, 4000",
            "пять тысяч, 5000",
            "один миллион, 1000000",
            "два миллиона, 2000000",
            "три миллиона, 3000000",
            "пять миллионов, 5000000"})

    void getNumberInWordsThousands(String expected, Integer ints) {
        numberReader.setEnteredNumber(ints);
        String actual=numberReader.getNumberInWords();
        assertEquals(expected, actual);
    }

    @DisplayName("Tests all cases of million, thousand and hundred concatenation")
    @ParameterizedTest
    @CsvSource({"ноль, 0",
            "сто двадцать три миллиона четыреста пятьдесят шесть тысяч семьсот восемьдесят девять, 123456789",
            "сто двадцать три миллиона четыреста пятьдесят шесть тысяч, 123456000",
            "сто двадцать три миллиона семьсот восемьдесят девять, 123000789",
            "сто двадцать три миллиона четыреста тысяч семьсот восемьдесят девять, 123400789",
            "сто двадцать три миллиона шесть тысяч семьсот восемьдесят девять, 123006789",
            "сто миллионов девять, 100000009",
            "девятьсот девяносто девять миллионов девятьсот девяносто девять тысяч девятьсот девяносто девять, 999999999"})

    void getNumberInWords(String expected, Integer ints) {
        numberReader.setEnteredNumber(ints);
        String actual=numberReader.getNumberInWords();
        assertEquals(expected, actual);
    }


}