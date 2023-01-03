
public class Date {
	 /* A variable that stores the day of the date */
	 private int day;
	 /* A variable that stores the month of the date */
	 private int month;
	 /* A variable that stores the year of the date */
	 private int year;
	 /* A constructor that initializes the Date object with the given inputs*/
	 public Date(int day, int month, int year){
	 this.day = day;
	 this.month = month;
	 this.year = year;
	 }
	 /*A method that returns the day of the date (has to be between 1 and 31)*/
	 public int getDay(){
	 return day;
	 }
	 /*A method that changes the day of the date (has to be between 1 and 31)*/
	 public void setDay(int day){
	 this.day = day;
	 }
	 /*A method that returns the month of the date(has to be between 1 and 12) */
	 public int getMonth(){
	 return month;
	 }
	 /*A method that changes the month of the date(has to be between 1 and 12) */
	 public void setMonth(int month){
	 this.month = month;
	 }
	 /*A method that returns the year of the date */
	 public int getYear(){
	 return year;
	 }
	 /*A method that changes the year of the date */
	 public void getYear(int year){
	 this.year = year;
	 }
	 /*A method that adds one to the day of the date.
	 * If the day exceeds the number of days for the month (assume no leap years),
	 * the day is set to 1 and the month is incremented. If the month exceeds 12,
	 * the month is set to 1 and the year is incremented.*/
	 public void incrementDay(){
	 setDay(getDay()+1);
	 if (getMonth() == 2){
	 if (getDay() > 28){
	 setDay(1);
	 setMonth(getMonth() + 1);
	 }

	 }
	 else if(getMonth() == 4||getMonth() == 6 ||
	 getMonth() == 9|| getMonth() == 11){
	 if (getDay() > 30){
	 setDay(1);
	 setMonth(getMonth() + 1);
	 }
	 }
	 else if(getMonth() == 12){
	 if (getDay() > 31){
	 setDay(1);
	 setMonth(1);
	 year = year + 1;
	 }

	 }
	 else{
	 if (getDay() > 31){
	 setDay(1);
	 setMonth(getMonth()+1);
	 }
	 }

	 }
	 /* Overriding the inherited toString method to give an appropriate string
	representation of this date. */
	 @Override
	 public String toString() {
	 String[] months = {"January", "February", "March", "April", "May", "June",
	"July", "August", "September", "October", "November", "December"};
	 return months[month-1] + day + "," + year;
	 }
	 /* Overriding the inherited equals method to indeicate that two dates are equal
	if they are the same day, month, and year */
	 public boolean equals(Date D){
	 if (D.getDay() == day && D.getMonth() == month && D.getYear() == year){
	 return true;
	 }
	 else{
	 return false;
	 }
	 }
}
