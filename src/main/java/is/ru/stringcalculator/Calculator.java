package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")) {
			return sum(splitNumbers(text, ",|\n"));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		int num = Integer.parseInt(number);
		if(num < 0) {
			throw new IllegalArgumentException("Negatives not allowed: " + number);
		}
		return num;
	}

	private static String[] splitNumbers(String numbers, String delimeter){
	    return numbers.split(delimeter);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }



}
