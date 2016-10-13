package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains("[")) {
			String[] splitted = splitNumbers(text, "\n");
			String delim = splitted[0];
			String the_text = splitted[1];
			return sum(splitNumbers(the_text, delim));
		}
		else if(text.contains(",") || text.contains("\n")) {
			return sum(splitNumbers(text, ",|\n"));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		int num = Integer.parseInt(number);
		if(num > 1000) {
			num = 0;
		}
		return num;
	}

	private static String[] splitNumbers(String numbers, String delimeter){
	    return numbers.split(delimeter);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
 	    String msg = "";
        for(String number : numbers){
        	if(toInt(number) < 0) {
        		if (msg == "") {
        			msg = number;
        		}
        		else {
        			msg = msg + "," + number;
        		}
        	}
        	else {
        		total += toInt(number);
        	} 
		}
		if(msg != "") {
			throw new IllegalArgumentException("Negatives not allowed: " + msg);
		}
		return total;
    }
}
