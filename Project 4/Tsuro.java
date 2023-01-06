
	import javafx.application.Application;
	import javafx.application.Platform;
	import javafx.stage.Stage;
	import javafx.scene.Scene;
	import javax.swing.JFrame;
	import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.FlowPane;
	import javafx.scene.layout.GridPane;
	import javafx.scene.control.Button;
	import javafx.event.EventHandler;
	import javafx.event.ActionEvent;
	import javafx.scene.paint.Color;
	/*  @author Mariam Hassan
	 */
	/*A class that represents Tsuro aand extends teh application class*/
	public class Tsuro extends Application{
	  // A field that stores the width of the board
	  private static int gridWidth = getGridWidth();
	   // A field that stores the height of the board
	  private static int gridHeight = getGridHeight();
	  //A field for the buttons on the board
	  private TsuroButton[][] buttonArray = new TsuroButton[gridHeight][gridWidth];
	  // A field that stores the number of rows of the button where the stone is located
	  private int rowNumber;
	  // A field that stores the number of column of the button where the stone is located
	  private int columnNumber;
	  // A field that storws the number of rows of the button where the stone is located
	  private int rowIndex;
	    //Afield that stores the row number of the selected button on the board 
	  private int columnIndex;
	  // A field that represents the button that is selected in the player's hand
	  private TsuroButton b;
	  // A field that stores the buttons of the first player 
	   private TsuroButton[] hand1 = new TsuroButton[handSize];
	    // A field that stores the buttons of the second player 
	   private TsuroButton[] hand2 = new TsuroButton[handSize];
	  // int playernumber
	//A field that stores the paths. it was used in roatting the buttons when 
	   //the player aoule clicks on them 
	  private int[] paths = {2,3,5,4,6,7,1,0};
	  //A field that stores the endpoints of te button. it was used in rotating the 
	buttons when 
	   //the player aoule clicks on them 
	  private int[] newEndpoints1= new int[8];
	  //A field that stores the paths. it was used in rotating the buttons when 
	   //the player aoule clicks on them 
	  private int[] newEndpoints2= new int[8];
	  //A field that stores the endpoint of the stone of player 1
	  private int stoneEndpoint = 6;
	  private boolean legalMove = false;
	  //A field that checks if the player is trying to make a legal move
	  private boolean legalButton = false;
	  // A field that stores the number of moves
	  private int move = 0;
	  // A field that stores the handsize of the player 
	  private static int handSize = getHandSize();
	  
	  /** helper method: it gets the handsize of the player 
	   * returns the handsize of the player
	   */
	  public static int getHandSize(){
	    return handSize;
	  }
	     /** helper method: it gets the height of the grid of the board
	   * returns the height of the board
	   */
	  public static int getGridHeight(){
	    return gridHeight;
	  }
	   /** helper method: it get the width of the grid of the board
	   * @param int Height
	   */
	   public static int getGridWidth(){
	    return gridWidth;
	  }
	   
	    /** helper method: it sets the handsize of the player
	   * @param int handSize
	   */
	  public static void setHandSize(int size){
	    handSize = size;
	  }
	   /** helper method: it sets the width of the grid of the board
	   * @param int width
	   */
	  public static void setGridWidth(int width){
	    gridWidth = width;
	  }
	 /** helper method: it sets the height of the grid of the board
	   * @param int Height
	   */
	  public static void setGridHeight(int height){
	    gridHeight = height;
	  }
	   /** helper method: it moves the tile from the player's hand
	     * and changes the arrays of the button in the player's hand
	   * @param TsuroButton c
	   */
	  public void movingTile(TsuroButton c){
	    //copy the tile from the button in the player's hand to the board
	    c.setConnections(this.b.getConnections());
	    // change the arrays of the button in the player's hand
	    this.b.setConnections(this.b.makeRandomConnectionArray());
	  }
	    /** helper method: it moves the stone to the endpoint of the path on the button
	   */
	  public void moveInternally(){ 
	     //Update the endpoint where the stone is located 
	    stoneEndpoint = buttonArray[columnNumber][rowNumber].getConnections()
	[stoneEndpoint];
	    //adds a stone to the new endpoint where the stone is located 
	    buttonArray[columnNumber][rowNumber].addStone(Color.BLUE,stoneEndpoint);    
	  }
	     /** helper method: it moves the stone from a button to another 
	       * when there is a path that connects those buttons 
	   */
	  public void moveExternally(){
	    //remove teh stone from the old stonelocation
	  buttonArray[columnNumber][rowNumber].removeStone(stoneEndpoint);
	  //update tle column number of the button where the stoen is located 
	  columnNumber = columnNumber + mapPlan(stoneEndpoint)[0];
	 //update tle row number of the button where the stoen is located 
	  rowNumber = rowNumber + mapPlan(stoneEndpoint)[1];
	 //call the helper method moveStoneBetweenTwoTiles
	   moveStoneBetweenTwoTiles();
	 //call the helper method moveInternally
	  moveInternally();
	  
	 
	  }
	/** helper method: it checks if there is a button next to the button where the 
	stone is located
	  * this method helps in moving the stone along paths of more than one button
	 * when there is a path that connects those buttons 
	   */
	  public boolean isAdjacent(){
	    try{
	      // Returns true is there is a button next to the button where the stone is 
	located 
	    if(buttonArray[(columnNumber + mapPlan(stoneEndpoint)[0])]
	         [(rowNumber + mapPlan(stoneEndpoint)[1])].getConnections() != null){
	  return true;
	    }
	// Returns true is there is no button next to the button where the stone is located
	  return false;
	    }
	    //Using try and catch to check in case reaching the boundaries of the board
	    catch(Exception e){
	      return false;
	}
	  }
	/** helper method: it moves the stone from the endpoint of a path of one button to 
	  * the start point of a path of adjacent button
	  * returns the stone location 
	   */
	  public int moveStoneBetweenTwoTiles(){
	   // if the stone if at endpoint 2, then it moves it to startpoint 6 of the adjacent button 
	    if(this.stoneEndpoint == 2){
	      this.stoneEndpoint =  6;
	    }
	    // if the stone if at endpoint 3, then it moves it to startpoint 7 of the adjacent button    
	     else if(this.stoneEndpoint == 3){
	      this.stoneEndpoint = 7;
	    }
	    // if the stone if at endpoint 4, then it moves it to startpoint 0 of the adjacent button     
	    else if(this.stoneEndpoint == 4){
	      this.stoneEndpoint = 0;
	    }
	   // if the stone if at endpoint 5, then it moves it to startpoint 1 of the adjacent button     
	    else if(this.stoneEndpoint == 5){
	      this.stoneEndpoint = 1;
	    } 
	    // if the stone if at endpoint 6, then it moves it to startpoint 2 of the adjacent button    
	    else if(this.stoneEndpoint == 6){
	      this.stoneEndpoint = 2;
	    }
	   // if the stone if at endpoint 7, then it moves it to startpoint 3 of the adjacent button     
	    else if(this.stoneEndpoint == 7){
	      this.stoneEndpoint = 3;
	    }
	   // if the stone if at endpoint 0, then it moves it to startpoint 4 of the adjacent button     
	    else if(this.stoneEndpoint == 0){
	      this.stoneEndpoint = 4;
	    }   
	   // if the stone if at endpoint 1, then it moves it to startpoint 5 of the adjacent button 
	    else if(this.stoneEndpoint == 1){
	      this.stoneEndpoint = 5;
	    } 
	    
	    //returns the point where the stone is located 
	    return stoneEndpoint;
	  }
	 /** helper method: the method checks where the stone is located to determine the 
	index of the 
	   * buttons around the button where the stone is located 
	   * this method is used to help determine where the next legal move for the player
	  * @param: the endpoint where the stone is located 
	  * returns an array of the column index and row index. 
	  * (When they get added to the column number and the row number of the button,
	  * they help in determining the  legal next move
	   */
	  public int[] mapPlan(int endPoint){
	    // if the stone is at endpoint 2 or 3, then it returns an array of 1 and 0 which indicates
	    //that the next move for the player is the button above the current button where the stone 
	    //is located 
	     if(stoneEndpoint == 2 || stoneEndpoint == 3){
	       return new int[]{1,0};
	        }
	      // if the stone is at endpoint 5 or 3, then it returns an array of 0 and 1 which indeicates
	    //that the next move for the player is the button at the right side of the current button where the stone 
	    //is located    
	     if(stoneEndpoint == 4 || stoneEndpoint == 5){
	       return new int[]{0,1};
	      }     
	    // if the stone is at endpoint 0 or 1, then it returns array of 0 and -1 which indicates
	    //that the next move for the player is the button below the current button where the stone 
	    //is located 
	     if(stoneEndpoint == 0 || stoneEndpoint == 1){
	       return new int[]{0,-1};
	      }          
	    //otherwise, the next move for the player is the button at the left 
	     // side of the the current button where the stone 
	    //is located 
	      return new int[]{-1,0}; 
	     
	  }
	     
	  /*helper method: indexing the button on the board that is selected 
	   * @param: TsuroButton c*/
	  public void findButton(TsuroButton c){
	    // Creating two for loops that go through the buttons of the board
	    for(int i = 0; i < getGridHeight();i++){
	      for(int j = 0; j < getGridWidth(); j++){
	        //it finds the index of the button that is selected on the board
	        if(c == buttonArray[i][j]){
	          //it stores the rownumber in rowIndex
	          rowIndex = j;
	          //it stores the columnnumber in columnIndex          
	          columnIndex = i;
	          return;
	        }
	      }  
	  }
	  }
	  /* helper method: checks if the column is empty
	   * @param: column number
	   */
	  public boolean columnEmpty(int column){
	    //creates a for loop that goes through the columns of the board
	    for(int i = 0; i < getGridWidth() ; i++){
	       
	      if(buttonArray[column][i].getConnections()!= null){
	    //returns false if the column is not empty
	       return false; 
	      }
	    }
	     //returns true if the column is  empty   
	    return true;
	  } 
	  //helper method: checks if this is the first game player played a legal move
	  public boolean firstPlay(TsuroButton c){
	    // if the number of moves is zero, then it's the player's first play
	    if(move == 0){
	   
	    for (int u = 0; u < getGridWidth(); u++){
	      //checks is the first player is placing the button into the first column
	    if( c == buttonArray[0][u] && (columnEmpty(0))){
	      return true;
	    }
	   // checks if the second player is placing the button into the sixth column
	    //if(c == buttonArray[indexedButton[0]][5] && (columnEmpty(5))){
	     // return true;
	    //}     
	    }
	    }
	    return false; 
	  } 
	  
	      
	/*helper method: checks is teh player is placing the button in the right location
	 * @param: TsuroButton c*/
	    
	  public boolean legalButton(TsuroButton c){
	// checks if it's not the first play for the player   
	    if(move != 0){
	      // checks if it's not the first play for the player 
	    if(c == buttonArray[(columnNumber + mapPlan(stoneEndpoint)[0])]
	         [(rowNumber + mapPlan(stoneEndpoint)[1])]){
	      // returns true if the player is putting the button in the right position 
	      return true;
	    }
	  }
	 // returns false if the player is putting the button in the wrong position    
	     return false;
	  }
	  
	 
	/*creating a start method 
	 * @param: Stage primaryStage
	 * */
	  public void start(Stage primaryStage){
	    // Creating a gridPane for the board
	    GridPane grid = new GridPane();
	    // Creating a boarderpane for the board
	    BorderPane layout = new BorderPane();
	    // Setting the scene of the board
	    Scene scene = new Scene(grid);
	    
	    // Creating a 2d array of the buttons for the board
	    //TsuroButton[][] buttonArray = new TsuroButton[6][6];
	    for(int i =0; i < getGridHeight();i++){
	      for(int j = 0; j < getGridWidth(); j++){
	        buttonArray[i][j] = new TsuroButton(75,75);
	        //Adding the buttons to the grid 
	        grid.add(buttonArray[i][j],i,j); 
	      }
	    }
	    // creating a scene for the stage 
	    primaryStage.setScene(scene);
	 // creating a show for the stage 
	    primaryStage.show();
	// settinf a title for the stage   
	    primaryStage.setTitle("board");
	        //creating the buttons for the board using two for loops 
	            for(int i =0; i < getGridHeight();i++){
	              for(int j = 0; j < getGridWidth(); j++){
	                //setting actions for the buttons on the board
	                buttonArray[i][j].setOnAction(new EventHandler<ActionEvent>() {
	                  public void handle(ActionEvent e){
	                    //checks which button is selcted on the board
	                    TsuroButton c = (TsuroButton)e.getSource();
	                    // checks if it's the first play for the player 
	                       if((firstPlay(c)) == true){
	                          // finds the buttons that is selcted on the board
	                         findButton(c);
	                         // stores the row number of the button
	                         rowNumber = rowIndex;
	                         // stores the column number of the button
	                         columnNumber = columnIndex;   
	                         // calls the helper method movingtile to copy the tile 
	                         // from the player' hand to the board
	                         movingTile(c);
	                         // calls the helper method to moves the stone to the 
	endpoint of the path
	                         moveInternally();
	                         
	                        // incrementing the number of moves by 1 
	                         move++;
	                        //switch the player number
	                       //playerNumber= (playerNumber)%1
	                        
	                       }
	                       else{
	                         // calls the legal button to check if the player is 
	placing the button into 
	                         //the right button 
	                         if((legalButton(c)) == true){
	                        // calls the helper method movingtile to copy the tile 
	                         // from the player' hand to the board  
	                         movingTile(c);
	                         //calls the helpermehtod isAdjacent to check if there is 
	                         // a button 
	                         while(isAdjacent() == true){
	                        // calls the helper method MoveExetrnally to move the stone
	between the buttons
	                         moveExternally();
	                         }
	                        //increment the number of moves by 1 
	                         move++;
	                       //switch the player number
	                       //playerNumber= (playerNumber)%1
	                         }
	                         
	                       }
	                       }
	                  
	                });
	              }
	}
	    //for(int y=0; y<2; y++){
	    // Creating stage for the first player
	     Stage player1 = new Stage();
	     //Creating the gridpane for the first player
	    GridPane gridPlayer1 = new GridPane();
	     //Creating a scene for the first player
	    Scene scene1 = new Scene(gridPlayer1);
	    //setting the scene for the first player
	    player1.setScene(scene1);
	    //setting a show for the first player 
	    player1.show();
	   //settign a title for the first player 
	    player1.setTitle("Player1");
	    //creating a single array for the buttons of the first player
	    for(int k = 0; k < handSize; k++){
	        hand1[k] = new TsuroButton(50,50);
	        // adding the buttons to the gridpane of the first player
	        gridPlayer1.add(hand1[k],k,1);
	        //Giving the hand random connection of arrays
	        hand1[k].setConnections(hand1[k].makeRandomConnectionArray());
	        //setting the stone at the starting position for the tile 
	        hand1[k].addStone(Color.BLUE,6);
	     //setting actions for the buttons of player 1
	        hand1[k].setOnAction(new EventHandler<ActionEvent>() {
	      public void handle(ActionEvent e) {
	            b = (TsuroButton)e.getSource();
	          // highlights the button when it gets selected 
	            if(b.getBackgroundColor() == Color.YELLOW){
	              // rotates the button when the player double clicks on it 
	              for(int i=0;i<8;i++){
	                for(int j =0; j<8;j++){
	                  if(b.getConnections()[i]==j){
	                    newEndpoints1[i]= paths[j];
	                  }
	                }}
	              for(int k = 0; k < 8; k++){
	                newEndpoints2[paths[k]] = newEndpoints1[k];
	                b.setConnections(newEndpoints2);
	              }
	            return;
	          } 
	          // highlights the button when it gets selected 
	           b.setBackgroundColor(Color.YELLOW);
	          // highlights another button when it gets selected 
	          for(int c = 0 ; c < handSize; c++){
	            if(hand1[c].equals(b))
	              continue;
	            if(hand1[c].getBackgroundColor() == Color.YELLOW){
	              hand1[c].setBackgroundColor(Color.WHITE);
	            }
	      }
	      }
	        });
	                             }
	    
	  // Creating stage for the second player
	     Stage player2 = new Stage();
	     //Creating the gridpane for the first player
	    GridPane gridPlayer2 = new GridPane();
	     //Creating a scene for the first player
	    Scene scene2 = new Scene(gridPlayer2);
	    //setting the scene for the second player
	    player2.setScene(scene2);
	    //setting the show for the second player 
	    player2.show();
	    //setting the title for the second player 
	    player2.setTitle("Player2");
	    //creating a single array for the buttons of the first player
	    //TsuroButton[] hand2 = new TsuroButton[handSize];
	    for(int k = 0; k < handSize; k++){
	        hand2[k] = new TsuroButton(50,50);
	        // adding the buttons to the gridpane of the first player
	        gridPlayer2.add(hand2[k],k,1);
	        //Giving the hand random connection of arrays
	        hand2[k].setConnections(hand2[k].makeRandomConnectionArray());
	        //setting the stone at the starting position for the tile 
	        hand2[k].addStone(Color.GREEN,2);
	    //setting action for the buttons 
	        hand2[k].setOnAction(new EventHandler<ActionEvent>() {
	      public void handle(ActionEvent e) {       
	            b = (TsuroButton)e.getSource();
	            // highlights the button when it gets selected 
	            if(b.getBackgroundColor() == Color.YELLOW){
	            // rotates the button when the player double clicks on it 
	              for(int i=0;i<8;i++){
	                for(int j =0; j<8;j++){
	                  if(b.getConnections()[i]==j){
	                    newEndpoints1[i]= paths[j];
	                    //b.getConnections()[i]= paths[j];
	                  }
	                }}
	              for(int k = 0; k < 8; k++){
	                newEndpoints2[paths[k]] = newEndpoints1[k];
	                b.setConnections(newEndpoints2);
	              }
	            return;
	          } 
	           // highlights the button when it gets selected 
	           b.setBackgroundColor(Color.YELLOW);
	         // highlights another button when it gets selected 
	          for(int c = 0 ;c < handSize;c++){
	            if(hand2[c].equals(b))
	              continue;
	            if(hand2[c].getBackgroundColor() == Color.YELLOW){
	              hand2[c].setBackgroundColor(Color.WHITE);
	          }
	        }
	      }
	    });
	    }
	  }
	  
	  
	     /**
	   * Launch the GUI
	   */
	    public static void main(String[] args) {
	      // if the user enters 3 values, then they get set for 
	      //gridwidth, gridheight and the handsize
	      if(args.length == 3){
	        setGridHeight(Integer.parseInt(args[0]));
	        setGridWidth(Integer.parseInt(args[1]));
	        setHandSize(Integer.parseInt(args[2]));
	        }
	       // if the user enters 2 values, then they get set for 
	      //gridwidth, and gridheight   
	        if(args.length == 2){
	        setGridHeight(Integer.parseInt(args[0]));
	        setGridWidth(Integer.parseInt(args[1]));
	        setHandSize(3);
	        }
	     // if the user does not enter any values, then they get set for 
	      //gridwidth, gridheight and the handsize
	        if(args.length == 0){
	        setGridWidth(6);
	        setGridHeight(6);
	        setHandSize(3);
	        
	        }
	       Application.launch(args);
	    
	    }
	}     
	  
}
	
