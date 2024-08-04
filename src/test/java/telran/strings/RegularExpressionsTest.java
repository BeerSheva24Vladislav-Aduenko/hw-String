package telran.strings;

import static org.junit.jupiter.api.Assertions.*;
import static telran.strings.Strings.*;

import org.junit.jupiter.api.Test;

public class RegularExpressionsTest {
    @Test
    void javaVariableTrueTest(){
        String regex = Strings.javaVariable();
        
        assertTrue("name".matches(regex));
        assertTrue("a_1".matches(regex));
        assertTrue("S".matches(regex));
        assertTrue("$".matches(regex));
        assertTrue("__".matches(regex)); //two underscore symbols
        assertTrue("ab_cd_$12$".matches(regex));
    }
    @Test
    void javaVariableFalseTest(){
        String regex = Strings.javaVariable();
        
        assertFalse("1name".matches(regex));
        assertFalse("1_a".matches(regex));
        assertFalse("_".matches(regex));
        assertFalse("#1".matches(regex));
        assertFalse("_*".matches(regex)); //two underscore symbols
        assertFalse("ab_cd_$12?".matches(regex));
        assertFalse("ab_cd_$12 ".matches(regex));
    }
    @Test
    void number0_300TrueTest(){
        String regex = Strings.number0_300();
        assertTrue("0".matches(regex));
        assertTrue("300".matches(regex));
        assertTrue("250".matches(regex));
        assertTrue("25".matches(regex));
        assertTrue("12".matches(regex));
        assertTrue("299".matches(regex));
        assertTrue("1".matches(regex));

    }
    @Test
    void number0_300FalseTest(){
        String regex = Strings.number0_300();
        assertFalse("00".matches(regex));
        assertFalse("301".matches(regex));
        assertFalse("01".matches(regex));
        assertFalse("00".matches(regex));
        assertFalse("1(".matches(regex));
        assertFalse("1000".matches(regex));
        assertFalse(" 20".matches(regex));
        assertFalse("1001".matches(regex));
    }
    @Test
    void ipV4OctetTrueTest(){
        String regex = Strings.ipV4Octet();
        assertTrue("0".matches(regex));
        assertTrue("00".matches(regex));
        assertTrue("000".matches(regex));
        assertTrue("10".matches(regex));
        assertTrue("100".matches(regex));
        assertTrue("255".matches(regex));
        assertTrue("199".matches(regex));
        assertTrue("249".matches(regex));
    }
    @Test
    void ipV4OctetFalseTest(){
        String regex = Strings.ipV4Octet();
        assertFalse("0000".matches(regex));
        assertFalse("t".matches(regex));
        assertFalse("-1".matches(regex));
        assertFalse("1111".matches(regex));
        assertFalse("0001".matches(regex));
        assertFalse("256".matches(regex));
        assertFalse("300".matches(regex));
        assertFalse("*".matches(regex));
        assertFalse("1 ".matches(regex));
    }
    @Test
    void ipV4AddressTrueTest() {
        String regex = Strings.ipV4Address();
        assertTrue("0.0.0.0".matches(regex));
        assertTrue("255.255.255.255".matches(regex));
    }
    @Test
    void ipV4AddressFalseTest() {
        String regex = Strings.ipV4Address();
        assertFalse("0.0.0".matches(regex));
        assertFalse("0.0.0+0".matches(regex));
        assertFalse("0".matches(regex));
        assertFalse("0.-".matches(regex));
        assertFalse("0.0.0*0".matches(regex));
        assertFalse("0.0.0 0".matches(regex));
    }
    @Test
    void stringWithJavaNamesTest() {
        String names = "123 1a _ abs int enum null lmn";
        String expected = "abs lmn";
        assertEquals(expected, Strings.stringWithJavaNames(names));
    }

    @Test
    void isArithmeticExpressionTrueTest() {
        String exprTrue1 = "1+2*3";
        String exprTrue2 = "2*3";
        String exprTrue3 = "2*(2-1)*3";
        String exprTrue4 = "5*(3+(2/2))";
        String exprTrue5 = "55*(313+(233/24)/2)";

        String exprFalse1 = "1+2*3++";
        String exprFalse2 = "2*(2--1)*3)";
        String exprFalse3 = "number";
        String exprFalse4 = "2*3**(2-1)*3)";
        String exprFalse5 = "2*3*()";
        String exprFalse6 = "2+3#";
        String exprFalse7 = "2+3+number=5";


        assertTrue(isArithmeticExpression(exprTrue1));
        assertTrue(isArithmeticExpression(exprTrue2));
        assertTrue(isArithmeticExpression(exprTrue3));
        assertTrue(isArithmeticExpression(exprTrue4));
        assertTrue(isArithmeticExpression(exprTrue5));

        assertFalse(isArithmeticExpression(exprFalse1));
        assertFalse(isArithmeticExpression(exprFalse2));
        assertFalse(isArithmeticExpression(exprFalse3));
        assertFalse(isArithmeticExpression(exprFalse4));
        assertFalse(isArithmeticExpression(exprFalse5));
        assertFalse(isArithmeticExpression(exprFalse6));
        assertFalse(isArithmeticExpression(exprFalse7));

    }   

    @Test
    void isArithmeticExpressionTrueTest2() {
        assertTrue(Strings.isArithmeticExpression("((a + b) /2.5) + x"));
        assertTrue(Strings.isArithmeticExpression("a + b/2.5+ x"));
        assertTrue(Strings.isArithmeticExpression("(a + b)/2.5+ (x)"));
        assertTrue(Strings.isArithmeticExpression("(a + b)/2.5+ 120/0 * 27"));
        assertTrue(Strings.isArithmeticExpression("(((a + b)/2.5)+ x)"));
    }
    @Test
    void isArithmeticExpressionFalseTest() {
        assertFalse(Strings.isArithmeticExpression("(((a + b) /2.5) + x"));
        assertFalse(Strings.isArithmeticExpression("a + b/2.5+ _"));
        assertFalse(Strings.isArithmeticExpression("(a + b))/2.5+ (x)"));
        assertFalse(Strings.isArithmeticExpression("(a + b)#2.5+ 120/0 * 27"));
        assertFalse(Strings.isArithmeticExpression("(((a + b)/2 5)+ x)"));
        assertFalse(Strings.isArithmeticExpression("(((a (+) b)/25)+ x)"));
        assertFalse(Strings.isArithmeticExpression("(((a + b)/25)+ int)"));
    }
}