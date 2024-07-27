package telran.strings;

import static org.junit.jupiter.api.Assertions.*;
import static telran.strings.Strings.*;
import org.junit.jupiter.api.Test;

public class RegularExpressionsTest {
@Test
    void javaVariableTest(){
        assertTrue("variableName".matches(javaVariable()));
        assertTrue("$variableName".matches(javaVariable()));
        assertTrue("_variableName".matches(javaVariable()));
        assertTrue("variable0Name".matches(javaVariable()));
        assertTrue("VariableName".matches(javaVariable()));
        assertTrue("variable".matches(javaVariable()));
        
        assertFalse("123variable".matches(javaVariable()));
        assertFalse("my-Variable".matches(javaVariable()));
        assertFalse("my Variable".matches(javaVariable()));
        assertFalse("variableName!".matches(javaVariable()));
        assertFalse("?variableName!".matches(javaVariable()));
        assertFalse("int".matches(javaVariable()));
        assertFalse("for".matches(javaVariable()));
        assertFalse("@name".matches(javaVariable()));
        assertFalse("{1}".matches(javaVariable()));
        assertFalse("".matches(javaVariable()));
        assertFalse("_".matches(javaVariable()));
    }
}