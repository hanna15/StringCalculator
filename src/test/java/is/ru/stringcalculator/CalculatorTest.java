package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CalculatorTest {

	public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringCalculator.CalculatorTest");
    }

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}	

	@Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
    @Test
    public void testNewLineBetweenNumbers(){
    	assertEquals(6, Calculator.add("1\n2,3"));
    }
    @Test
    public void testNewLineBetweenNumbers2(){
        assertEquals(6, Calculator.add("1\n2\n3"));
    }
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
 
    @Test
    public void testNegativeNumber(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negatives not allowed: -1");
    	assertEquals(0, Calculator.add("-1,2"));
    }
    @Test
    public void testNegativeNumber2(){
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Negatives not allowed: -4,-5");
        assertEquals(0, Calculator.add("2,-4,3,-5"));
    }
     @Test
     public void testNumOver1000(){
        assertEquals(2, Calculator.add("1001,2"));
    }
     @Test
     public void testDiffDelim(){
        assertEquals(3, Calculator.add("//%\n1%2"));
    }
     @Test
     public void testDiffDelim2(){
        assertEquals(12, Calculator.add("//;\n1;2;9"));
    }
}
