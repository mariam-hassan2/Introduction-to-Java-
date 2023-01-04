// importing for NoSuchElementException
import java.util.NoSuchElementException;
/*A class that represents the second project*/ 
public class HW2{
	 // A field that stores the average of all values
	 //in a single array. It takes a single array of
	 //double and returns the average of it's values 
	 private double average;
	 /*A method that calculates the average of all 
	 * the values in an array */
	 public static double average(double[] array){
	 // A variable that stores the sum of the values 
	 //in the array
	 double total = 0;
	 // Checking if the length of the array is zero
	 if (array.length == 0){
	 //Throwing an exception
	 throw new NoSuchElementException();
	 
	 }
	 /*A for loop that calculates the sum of the 
	 * values in the array*/
	 for(int i = 0; i < array.length; i++){
	 total = array[i] + total;
	 }
	 // Calculating the average of the values in the array
	 double average = total / array.length;
	 //returning the average of the values in the array
	 return average;
	 }
	 
	 /*Methd 2: A method that calculates the average of
	 * all the values in a double array */
	 // It takes a single array of double and 
	 //returns the average of it's values 
	 public static double average(double[][] array){
	 // A variable that stores the sum of the values 
	 // in the array
	 double total = 0;
	 // A variable that stores the length of the array
	 double length = 0;
	 // Checking if the length of the array is zero
	 if (array.length == 0){
	 // Throwing an exception
	 throw new NoSuchElementException();}
	 // A for loop that goes throw the array to calculate the
	 // the sum of the values in it
	 for(int i = 0; i < array.length; i++){
	 
	 for(int j = 0; j < array[i].length; j++){
	 total = array[i][j] + total ;
	 }
	 length = array[i].length + length; 
	 }
	 //Calculating the average of the values in the array
	 double average = total/length;
	 // returning the average of the array
	 return average;
	 }
	 
	 /*Method 3: A method that counts the number of words
	 * in a sentence */
	 public static int countWords(String term){
	 // A variable that stores the number of words in
	 //the sentence
	 int total = 0;
	 // A variable that checks whether the character 
	 //represents a start of a new word or belongs to a previous word
	 Boolean isWord = true;
	 // a for loop that goes through all the characters 
	 for(int i = 0; i < term.length(); i = i + 1){
	 // Checking if it's a charcter by marking that it's not a space
	 // if isWord = true, then it's a beginning of a new word and it increases 
	 // the number of words by 1
	 if((term.charAt(i) != ' ') && isWord){
	 isWord = false;
	 total = total + 1;
	 }
	 // Checking if it's is a space. Hence, there is a new word
	 else if (term.charAt(i) == ' '){
	 isWord = true;
	 
	 }
	 }
	 // returning the total number of words
	 return total;
	 }
	 
	 //helper method for method 4
	 // A method the counts the length of the first word 
	 //in a sentence starting from a given starting position
	 /* for this method to work, the start position has to index 
	 * a character in the sentence*/
	 private static int wordLength(String sentence, int startPos){
	 // A variable that checks whether it's still counting the
	 // characters in a word or the word has finished
	 Boolean counting = true;
	 // A variable that stores the total number of characters
	 // in a word
	 int total = 0;
	 // Start position is a variable where the indexing
	 // starts checking for teh first word
	 int i = startPos;
	 // while loop that counts the number of characters
	 while(i < sentence.length() && counting){
	 // Checking if the character is not a space. Hence, 
	 // it increments the number of words by 1. 
	 if((sentence.charAt(i) != ' ')){
	 total = total + 1;
	 }
	 // Otherwise, the word has finished and counting is 
	 // reseted to break the while loop
	 else{
	 counting = false;
	 }
	 // An increment for the while loop
	 i = i + 1;
	 }
	 // Returning the length of the first word in the senence
	 return total;
	 }
	 
