package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
    //@Rule
    //public ExpectedException thrown = ExpectedException.none();
 
    @Test
    public void testNegativeNumber(){
    	//thrown.expect(IllegalArgumentException.class);
    	//thrown.expectMessage(equalTo("Negatives not allowed: -1"));
    	assertEquals(0, Calculator.add("-1,2"));
    }
    @Test(expected=IllegalArgumentException.class)  //ath baeta vid svo tjekki lika a villuskilabodum
    public void testNegativeNumber2(){
        assertEquals(0, Calculator.add("1,-2,4"));
    }
}
