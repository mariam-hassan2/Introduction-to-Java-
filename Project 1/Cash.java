
public class Cash {
	/* A variable that stores the current balance in the account */
	 private double balance;
	 /* variable that stores the interest rate applied to positive balances */
	 private double savingsRate;
	 /* A variable that stores the interest rate applied to negative balances */
	 private double loanRate;
	 /* A variable that stores the loan limit for the account */
	 private double loanLimit;
	 /* A variable that stores the overdraft penalty for the account */
	 private double overdraftPenalty;
	 /*A variable that stores the current montly interest*/
	 private double monthlyInterest;
	 /* A field to check if the */
	 private boolean isPenalty;
	 /* A constructor that sets the savings rate, loan rate,
	 loan limit, and overdraft penalty associated with the account. */
	 public Cash(double savingsRate, double loanRate, double loanLimit, double
	overdraftPenalty){
	 this.savingsRate = savingsRate;
	 this.loanRate = loanRate;
	 this.loanLimit = loanLimit;
	 this.overdraftPenalty = overdraftPenalty;
	 }

	 /* A method that returns the current balance in the account */
	 public double getBalance(){
	 return balance;
	 }
	 /* A method that changes the current balance in the account */
	 public void setBalance(double balance){
	 this.balance = balance;
	 }
	 /* A method that returns the interest rate applied to positive balances */
	 public double getSavingsRate(){
	 return savingsRate;
	 }
	 /* A method to change the interest rate applied to positive balances */
	 public void setSavingsRate(double savingsRate){
	 this.savingsRate = savingsRate;
	 }
	 /* A method return the interest rate applied to negative balances */
	 public double getLoanRate(){
	 return loanRate;
	 }
	 /* A method to change the interest rate applied to negative balances */
	 public void setLoanRate(double loanRate){
	 this.loanRate = loanRate;
	 }
	 /* A method to return the loan limit for the account */
	 public double getLoanLimit(){
	 return loanLimit;
	 }
	 /* A method to change the loan limit for the account */
	 public void setLoanLimit(double loanLimit){
	 this.loanLimit = loanLimit;
	 }
	 /* A method to return the overdraft penalty for the acoount */
	 public double getOverdraftPenalty(){
	 return overdraftPenalty;
	 }
	 /* A method to change the overdraft penality for the account */
	 public void setOverdraftPenalty(double overdraftPenalty){
	 this.overdraftPenalty = overdraftPenalty;
	 }
	 /* A method to increase the balance by amount */
	 public void deposit(double amount){
	 balance = balance + amount;
	 }

	 /* A method to set the monthly interest */
	 public double getMonthlyInterest(){
	 return monthlyInterest;
	 }
	 /* A method to change the monthly interest */
	 public void setMonthlyInterest(double monthlyInterest){
	 this.monthlyInterest = monthlyInterest;
	 }
	 /*A method to to check if the amount if less than or equal
	 current price, it reduces the balance by amount and returns true
	 otherwise, it returns false and makes no changes to the balance */
	 public boolean withdraw(double amount){
	 if (amount <= getBalance()){
	 setBalance(getBalance()- amount);
	 return true;
	 }
	 else{
	 return false;
	 }
	 }
	 /* A method to reduce the current balance by amount */
	 public void transfer(double amount){
	 setBalance(getBalance() - amount);
	 }
	 /*A method to update the Monthly interest */
	 public void processDay(){
	 /* if the account balance is positive, multiplies the balance by the savings
	rate (divided by 365)
	 * and adds the amount to the current monthly interest.*/
	 if (getBalance() > 0){
	 //interest += getBalance() * getSavingRate() / 365
	 setMonthlyInterest(getMonthlyInterest() +
	 (getBalance() * getSavingsRate()/ 365));
	 }
	 /*If the account balance is negative, multiplies the balance by the loan rate
	(divided by 365)
	 * and adds the amount to the current monthly interest.*/
	 else if (getBalance() < 0){
	 setMonthlyInterest(getMonthlyInterest() +
	 (getBalance() * getLoanRate()/ 365));
	 }
	 /**/
	 if(getBalance() + getMonthlyInterest() < 0 &&
	 getBalance() + getMonthlyInterest() < - getLoanLimit())
	 {
	 isPenalty = true;
	 }
	 }
	 /*A method to set the monthly interest*/
	 public void processMonth(){
	 /*the overdraft penalty should be subtracted from the balance if there was ever
	 * a day in the last month in which the account balance plus the current monthly
	interest
	 * was negative and exceeded the negation of the loan limit.*/
	 if(isPenalty)
	 {
	 setBalance(getBalance() - getOverdraftPenalty());
	 }
	 /*: adds the current monthly interest to the balance and sets the current
	monthly interest to zero.*/
	 setBalance(getBalance() + getMonthlyInterest());
	 setMonthlyInterest(0);
	 isPenalty = false;
	 }
		 
}
