package test;

import models.Chessboard;
import myExceptions.VariableEnterException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.testng.asserts.SoftAssert;

import static org.junit.jupiter.api.Assertions.*;

class ChessboardTest {

   Chessboard chessboard=new Chessboard();

    @Tag("finalMethod")
    @DisplayName("Board: even X even")
    @ParameterizedTest
    @CsvSource({"2,2","10,10","10,2"})
    void getFirstAndLastCellsOf_EvenXeven_Board(Integer height, Integer width)throws VariableEnterException {
        chessboard.setDimensions(height, width);
        String board[]=chessboard.getChessboard();

        char actOddsFirst=board[0].charAt(0);//'*' star
        char actOddsLast=board[0].charAt(width-1);//' ' space
        char actEvensFirst=board[1].charAt(0);//' ' space
        char actEvensLast=board[1].charAt(width-1);//'*' star
        char expStar='*';
        char expSpace=' ';
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(expStar, actOddsFirst); // this assert failure fails all test
        softAssert.assertEquals(expStar, actEvensLast);
        softAssert.assertEquals(expSpace, actOddsLast);
        softAssert.assertEquals(expSpace, actEvensFirst);
        softAssert.assertAll();

        /**Does not fail with incorrect first expected value and does not show the first assert failure
         *
       assertAll(
                () ->    softAssert.assertEquals(expStar, actOddsFirst),
                () ->   softAssert.assertEquals(expStar, actEvensLast),
                () ->    softAssert.assertEquals(expSpace, actOddsLast),
                () ->    softAssert.assertEquals(expSpace, actEvensFirst)
       );
         */
    }

    @Tag("finalMethod")
    @DisplayName("Board: odd X odd")
    @ParameterizedTest
    @CsvSource({"3,3","9,9","3,9"})
    void getFirstAndLastCellsOf_OddXodd_Board(Integer height, Integer width)throws VariableEnterException {
        chessboard.setDimensions(height, width);
        String board[]=chessboard.getChessboard();

        char actOddsFirst=board[0].charAt(0);//'*' star
        char actOddsLast=board[0].charAt(width-1);//'*' star
        char actEvensFirst=board[1].charAt(0);//' ' space
        char actEvensLast=board[1].charAt(width-1);//' ' space
        char expStar='*';
        char expSpace=' ';
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(expStar, actOddsFirst);
        softAssert.assertEquals(expStar, actOddsLast);
        softAssert.assertEquals(expSpace,actEvensFirst );
        softAssert.assertEquals(expSpace, actEvensLast);
        softAssert.assertAll();
    }

    @DisplayName("Chessboard Dimensions should not be <=1 throws VariableEnterException")
    @Tag("exception")
    @ParameterizedTest
    @CsvSource({"2,-1","2,1","1,-2","1,2"})
        void setChessboardDimensions_throwException(Integer height, Integer width) {
        assertThrows(VariableEnterException.class,
                ()->{
                    chessboard.setDimensions(height, width);
                });
    }

}



