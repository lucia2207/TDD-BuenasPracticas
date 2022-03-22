import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StringCalculatorTest {

    public StringCalculator stringCalculatorInstance = new StringCalculator();

    @Test
    public void stringIsEmplty(){
        try {
            Assertions.assertEquals(0,stringCalculatorInstance.add(""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void singleNumberReturnItsValueTest() {
        try {
            Assertions.assertEquals(1,stringCalculatorInstance.add("1"));
            Assertions.assertEquals(2,stringCalculatorInstance.add("2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void twoNumbersCommaDelimitedReturnsTheSumTest(){
        try {
            Assertions.assertEquals(4,stringCalculatorInstance.add("2,2"));
            Assertions.assertEquals(2,stringCalculatorInstance.add("1,1"));
            Assertions.assertEquals(3,stringCalculatorInstance.add("1,2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sameThatBeforeButNewLineDelimitedTest(){
        try {
            Assertions.assertEquals(2,stringCalculatorInstance.add("0\n2"));
            Assertions.assertEquals(2,stringCalculatorInstance.add("1\n1"));
            Assertions.assertEquals(3,stringCalculatorInstance.add("1\n2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sameThatBeforeButAllDelimitersWorksTest(){
        try {
            Assertions.assertEquals(6,stringCalculatorInstance.add("1\n2,3"));
            Assertions.assertEquals(7,stringCalculatorInstance.add("1,2\n4"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void negativeNumbersThrowsAnExceptionTest(){
        try {
            Assertions.assertThrows(Exception.class,()->{stringCalculatorInstance.add("-1,-1");});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void greaterThan1000AreIgnoredTest(){
        try {
            Assertions.assertEquals(1002,stringCalculatorInstance.add("2,1000"));
            Assertions.assertEquals(2,stringCalculatorInstance.add("2,1001"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void singleCharDelimiterTest() {
        try {
            Assertions.assertEquals(1002, stringCalculatorInstance.add("#2#1000"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
