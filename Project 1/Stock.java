
public class Stock {
	/* A variable that stores the company name for the stock*/
	 private String name;
	 /* A variable that stores the stock market tickersymbol */
	 private String tickerSymbol;
	 /* A variable that stores the current price for a share of a stock */
	 private double price;
	 /* A variable that stores the number of shares owned by a stock */
	 private double number;
	 /* A variable that stores the cost basis for the owned shares*/
	 private double cost;
	 /* A variable that stores the total capital gains earned so far */
	 private double capitalGains;
	 /* A variable that */
	 private double commission;
	 /* A constructor to set the tickersymbol and the current price associated with
	the stock */
	 public Stock(String tickerSymbol, double price){
	 this.tickerSymbol = tickerSymbol;
	 this.price = price;
	 }
	 /* A constructor to set the company name, tickersymbol and the current price
	associated with the stock */
	 public Stock(String name, String tickerSymbol, double price){
	 this.name = name;
	 this.tickerSymbol = tickerSymbol;
	 this.price = price;
	 }
	 /* A method to get the company's name*/
	 public String getCompanyName(){
	 return name;
	 }
	 /* A method to change the company's name for the stock*/
	 public void setCompanyName(String name){
	 this.name = name;
	 }
	 /*A method to return the stock market ticker symbol*/
	 public String getTickersymbol(){
	 return tickerSymbol;
	 }
	 /*A method to return the current price for a share of the stock*/
	 public void setTickerSymbol(String tickerSymbol){
	 this.tickerSymbol = tickerSymbol;
	 }
	 /*A method to set the current price of a share of the stock*/
	 public double getCurrentPrice( ){
	 return price;
	 }
	 /*A method to change the current price of a share of the stock*/
	 public void setCurrentPrice(double price){
	 this.price = price;
	 }
	 /*A method to return the number of shares owned by a stock*/
	 public double getNumberShares(){
	 return number;
	 }
	 /*A method to return the number of shares owned by a stock*/
	 public void setNumberShares(double number){
	 this.number = number;
	 }
	 /*A method to return the cost basis for the owned shares*/
	 public double getCostBasis(){
	 return cost;
	 }
	 /*A method to change the cost basis for the owned shares*/
	 public void setCostBasis(double cost){
	 this.cost = cost;
	 }
	 /*A method to return the total capital gains earned so far*/
	 public double getCapitalgains(){
	 return capitalGains;
	 }
	 /*A method to return the total capital gains earned so far*/
	 public void setCapitalgains(double capitalGains){
	 this.capitalGains = capitalGains;
	 }
	 /* A method to increase the number of shares owned in the stock by numShares; it
	increases the cost basis for the owned shares by(numShares x the current price) +
	commission. Returns the (numShares x the current price) + commission. */
	 public double buy(int numShares, double commission){
	 setNumberShares(getNumberShares() + numShares);
	 setCostBasis(getCostBasis() + getNumberShares() * getCurrentPrice()
	 + commission);
	 return numShares * getCurrentPrice() + commission;
	 }


	 /* A method that returns zero if numShares is greater than the number currently
	owned.
	 * Otherwise, the number of shares owned is decreased by numShares.
	 * The cost basis is decreased by the ratio of numShares to the number of shares
	originally owned. */
	 public double sell(int numShares, double comission){
	 if (numShares > getNumberShares()){
	 return 0;
	 }
	 else{
	 setCostBasis(getCostBasis() - numShares/getNumberShares());
	 setCapitalgains(getCapitalgains() + ((numShares*getCurrentPrice()-
	 commission)-
	numShares/getNumberShares()));
	 setNumberShares(getNumberShares()- numShares);


	 }
	 return ((numShares * getCurrentPrice() - comission));
	 }

	 double split(int ratioNumerator, int ratioDemonimator){

	 if(ratioNumerator <= 0 || ratioDemonimator <= 0){
	 return 0;
	 }
	 double newNumShares = getNumberShares() * ratioNumerator/ratioDemonimator;
	 double frac = newNumShares - Math.floor(newNumShares);
	 setNumberShares(newNumShares - frac);

	 setCostBasis(getCostBasis() - frac/getNumberShares());
	 setCapitalgains(getCapitalgains() +
	 ((frac * getCurrentPrice())- frac/getNumberShares()));


	 return frac * getCurrentPrice();
	 }

}
