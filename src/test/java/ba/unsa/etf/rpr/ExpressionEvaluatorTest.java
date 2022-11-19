package ba.unsa.etf.rpr;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ExpressionEvaluatorTest {

    @Test
    void testval (){
        double res = ExpressionEvaluator.val("+", 3, 3);
        double expected = 6;

        assertEquals(expected, res);
    }

    @Test
    void testparsedStr(){

        String[] res = ExpressionEvaluator.parsedStr("( 3 + 4 )");
        String[] expected = new String[] {"(", "3", "+", "4", ")"};
        assertArrayEquals(expected, res);
    }

    @Test
    void testevaluate1 (){
        double res = ExpressionEvaluator.evaluate("( ( 15 - 9 ) / 3 )");
        double expected = 2;
        assertEquals(expected, res);

    }

    @Test void testevaluate2 (){
        double res = ExpressionEvaluator.evaluate("( ( 4 + 3 ) * 2 )");
        double expected = 14;
        assertEquals(expected, res);
    }

    @Test
    void testevaluate3 (){
        double res = ExpressionEvaluator.evaluate("( ( 5 * 9 ) / ( 3 * 3 ) )");
        double expected = 5;
        assertEquals(expected, res);

    }

    @Test
    void testevaluate4 (){
        double res = ExpressionEvaluator.evaluate("( ( ( 30 - 3 * 3 ) + 5 ) / 5 )");
        double expected = 5.2;
        assertEquals(expected, res);

    }
    @Test
    void testSqrt (){
        double res = ExpressionEvaluator.evaluate("( sqrt 16 )");
        double expected = 4;
        assertEquals(expected, res);

    }

    @Test
    void testexception (){
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.check("3 + 5 & 2"), "Error: Wrong operands or operators");

    }

}