	 //helper method for method 4
	 //A method that removes spaces at the end of the sentence 
	 // it takes a string and return a string after removing
	 // the spaces at the end of the sentence
	 private static String removeRightspaces(String sentence){
	 //A variable for counting number of spaces at the end
	 // of the sentence
	 int counter = 0;
	 // A variable that traverses the sentence from the end 
	 // to check the number of spaces at the end of the sentence
	 int endPosition = sentence.length() - 1;
	 // Reconstructing the sentence
	 StringBuilder newSentence= new StringBuilder();
	 // A while loop that goes through the sentnce and counts 
	 // the number of spaces at the end
	 while(sentence.charAt(endPosition) == ' '){
	 // it increments by 1 when there is a space
	 counter = counter + 1;
	 // it decrements by 1 when there is a space
	 endPosition = endPosition -1;
	 }/// Checking if the there is no space at the end of the sentence
	 // So it returns the same sentence
	 if(counter == 0){
	 return sentence;
	 }
	 // A for loop for reconstructing the sentence without
	 // adding the extra spaces at the end of the sentence
	 for(int x = 0; x < sentence.length()- counter; x = x + 1){
	 newSentence.append(sentence.charAt(x)); 
	 }
	 // returnning the new sentnce 
	 return newSentence.toString();
	 }
	 /*Method 4: it takes a string and a desired length and
	 * returns a string after truncating at a word limit that does not 
	 exceed the desired length*/
	 public static String truncate(String sentence, int desiredLength){
	 // A variable that stores the number of remaining
	 // desired length as it's constructing the new sentnce
	 // to ensure that it's not exceeding the desired length
	 int remLength = desiredLength;
	 // Reconstructing the new sentence
	 StringBuilder newSentence= new StringBuilder();
	 // A variable that stores the length of a word
	 int wordSize;
	 // A variable that checks whether it's the first word 
	 // or not
	 Boolean firstWord = true;
	 
	 /*checking if the length of the string is smaller than
	 * or equal to the desired length*/
	 if (sentence.length() <= desiredLength){
	 return removeRightspaces(sentence);
	 }
	 // a for loop that goes through the sentence for 
	 // reconstructing to match the desired length
	 for (int j = 0; j < sentence.length(); j = j + 1){
	 // Checking if there is a space. Hence,
	 // it decrements the number of remaining desired length
	 // and reconstructs the space
	 if (sentence.charAt(j) == ' '){
	 remLength = remLength - 1;
	 newSentence.append(sentence.charAt(j));
	 }
	 // Otherwise, it calls the the wordLength method
	 else{
	 wordSize = wordLength(sentence, j);
	 // Checking if the remaining desired length is less than the word length
	 // and that it's not the first word. Hence, it calls the helper method
	 //(removeRightSpaces) to remove the spaces at the end of the sentence
	 if(remLength < wordSize && !firstWord){
	 return removeRightspaces(newSentence.toString());
	 
	 }
	 //Decreasing the remaining desired length by the length of the words
	 remLength = remLength - wordSize;
	 // Reseting the wordsize variable 
	 wordSize = wordSize + j;
	 // while loop that copies the word after checking that it does not exceed
	 // the desired length
	 while(j < wordSize ){
	 //reconstructing the sentence
	 newSentence.append(sentence.charAt(j));
	 j = j + 1;
	 }
	 //reseting the first word to be false 
	 firstWord = false;
	 j = j - 1;
	 }
	 // Checking if the remaining length equals to or is smaller than zero
	 // and it's not the first word. Hence, it calls the helper method 
	 //for removing the spaces at the end of sentece and returns the sentnce
	 if (remLength <= 0 && !firstWord){
	 return removeRightspaces(newSentence.toString());
	 }
	 
	 }
	 //returning the truncated sentnce
	 return removeRightspaces(newSentence.toString());
	 }
	 
