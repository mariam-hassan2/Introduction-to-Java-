
public class Customer {
	 /*A variable that stores the first name associated with the account */
	 private String firstName;
	 /* A variable that stores the last name associated with the account */
	 private String lastName;
	 /* A variable that stores the address associated with the account */
	 private String address;
	 /*A field that stores the commission */
	 private double commission;
	 /*A variable that stores the stock instance associated with the account */
	 private Stock stockAccount;
	 /* A variable that stores that stores the cash account instance associated with
	the */
	 private Cash cashAccount;
	 /* A variable that stores the date instance associated with the */
	 private Date date;
	 /*A variable that stores the yearly interest*/
	 private double yearlyInterest;
	 /*A variable that stores the yearly capitalgains*/
	 private double yearlyCapitalGains;
	 /*A variable that stores the yearly interest gained*/
	 private double yearlyInterestGained;
	 /* A constructor that sets first name, last name, address,
	 commission amount, Stock object, Cash object, and Date object associated with
	the account*/
	 public Customer (String firstName, String lastName, String address,
	 double commission, Stock stockAccount, Cash cashAccount, Date
	date){
	 this.firstName = firstName;
	 this.lastName = lastName;
	 this.address = address;
	 this.commission = commission;
	 this.stockAccount = stockAccount;
	 this.cashAccount = cashAccount;
	 this.date = date;
	 }
	 /*A method that returns the first name associated with the account*/
	 public String getFirstName(){
	 return firstName;
	 }
	 /* A method that changes the first name associated with the account*/
	 public void setFirstName(String firstName){
	 this.firstName = firstName;
	 }

	 /*A method that returns the last name associated with the account*/
	 public String getLastName(){
	 return lastName;
	 }
	 /* A method that changes the last name associated withe account*/
	 public void setLastName(String lastName){
	 this.lastName = lastName;
	 }
	 /*A method that returns the address associated withe account*/
	 public String getAddress(){
	 return address;
	 }
	 /*A method that changes the address associated with the account*/
	 public void setAddress(String address){
	 this.address = address;
	 }
	 /* A method to return a stock instance associated with this account*/
	 public Stock getStockAccount(){
	 return stockAccount;
	 }
	 /* A method to change the stock instance associated with this account*/
	 public void setSockAccount(Stock stockAccount){
	 this.stockAccount = stockAccount;
	 }
	 /* A method to return a cash instance associated with this account*/
	 public Cash getCashAccount(){
	 return cashAccount;
	 }
	 /* A method to change the cash instance associted with this account*/
	 public void setCashAccount(Cash cashAccount){
	 this.cashAccount = cashAccount;
	 }
	 /* A method to return the commission amount for the account*/
	 public double getCommissionAmount(){
	 return commission;
	 }
	 /* A method to change the commission amount for the account*/
	 public void setCommissionAmount(double commission){
	 this.commission = commission;
	 }
	 /* A method to return a date instance associated with this account*/
	 public Date getDate(){
	 return date;
	 }
	 /* A method to return the cash balance plus the stock number of shares */
	 public double currentValue(){
	 return cashAccount.getBalance() +
	 (stockAccount.getNumberShares() * stockAccount.getCurrentPrice());
	 }
	 /* A method to add the amount to the cash balance */
	 public void deposit(double amount){
	 cashAccount.deposit(amount);
	 }
	 /* A method that if amount is less than or equal to the Cash balance, reduces
	the Cash balance by amount and returns true. Otherwise returns false and makes no
	change to the Cash balance. */
	 public boolean withdraw(double amount){
	 return cashAccount.withdraw(amount);
	 }
	 /**A method that calls the stock sells method with the customer's commission
	value amd adds the amount returned to the cash balance */
	 public void sellShares(int numShares){
	 cashAccount.setBalance(cashAccount.getBalance()+
	 stockAccount.sell(numShares, commission));
	 }
	 /* A method that calls the Stock buy method */
	 public boolean buyShares(int numShares){
	 /*if the result of calling the Stock buy method with numShares and
	 * the Customer commission amount would result in a current value
	 * that is negative, the buy method is not called and false is returned. */
	 if (stockAccount.getNumberShares() *
	 stockAccount.getCostBasis() + getCommissionAmount() > currentValue())
	 return false;
	 else{
	 /*he Stock buy method is called with the appropriate values, the Cash balance
	is reduced by the amount
	 * returned from the buy method, and true is returned*/
	 cashAccount.setBalance(cashAccount.getBalance() -
	 stockAccount.buy(numShares,getCommissionAmount()));
	 return true;
	 }
	 }
	 /**/
	 public void incrementDate(){
	 int lastMonth = getDate().getMonth();
	 int lastYear = getDate().getYear();
	 double prevBalance = getCashAccount().getBalance();
	 /*calling the associated method of the Date class to increment the date.*/
	 getDate().incrementDay();
	 int currentMonth = getDate().getMonth();
	 int currentYear = getDate().getYear();
	 /*Calling the processDay method of the Cash object.*/
	 /*Calls the processDay method of the Cash object.*/
	 cashAccount.processDay();
	 if(lastMonth != currentMonth)
	 {
	 cashAccount.processMonth();
	 yearlyInterestGained += cashAccount.getBalance() - prevBalance;
	 if(lastYear != currentYear)
	 {
	 setYearlyCapitalGainsEarned(stockAccount.getCapitalgains()-
	yearlyCapitalGainsEarned());
	 setYearlyInterestEarned(yearlyInterestGained - yearlyInterestEarned());
	 yearlyInterestGained = 0;
	 }
	 }



	 }
	 /* A method that returns the total amount of interest earned by the cash amount
	in the last year */
	 public double yearlyInterestEarned(){
	 return yearlyInterest;
	 }
	 /* A method that returns the total amount of capital gains earned by the stock
	accoun in the last year */
	 public double yearlyCapitalGainsEarned(){
	 return yearlyCapitalGains;
	 }
	 /* A method that returns the yearly earned by the stock account in the last yea*/
	 public void setYearlyInterestEarned(double yearlyInterest)
	 {
	 this.yearlyInterest = yearlyInterest;
	 }
	 /* A method that changes the total amount of capital gains earned by the stock
	account in the last yea*/
	 public void setYearlyCapitalGainsEarned(double yearlyCapitalGains)
	 {
	 this.yearlyCapitalGains = yearlyCapitalGains;
	 }
}
