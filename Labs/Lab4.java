
public class Lab4 {
	public static void main(String[]args){
		//isDayLightSavings(11,);
	}
	/*A method that returns the maximum of two values
	 * @param value1: represents the first input
	 * @param value2: represents the second input*/
	public static double maxDouble(double value1, double value2) {
		if(value1 > value2) {
			return value1;
		}
		else {
			return value2;
		}
	}
	/*A method that returns the median of three inputs
	 * @param value1: represents the first input
	 * @param value2: represents the second input
	 * @param value3: represents the third input*/	
	public static double middleValue(double value1, double value2, double value3){
		if(value1 > value2 && value1 < value3) {
			return value1;
		}
		else if(value2 > value3 && value2 < value1) {
			return value2;
		}
		else {
			return value3;
		}
		
	}
	public int roundDouble(double value){
		return (int)value;	
	}
	  /*
	   * Return true of the given date/time is daylight savings.
	   * Daylight savings time begins 2am the second Sunday of March and ends 2am the first Sunday of November.
	   *
	   * @param month - represents the month with 1 = January, 12 = December
	   * @param date - represents the day of the month, between 1 and 31
	   * @param day -  represents the day of the week with 1 = Sunday, 7 = Saturday
	   * @param hour - represents the hour of the day with 0 = midnight, 12 = noon
	   *
	   * Precondition: the month is between 1 and 12, the date is between 1 and 31, the day is between 1 and 7
	   *                and the hour is between 0 and 23.
	   */
	public static boolean isDayLightSavings(int month, int date, int day, int hour) {
		if(month == 1 || month == 2 || month == 12) {
			return false;
		}
		else if(month == 11) { 
				if(day == 11 && date < 8 && day == 1 && hour <= 2){
					return true;
				}
				else {
					return false;
				}
		}

		else if(month == 3) { 
			if(date > 7) {
				return false;
			}
			else if((date - day) >= 0) {
				if(day == 1 && hour < 2){
					return true;
				}
				else {
					return false;
				}
			}
			/*else if(day == 3 && date < 8 && day == 1 && hour > 2){
				return true;
			}
			else {
				return false;
			}
		}*/
			
		else{
			return true;
		}
		}
	}
}
	