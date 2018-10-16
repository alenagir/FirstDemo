package test;

import models.Chessboard;
import myExceptions.VariableEnterException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class ChessboardTest {

   Chessboard chessboard=new Chessboard();


    @Test
    void PositiveGetEvenChessboard()throws VariableEnterException {
        chessboard.setDimensions(2, 2);
        String exp[]={"* "," *"};
        String act[]=chessboard.getChessboard();
        assertArrayEquals(exp, act);
    }

    @Test
    void PositiveGetOddChessboard()throws VariableEnterException {
        chessboard.setDimensions(3, 2);
        String exp[]={"* "," *","* "};
        String act[]=chessboard.getChessboard();
        assertArrayEquals(exp, act);
    }


}