	 /*Method 5 that takes a string phrase and an integer width and 
	 * reconstrucs the sentnce to add spaces between words evenly
	 so that the length of the reconstructed sentence with the
	 addeed spaces match the width*/
	 public static String padString(String phrase, int width){
	 // Reconstructing the new phrase
	 StringBuilder newPhrase = new StringBuilder();
	 // a variable that stores the number of spaces that 
	 // need to be added to make the length of the new phrase
	 // matches the desired width
	 int addedSpaces = width - phrase.length();
	 // A variable that counts the number of places that has spaces 
	 // in the sentence by calling the counting words method 
	 // and subtracting one from it's output
	 int numSpaces = countWords(phrase) - 1;
	 // a variable that stores the numebr of extra spaces
	 int extraSpaces;
	 // A variable that checks if there is more than one consective 
	 //space in the original sentence. 
	 Boolean newSpace = true;
	 
	 // A for loop that goes through the sentence to add the
	 // new extra spaces
	 for(int i = 0; i < phrase.length(); i = i + 1){
	 // Checking if there is more than one consective space. Hence,
	 // the newSpace is responsible for adding the extra spaces at 
	 // a certain place(between two words) only one time after the
	 // first space
	 if (phrase.charAt(i) == ' ' && newSpace){ 
	 // reconstring the sentence to add a space
	 newPhrase.append(' ');
	 // reseting newSpace to be false
	 newSpace = false;
	 // Calculating the number of extra spaces that can
	 // be added between two words
	 extraSpaces = addedSpaces/numSpaces;
	 // Recalculating the total number of added spaces between words 
	 // for the next iteration
	 addedSpaces = addedSpaces - extraSpaces;
	 // decremeneting the number of spaces by 1
	 numSpaces = numSpaces - 1;
	 // A for loop to add the extra spaces between the words
	 for(int j = 0; j < extraSpaces; j = j + 1){
	 // Reconstructing the sentnce to include the added spaces 
	 // between the words
	 newPhrase.append(' ');
	 
	 }
	 
	 }
	 // Checking if there is a space and it's not the first
	 // space. Hence, it does not add extra spaces again
	 else if(phrase.charAt(i) == ' ' && !newSpace){
	 newPhrase.append(' ');
	 }
	 // Otherwise, newSpace is reseted to be true and 
	 // and the sentence is reconstruced 
	 else{
	 newPhrase.append(phrase.charAt(i));
	 newSpace = true;
	 }
	 
	 
	 }
	 // returning the new sentnce after adding the extra spaces
	 return newPhrase.toString();
	 }
	 
	//helper method for method 6
	//A method that removes spaces in the beginning of the sentence
	//and truncates the string starting from the start position 
	// till the end
	 private static String subString(String line, int startPos){
	 
	 // reconstructing the new line
	 StringBuilder newLine= new StringBuilder();
	 // Checking if the start position exceeds the length of 
	 // line.
	 if(startPos >= line.length()){
	 return "";
	 } 
	 // a while loop to track the start position by checking if 
	 // there is a spce
	 while(line.charAt(startPos) == ' '){
	 startPos = startPos + 1;
	 // Checking if the start position exceeds the length
	 // of the line 
	 if(startPos >= line.length()){
	 return "";
	 } 
	 }
	 //
	 // A loop for reconstructing the new line
	 for(int x = startPos; x < line.length(); x = x + 1){
	 newLine.append(line.charAt(x)); 
	 }
	 // Returning the new reconstructed line 
	 return newLine.toString(); 
	 }
	 
	 
	 /* Method 6: it takes a string and an int lengthWidth. it
	 * reconstructs the string to have a length of the length width */
	 public static void prettyPrint(String line, int lineWidth){
	 
	// Calling the helper method to remove the spaces in the beginning
	// of the sentence
	 String newLine = subString(line,0);
	//A variable that stores a part of the string
	// that will get truncated and padded to be displayed.
	 String finalLine;
	// A variable that stores the psoition wherer we stop after
	// the truncation 
	 int finalPos;
	// while loop that checks if the length of the new line
	// is more than zero. Hence, it recontructs the string 
	 while (newLine.length() > 0){
	 finalLine = truncate(newLine, lineWidth);
	 finalPos = finalLine.length();
	 finalLine = padString(finalLine,lineWidth);
	 // printing the string after reconstucting it to that each line
	 // has the length of the width entered
	 System.out.println(finalLine);
	 
	 // Calling the helper method (subString) to recontruct a
	 // new sentence without the truncated part
	 newLine = subString(newLine, finalPos);
	 }
	 }
}
 
 
 